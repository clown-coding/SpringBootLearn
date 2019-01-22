package com.clown.rabbit.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable {

  @Id
  private String id;            //ID

  private String mobile;        //手机号码

  private String password;      //密码

  private String nickname;      //昵称

  private String sex;           //性别  0: 未填写 1:男 2:女

  private String email;         //邮箱

  private Date regdate;         //注册日期

  private Date updatedate;      //修改日期

  private Date lastdate;        //最后登陆日期


}
