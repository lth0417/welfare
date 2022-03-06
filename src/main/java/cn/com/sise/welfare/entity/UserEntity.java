package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class UserEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String account;
    private String password;
    private String roleId;
    private String name;
    private String sfzh;
    private String nation;
    private String sex;
    private String birth;
    private String phone;
    private String area;
    private String orgId;
    private Double balance;
    private String status;
    private String createTime;
    private String updateTime;
    private String salt;

}
