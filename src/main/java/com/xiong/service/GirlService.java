package com.xiong.service;

import com.xiong.domain.Girl;
import com.xiong.enums.ResultEnum;
import com.xiong.exception.GirlException;
import com.xiong.respository.GirlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRespository girlRespository;

    @Transactional
    public void insertTwoGirl(){
        Girl girlA=new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRespository.save(girlA);
        Girl girlB=new Girl();
        girlB.setAge(22);
        girlB.setCupSize("BBBB");
        girlRespository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl =girlRespository.getOne(id);
        Integer age =girl.getAge();
        if(age<10){
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
            //返回你可能还在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }
    /*
     * 通过id查询一个女生的信息
     *
     * */
    public Girl findOne(Integer id){
        return girlRespository.getOne(id);
    }
}
