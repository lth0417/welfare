package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
    private String createTime;
}
