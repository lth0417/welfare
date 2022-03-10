package cn.com.sise.welfare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_file")
public class FileEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String targetId;
    private String filePath;
    private String createTime;
    private String updateTime;
}
