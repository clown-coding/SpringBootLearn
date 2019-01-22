package com.clown.rabbit.sms.listener;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.clown.rabbit.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserListener {

    @Autowired
    private SmsUtil smsUtil;

    @RabbitListener(queues = "sms")
    @RabbitHandler
    public void sendMessage(Map<String,String> map){
        try {
            SendSmsResponse response = smsUtil.sendSms(map.get("mobile"), map.get("templateCode"),map.get("signName"), "{\"code\":\"" + map.get("code") + "\"}",map.get("accessKeyId"),map.get("accessKeySecret"));
            System.out.println(response);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
