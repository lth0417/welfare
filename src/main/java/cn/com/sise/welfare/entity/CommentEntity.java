package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class CommentEntity {
    private String id;
    private String projectId;
    private String userId;
    private String userIdTo;
    private String content;
    private String createTime;
}
