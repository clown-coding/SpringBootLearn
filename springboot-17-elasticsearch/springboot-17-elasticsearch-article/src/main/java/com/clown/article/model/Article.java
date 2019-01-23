package com.clown.article.model;

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
@Table(name = "article")
@DynamicInsert
@DynamicUpdate
public class Article implements Serializable {

  @Id
  private String id;            //ID

  private String columnid;      //专栏ID

  private String userid;        //用户ID

  private String title;         //标题

  private String content;       //文章正文

  private String image;         //文章封面

  private Date createtime;      //发表日期

  private Date updatetime;      //修改日期

  private String ispublic;      //是否公开 0:不公开 1:公开

  private String istop;         //是否置顶 0:不置顶 1:置顶

  private Long visits;          //浏览量

  private Long thumbup;         //点赞数

  private Long comment;         //评论数

  private String state;         //审核状态 0:未审核 1:审核通过

  private String channelid;     //所属频道

  private String url;           //url

  private String type;          //类型    0:分享 1:专栏

}
