package com.clown.provider.service.impl;

import com.clown.provider.service.ListenService;
import org.springframework.stereotype.Service;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/24
 **/
@Service
public class ListenServiceImpl implements ListenService {

    @Override
    public String listen() {
        System.out.println("provider-1");
//        System.out.println("provider-2");
//        System.out.println("7779");
//        System.out.println("7780");
        return "clown is laughing at you...";
    }
}
