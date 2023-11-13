package com.lostsheep.technology.learning.async.upload.config;

import com.lostsheep.technology.learning.async.upload.pipe.Pipeline;
import com.lostsheep.technology.learning.async.upload.pipe.PipelineWrapper;
import com.lostsheep.technology.learning.async.upload.processor.Processor;
import com.lostsheep.technology.learning.async.upload.processor.ProcessorWrapper;
import com.lostsheep.technology.learning.async.upload.util.ReflexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <b><code>CustomBeanConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
@Configuration
public class CustomBeanConfig {

    @Value("${processor.namespace}")
    private String processorPath;

    @Value("${pipeline.namespace}")
    private String pipelinePath;

    @Bean("processor")
    public ProcessorWrapper getProcessors() {
        List<Processor> processors = ReflexUtils.initializationObjs(processorPath, Processor.class);
        ProcessorWrapper processorWrapper = new ProcessorWrapper();
        processorWrapper.setSubProcessors(processors);
        return processorWrapper;
    }

    @Bean("pipeline")
    public PipelineWrapper getPipelines() {
        List<Pipeline> pipelines = ReflexUtils.initializationObjs(pipelinePath, Pipeline.class);
        PipelineWrapper pipelineWrapper = new PipelineWrapper();
        pipelineWrapper.setPipelines(pipelines);
        return pipelineWrapper;
    }
}
