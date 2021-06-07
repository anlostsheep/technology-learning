package com.lostsheep.technology.learning.java8.recursion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <b><code>TreeNode</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/6/7
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    
    private Integer nodeId;
    private String nodeName;
    private Integer parentId;
    private List<TreeNode> children;

    public TreeNode(Integer nodeId, String nodeName, Integer parentId) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.parentId = parentId;
    }
}
