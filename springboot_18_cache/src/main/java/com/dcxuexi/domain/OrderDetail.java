package com.dcxuexi.domain;

import lombok.Data;

/***
 * @Title OrderDetail
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/10/3 20:39
 * @Version 1.0.0
 */
@Data
public class OrderDetail {
    private Integer id;
    private String userName;
    private Integer userId;
    private String tunnelName;
    private String tunnelSn;
    private Integer amount;
    private String startTime;
    private Integer yddingdan;
    private Integer ltdingdan;
    private Integer G;
    private Integer successnum;
    private Integer isExecute;
    private String execTime;
}
