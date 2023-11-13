package com.lostsheep.technology.learning.async.upload.pipe;

import java.util.List;

/**
 * <b><code>PipelineWrapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class PipelineWrapper {

    private List<Pipeline> pipelines;

    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<Pipeline> pipelines) {
        this.pipelines = pipelines;
    }
}
