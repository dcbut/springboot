package com.dcxuexi.domian;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
