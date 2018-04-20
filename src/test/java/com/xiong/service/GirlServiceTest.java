package com.xiong.service;

import com.xiong.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService girlService;
    @Test
    @Transactional
    public void findOne() {
        Girl girl =girlService.findOne(6);
        Assert.assertEquals(new Integer(13),girl.getAge());
    }
}