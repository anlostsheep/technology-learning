package com.lostsheep.technology.learning.async.upload.processor;

import java.util.List;

/**
 * <b><code>ProcessorWrapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ProcessorWrapper {

    private List<Processor> subProcessors;

    public List<Processor> getSubProcessors() {
        return subProcessors;
    }

    public void setSubProcessors(List<Processor> subProcessors) {
        this.subProcessors = subProcessors;
    }
}
