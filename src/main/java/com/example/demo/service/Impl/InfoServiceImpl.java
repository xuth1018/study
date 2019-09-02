package com.example.demo.service.Impl;

import com.example.demo.body.RegisterInfo;
import com.example.demo.body.common.Response;
import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import com.example.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public Response findByUsername(Info info) {
        String username = null==info.getUsername()?"":info.getUsername();
        Info infoBeing = infoMapper.findByUsername(username);
        if (null!=infoBeing){
            if(info.getUsername().equals(infoBeing.getUsername())&&info.getPassword().equals(infoBeing.getPassword())){
                return Response.Ok("200","操作成功",infoBeing);
            }else{
                return Response.Ok("200","用户名或密码错误",info);
            }
        }
        return null;
    }

    @Override
    public Response register(RegisterInfo info) {

        try {

        }catch (Exception e){

        }
        return null;
    }
}
