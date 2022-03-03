package cn.com.sise.welfare.entity;

import lombok.Data;

@Data
public class MoneyEntity {
    private String id;
    private String projectId;
    private String userId;
    private String donateMoney;
    private String donateTime;
}
