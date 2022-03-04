package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_project")
public class ProjectEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String title;
    private String content;
    private String userId;
    private Double resMoney;
    private Double nowMoney;
    private String fileId;
    private String status;
    private String checkUser;
    private String checkStatus;
    private String deleteFlag;
    private String createTime;
    private String updateTime;
}
