package com.lostsheep.technology.learning.java8.recursion;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b><code>Tree</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/6/7
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
@Slf4j
public class TreeStream {

    public static void main(String[] args) {
        List<TreeNode> treeNodeList = Arrays.asList(
                new TreeNode(1, "根节点", 0),
                new TreeNode(2, "子节点1", 1),
                new TreeNode(3, "子节点1.1", 2),
                new TreeNode(4, "子节点1.2", 2),
                new TreeNode(5, "根节点1.3", 2),
                new TreeNode(6, "根节点2", 1),
                new TreeNode(7, "根节点2.1", 6),
                new TreeNode(8, "根节点2.2", 6),
                new TreeNode(9, "根节点2.2.1", 7),
                new TreeNode(10, "根节点2.2.2", 7),
                new TreeNode(11, "根节点3", 1),
                new TreeNode(12, "根节点3.1", 11)
        );

        List<TreeNode> nodeList = treeNodeList.stream()
                .filter(t -> t.getParentId() == 0)
                .peek(treeNode -> treeNode.setChildren(getChildren(treeNode, treeNodeList)))
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(nodeList));
    }

    private static List<TreeNode> getChildren(TreeNode root, List<TreeNode> targetList) {
        return targetList.stream()
                .filter(node -> root.getNodeId().equals(node.getParentId()))
                .peek(targetNode -> targetNode.setChildren(getChildren(targetNode, targetList)))
                .collect(Collectors.toList());
    }
}
