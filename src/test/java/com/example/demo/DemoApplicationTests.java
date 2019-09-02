package com.example.demo;

import com.example.demo.entity.Info;
import com.example.demo.mapper.InfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private InfoMapper infoMapper;


    @Test
    public void test1() throws Exception {
        final Info info1 = new Info("u1", "p1");
        final Info info2 = new Info("u1", "p2");
        final Info info3 = new Info("u3", "p3");
        infoMapper.insertSelective(info1);
        log.info("[Info1回写主键] - [{}]", info1.getId());
        infoMapper.insertSelective(info2);
        log.info("[Info2回写主键] - [{}]", info2.getId());
        infoMapper.insertSelective(info3);
        log.info("[Info3回写主键] - [{}]", info3.getId());
        final int count = infoMapper.countByUsername("u1");
        log.info("[调用自己写的SQL] - [{}]", count);

        // TODO 模拟分页
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        infoMapper.insertSelective(new Info("u1", "p1"));
        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.infoMapper.selectAll());
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<Info> userPageInfo = new PageInfo<>(this.infoMapper.selectAll());
        log.info("[普通写法] - [{}]", userPageInfo);
    }

}
