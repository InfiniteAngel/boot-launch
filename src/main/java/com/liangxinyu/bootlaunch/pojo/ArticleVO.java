package com.liangxinyu.bootlaunch.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVO {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
}
