package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_role")
public class RoleEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String role;
    private String roleName;
}
