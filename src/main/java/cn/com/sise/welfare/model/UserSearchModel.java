package cn.com.sise.welfare.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class UserSearchModel extends Page<UserSearchModel> {
    private String id;
    private String account;
    private String password;
    private String salt;
    private String sfzh;
    private String nation;
    private String sex;
    private String birth;
    private String phone;
    private String area;
    private String roleId;
    private String role;
    private String name;
    private String orgCode;
    private String orgName;
    private Double balance;
    private String status;
    private String createTime;
    private String updateTime;
    private String deleteFlag;

}
