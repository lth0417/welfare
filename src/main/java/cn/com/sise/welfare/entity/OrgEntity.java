package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_org")
public class OrgEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String orgCode;
    private String orgName;
    private String address;
    private String linkman;
    private String phone;
    private String email;
    private String filePath;
    private String createTime;
    private String status;//0:待审核；1：通过；2：未通过
    private String reason;
}
