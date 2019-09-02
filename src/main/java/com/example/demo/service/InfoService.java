package com.example.demo.service;

import com.example.demo.body.RegisterInfo;
import com.example.demo.body.common.Response;
import com.example.demo.entity.Info;


public interface InfoService {
    Response findByUsername(Info info);

    Response register(RegisterInfo info);
}
