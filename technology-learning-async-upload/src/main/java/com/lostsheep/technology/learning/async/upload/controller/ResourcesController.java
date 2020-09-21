package com.lostsheep.technology.learning.async.upload.controller;

import com.google.common.collect.Lists;
import com.lostsheep.technology.learning.async.upload.domain.BaseRequest;
import com.lostsheep.technology.learning.async.upload.domain.BaseResponse;
import com.lostsheep.technology.learning.async.upload.domain.FileInfo;
import com.lostsheep.technology.learning.async.upload.domain.FileUploadInfo;
import com.lostsheep.technology.learning.async.upload.service.AsyncUploadService;
import com.lostsheep.technology.learning.async.upload.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * <b><code>ResourcesController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:15.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@RestController
@Slf4j
@RequestMapping("/resources")
public class ResourcesController {

    private final AsyncUploadService asyncUploadService;
    private final BaseService<BaseRequest, BaseResponse> baseService;

    public ResourcesController(AsyncUploadService asyncUploadService,
                               BaseService<BaseRequest, BaseResponse> baseService) {
        this.asyncUploadService = asyncUploadService;
        this.baseService = baseService;
    }

    @GetMapping("/call")
    public Callable<ResponseEntity<String>> uploadFile1() {

        return () -> {
            log.info("callable request");

            return ResponseEntity.ok("request success");
        };

    }

    @PostMapping("/files")
    public DeferredResult<BaseResponse> uploadResources(@RequestParam("files") MultipartFile[] files) {

        return baseService.processService(() -> {
            String projectPath = this.getProjectPath();
            log.debug("项目目录:{}", projectPath);

            String directoryPath = this.mkdir(projectPath);
            log.debug("项目存储目录创建成功");

            List<FileInfo> fileInfos = this.saveFiles(files, directoryPath);

            FileUploadInfo fileUploadInfo = FileUploadInfo.builder()
                    .fileInfos(fileInfos)
                    .build();
            fileUploadInfo.setMessage("文件上传成功!");
            fileUploadInfo.setResponseTime(LocalDateTime.now());

            return fileUploadInfo;
        });
    }

    @PostMapping({"", "/"})
    public List<FileInfo> uploadFiles(@RequestParam("resources") MultipartFile[] files) {
        Assert.isTrue(files.length > 0, "资源文件不能为空!");

        String projectPath = getProjectPath();
        log.info("projectPath:{}", projectPath);

        String resourcesPath = mkdir(projectPath);
        log.info("resourcesPath:{}", resourcesPath);

        // 存储临时文件
        List<FileInfo> fileInfos = this.saveFiles(files, resourcesPath);

        // 异步处理数据
        asyncUploadService.asyncUploadResources(millisecondTime());

        return fileInfos;
    }

    private String getProjectPath() {
        ApplicationHome applicationHome = new ApplicationHome(ResourcesController.class);
        File dir = applicationHome.getDir();
        return dir.getParent();
    }

    private String mkdir(String projectPath) {
        File resources = new File(projectPath + File.separator + "resources");
        Optional.of(resources)
                .filter(f -> !f.exists())
                .ifPresent(f -> {
                    synchronized (resources) {
                        boolean mkdirsResult = f.mkdirs();
                        log.info("mkdirs():{}", mkdirsResult);
                        Assert.isTrue(mkdirsResult, "文件存储目录创建失败!");
                    }
                });

        return resources.getAbsolutePath();
    }

    private String millisecondTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return dateTimeFormatter.format(now);
    }

    private List<FileInfo> saveFiles(MultipartFile[] multipartFiles, String resourcesPath) {
        log.debug(multipartFiles == null ? "异步线程丢失文件" : "文件读取正常");

        List<FileInfo> fileInfos = Lists.newArrayList();

        Assert.isTrue(Objects.nonNull(multipartFiles), "文件集合不能为空!");
        Arrays.stream(multipartFiles)
                .forEach(file -> {
                    StringBuilder fileInfoBuilder = new StringBuilder();
                    FileInfo fileInfo = FileInfo.builder().build();

                    String originalFilename = file.getOriginalFilename();
                    fileInfo.setOriginalName(originalFilename);

                    String optFileName = Optional.ofNullable(originalFilename)
                            .filter(name -> !StringUtils.isEmpty(name))
                            .orElseGet(() -> {
                                String randomName = UUID.randomUUID().toString();
                                fileInfo.setRandomName(randomName);
                                fileInfo.setUuid(randomName);
                                fileInfoBuilder.append("文件没有原始名称;");
                                return randomName;
                            });
                    fileInfo.setStoreName(optFileName);

                    File singleFile = new File(resourcesPath + File.separator + optFileName);

                    Optional.of(singleFile)
                            .filter(File::exists)
                            .ifPresent(f -> {
                                fileInfo.setSuccessOrNot(1);
                                fileInfoBuilder.append("文件[")
                                        .append(optFileName)
                                        .append("]已存在, 请勿重复上传;");
                            });
                    
                    Optional.of(singleFile)
                            .filter(f -> !f.exists())
                            .ifPresent(f -> {
                                try {
                                    file.transferTo(f);
                                    fileInfo.setSuccessOrNot(1);
                                    fileInfoBuilder.append("文件[")
                                            .append(optFileName)
                                            .append("]存储成功;");
                                } catch (IOException e) {
                                    log.error("文件[{}]存储写入异常", optFileName, e);
                                    fileInfo.setSuccessOrNot(0);
                                    fileInfoBuilder.append("文件[")
                                            .append(optFileName)
                                            .append("]存储失败;");

                                }
                            });

                    fileInfo.setResult(fileInfoBuilder.toString());
                    fileInfos.add(fileInfo);
                });

        return fileInfos;
    }

}
