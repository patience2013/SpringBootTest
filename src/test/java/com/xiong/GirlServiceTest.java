package com.xiong;

import com.xiong.domain.Girl;
import com.xiong.service.GirlService;
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
    private GirlService girlService;
    @Transactional
    @Test
    public void findOneTest(){
        Girl girl =girlService.findOne(6);
        Assert.assertEquals(new Integer(12),girl.getAge());
    }
}
