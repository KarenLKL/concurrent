package com.newbee.concurrent.controller;

import com.newbee.concurrent.ThreadLocal.RequestHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/threadLocal")
public class ThreadLocalController {
    @GetMapping("all")
    public Long test(){
        return RequestHolder.get();
    }

}
