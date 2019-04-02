package org.smh.restful.RestfulTest.control;

import org.smh.restful.RestfulTest.util.RedisClusterUtils;
import org.smh.restful.RestfulTest.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    private RedisClusterUtils redisClusterUtils;

    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public String testBase (@RequestBody RequestVo requestVo) {

        if(null != requestVo) {
            redisClusterUtils.setValueByKey("001::name", requestVo.getName());
            redisClusterUtils.setValueByKey("001::age", String.valueOf(requestVo.getAge()));
            redisClusterUtils.setValueByKey("001::className", requestVo.getClassName());
        } else {
            return "error";
        }
        return "ok";
    }

    @RequestMapping(value = "/getTestValue", method = RequestMethod.POST)
    public String getTestValue(){
        System.out.println(redisClusterUtils.getValueByKey("001::name"));
        System.out.println(redisClusterUtils.getValueByKey("001::age"));
        System.out.println(redisClusterUtils.getValueByKey("001::className"));
        return "ok";
    }

}
