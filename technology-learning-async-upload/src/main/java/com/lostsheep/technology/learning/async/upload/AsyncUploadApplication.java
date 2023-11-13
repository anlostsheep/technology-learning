package com.lostsheep.technology.learning.async.upload;

import com.lostsheep.technology.learning.async.upload.config.SpringContextUtils;
import com.lostsheep.technology.learning.async.upload.pipe.Pipeline;
import com.lostsheep.technology.learning.async.upload.pipe.PipelineWrapper;
import com.lostsheep.technology.learning.async.upload.processor.Processor;
import com.lostsheep.technology.learning.async.upload.processor.ProcessorWrapper;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

/**
 * <b><code>AsyncUploadApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:09.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@EnableAsync
@SpringBootApplication
public class AsyncUploadApplication {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder()
                .sources(AsyncUploadApplication.class)
                // 指定非 web 模式
                .web(WebApplicationType.NONE)
                .run(args);
        SpringContextUtils.setApplicationContext(context);

        ProcessorWrapper processor = (ProcessorWrapper) SpringContextUtils.getBean("processor");
        List<Processor> subProcessors = processor.getSubProcessors();
        subProcessors.forEach(Processor::process);

        PipelineWrapper pipeline = (PipelineWrapper) SpringContextUtils.getBean("pipeline");
        List<Pipeline> pipelines = pipeline.getPipelines();
        pipelines.forEach(Pipeline::send2TargetSource);
    }
}
