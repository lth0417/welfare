package cn.com.sise.welfare.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class ProjectSearchModel extends Page<ProjectSearchModel> {
    private String id;
    private String title;
    private String content;
    private String name;
    private String sfzh;
    private String phone;
    private String checkUser;
    private String status;
    private String orgCode;
    private String orgName;
    private String timeLeft;
    private String timeRight;
}
