package com.xiong.controller;

import com.xiong.domain.Girl;
import com.xiong.domain.Result;
import com.xiong.respository.GirlRespository;
import com.xiong.service.GirlService;
import com.xiong.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRespository girlRespository;
    @Autowired
    private GirlService girlService;

    /*
    * 查询所有女生列表
    * @return
    * */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("girlList");
        return girlRespository.findAll();

    }
    /*
     * 添加女生信息
     * @return
     * */
    @PostMapping(value = "/addGirl" )
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
//        Girl girl =new Girl();
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
//        girlRespository.save(girl);
        return ResultUtil.success(girlRespository.save(girl));
    }
    /*
    * 查询一个女生
    * return
    * */
    @GetMapping(value = "/getGirl/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRespository.getOne(id);
    }


    /*
     * 修改女生信息
     * @return
     * */
    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl =new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRespository.save(girl);
    }

    /*
     * 删除女生信息
     * @return
     * */
    @DeleteMapping(value = "/delgirl/{id}")
    public void delGirl(@PathVariable("id") Integer id){
        girlRespository.deleteById(id);
    }

    @GetMapping(value = "/getGirlByAge/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTow(){
        girlService.insertTwoGirl();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
