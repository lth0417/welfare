package cn.com.sise.welfare.model;

import lombok.Data;

@Data
public class UserInfoModel {
    private String id;
    private String account;
    private String password;
    private String role;
    private String name;
    private String sfzh;
    private String nation;
    private String sex;
    private String birth;
    private String phone;
    private String area;
    private String orgCode;
    private String orgName;
    private String balance;
    private String status;
    private String filePath;
    private String createTime;
    private String updateTime;
}
