package cn.com.sise.welfare.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class OrgSearchModel extends Page<OrgSearchModel> {
    private String id;
    private String orgCode;
    private String orgName;
    private String address;
    private String linkman;
    private String phone;
    private String email;
    private String createTime;
    private String status;
    private String reason;
}
