package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class OrgEntity {
    private String id;
    private String orgCode;
    private String orgName;
    private String address;
    private String linkman;
    private String phone;
    private String email;
    private String create_time;
}
