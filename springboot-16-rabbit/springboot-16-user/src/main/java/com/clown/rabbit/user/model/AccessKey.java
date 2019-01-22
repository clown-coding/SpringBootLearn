package com.clown.rabbit.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accesskey")
public class AccessKey implements Serializable {

    @Id
    private String id;
    private String accessKeyId;
    private String accessKeySecret;
    private String templateCode;
    private String signName;
}
