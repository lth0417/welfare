package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class ProjectEntity {
    private String id;
    private String title;
    private String content;
    private String userId;
    private Double resMoney;
    private Double nowMoney;
    private String fileId;
    private String status;
    private String checkUser;
    private String checkStatus;
    private String deleteFlag;
    private String createTime;
    private String updateTime;
}
