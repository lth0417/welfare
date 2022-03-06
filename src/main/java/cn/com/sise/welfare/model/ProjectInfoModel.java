package cn.com.sise.welfare.model;

import lombok.Data;

@Data
public class ProjectInfoModel {
    private String id;
    private String title;
    private String content;
    private Double resMoney;
    private Double nowMoney;
    private String name;
    private String sfzh;
    private String phone;
    private String checkUser;
    private String status; //0:待审核；1:通过；2:不通过；99:其他
    private String orgCode;
    private String orgName;
    private String filePath;
    private String createTime;
    private String updateTime;
}
