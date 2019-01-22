package com.clown.rabbit.key;

import com.clown.rabbit.user.UserApplication;
import com.clown.rabbit.user.mapper.IKeyMapper;
import com.clown.rabbit.user.model.AccessKey;
import com.clown.rabbit.user.utils.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class KeyTest {
    @Autowired
    private IKeyMapper keyMapper;

    @Autowired
    private IdWorker idWorker;

    @Test
    public void setKey(){
        AccessKey key = new AccessKey();
        key.setId(String.valueOf(idWorker.nextId()));
        key.setAccessKeyId("LTAI8nK01G3gXmyo");
        key.setAccessKeySecret("xk6MYAadGPpYFkxkiWMrKMokHU6qab");
        key.setTemplateCode("SMS_156471578");
        key.setSignName("李剑宇");

        keyMapper.save(key);
    }
}
