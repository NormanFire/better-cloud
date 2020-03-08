package com.better.cloud.common.entity;

import com.better.cloud.common.entity.wiki.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lius
 * @description
 * @date 2020/3/6
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentTree extends Tree<Document>{
    private String name;
    private Integer type;
    private String path;
    private Integer sequence;
    private Integer createUserId;
    private Integer editUserId;
    private Integer documentId;
}
