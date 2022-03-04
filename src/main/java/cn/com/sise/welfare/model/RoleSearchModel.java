package cn.com.sise.welfare.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class RoleSearchModel extends Page<RoleSearchModel> {
    private String id;
    private String role;
    private String roleName;
}
