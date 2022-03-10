package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class FileEntity {
    private String id;
    private String targetId;
    private String filePath;
    private String createTime;
    private String updateTime;
}
