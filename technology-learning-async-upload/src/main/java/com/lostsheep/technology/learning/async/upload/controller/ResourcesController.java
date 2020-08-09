package com.lostsheep.technology.learning.async.upload.controller;

import com.google.common.collect.Lists;
import com.lostsheep.technology.learning.async.upload.domain.FileInfo;
import com.lostsheep.technology.learning.async.upload.service.AsyncUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ResourcesController(AsyncUploadService asyncUploadService) {
        this.asyncUploadService = asyncUploadService;
    }

    @PostMapping({"", "/"})
    public List<FileInfo> uploadFiles(@RequestParam("resources") MultipartFile[] files) {
        Assert.isTrue(files.length > 0, "资源文件不能为空!");

        String projectPath = getProjectPath();
        log.info("projectPath:{}", projectPath);

        String resourcesPath = mkdir(projectPath);
        log.info("resourcesPath:{}", resourcesPath);

        // 存储临时文件
        List<FileInfo> fileInfos = saveFiles(files, resourcesPath);

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
        List<FileInfo> fileInfos = Lists.newArrayList();
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

                    Optional.of(singleFile)
                            .filter(File::exists)
                            .ifPresent(f -> {
                                fileInfo.setSuccessOrNot(1);
                                fileInfoBuilder.append("文件[")
                                        .append(optFileName)
                                        .append("]已存在, 请勿重复上传;");
                            });

                    fileInfo.setResult(fileInfoBuilder.toString());
                    fileInfos.add(fileInfo);
                });
        
        return fileInfos;
    }

}
