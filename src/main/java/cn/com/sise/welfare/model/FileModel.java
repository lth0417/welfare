package cn.com.sise.welfare.model;

import cn.com.sise.welfare.entity.FileEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lth
 * @Date: 2022/03/10/20:07
 * @Description:
 */
@Data
public class FileModel extends Page<FileEntity> {
    private String id;
    private String targetId;
    private String filePath;
    private String createTime;
    private String updateTime;
}
