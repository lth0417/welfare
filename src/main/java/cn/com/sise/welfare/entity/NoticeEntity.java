package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class NoticeEntity {
    private String id;
    private String noticeTitle;
    private String noticeContent;
    private String fileId;
    private String status;
    private String createTime;
    private String updateTime;
}
