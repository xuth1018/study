package com.example.demo.controller;

import com.example.demo.body.RegisterInfo;
import com.example.demo.body.common.Response;
import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import com.example.demo.service.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@Api(value = "用户",description = "用户",tags = "1.1")
public class InfoController {
    private Logger logger = LoggerFactory.getLogger(InfoController.class);
    @Autowired
    private InfoService infoService;
    @Autowired
    private InfoMapper infoMapper;

    @PostMapping(value = "/login")//登陆
    @ApiOperation("登陆")
    public Response Login(@ApiParam("用户") Info info) {
        Response rep = new Response();
        if (null == info.getUsername() || null == info.getPassword()) {
            return Response.Ok("500", "不能为空");
        }
        rep = infoService.findByUsername(info);
        return rep;
    }


    @PostMapping("/register")//注册
    public Response Register(RegisterInfo info) {
        Response rep = new Response();

        return rep;
    }

    @GetMapping("/count")//注册
    public Response count(String username) {
        logger.info("InfoController.count()---start");
        Integer num = null;
        try {
            num = infoMapper.countByUsername(username);
        } catch (Exception e) {
            logger.info("异常" + e.getMessage());
        }
        logger.info("InfoController.count()---num:" + num);
        return Response.Ok("200", "数量", num);
    }

}
