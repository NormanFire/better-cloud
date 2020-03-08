package com.better.cloud.common.utils;

import com.better.cloud.common.entity.Tree;
import com.better.cloud.common.entity.router.VueRouter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrBird
 */
@Slf4j
public class TreeUtil {

    private final static String TOP_NODE_ID = "0";

    /**
     * 用于构建菜单或部门树
     *
     * @param nodes nodes
     * @return <T> List<? extends Tree>
     */
    public static <T> List<? extends Tree<?>> build(List<? extends Tree<T>> nodes) {
        if (nodes == null) {
            return null;
        }
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach(node -> {
            String pid = node.getParentId();
            if (pid == null || TOP_NODE_ID.equals(pid)) {
                topNodes.add(node);
                return;
            }
            for (Tree<T> n : nodes) {
                String id = n.getId();
                if (id != null && id.equals(pid)) {
                    if (n.getChildren() == null) {
                        n.initChildren();
                    }
                    n.getChildren().add(node);
                    node.setHasParent(true);
                    n.setHasChildren(true);
                    n.setHasParent(true);
                    return;
                }
            }
            if (topNodes.isEmpty()) {
                topNodes.add(node);
            }
        });
        return topNodes;
    }

    public static <T> List<? extends Tree<?>> recursionBuild(List<? extends Tree<T>> nodes){

        if (nodes == null){
            return null;
        }
        List<Tree<T>> trees = recursionBuild(TOP_NODE_ID, nodes);
        nodes.forEach((node)->{
            if (StringUtils.isEmpty(node.getId())){
                trees.add(node);
            }
        });
        return trees;
    }

    private static <T> List<Tree<T>> recursionBuild(String root,List<? extends Tree<T>> nodes){
        List<Tree<T>> topNodes = new ArrayList<>();
        nodes.forEach((node)->{
            if (StringUtils.equals(node.getParentId(),root)){
                List< Tree<T>> trees = recursionBuild(node.getId(), nodes);
                node.setChildren(trees);
                topNodes.add(node);
            }
        });
        return topNodes;
    }


    /**
     * 构造前端路由
     *
     * @param routes routes
     * @param <T>    T
     * @return ArrayList<VueRouter < T>>
     */
    public static <T> List<VueRouter<T>> buildVueRouter(List<VueRouter<T>> routes) {
        if (routes == null) {
            return null;
        }
        List<VueRouter<T>> topRoutes = new ArrayList<>();
        VueRouter<T> router = new VueRouter<>();
        routes.forEach(route -> {
            String parentId = route.getParentId();
            if (parentId == null || TOP_NODE_ID.equals(parentId)) {
                topRoutes.add(route);
                return;
            }
            for (VueRouter<T> parent : routes) {
                String id = parent.getId();
                if (id != null && id.equals(parentId)) {
                    if (parent.getChildren() == null) {
                        parent.initChildren();
                    }
                    parent.getChildren().add(route);
                    parent.setAlwaysShow(true);
                    parent.setHasChildren(true);
                    route.setHasParent(true);
                    parent.setHasParent(true);
                    return;
                }
            }
        });
        VueRouter<T> router404 = new VueRouter<>();
        router404.setName("404");
        router404.setComponent("error-page/404");
        router404.setPath("*");

        topRoutes.add(router404);
        return topRoutes;
    }
}