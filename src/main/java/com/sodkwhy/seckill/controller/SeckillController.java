package com.sodkwhy.seckill.controller;

import com.sodkwhy.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/seckill/seckill")
public class SeckillController {


    @Autowired
    private SeckillService seckillService;


    /**
     * 商品进行秒杀(秒杀开始)
     * @param killId
     * @param key
     * @param num
     * @return
     */
    @GetMapping(value = "/kill")
    @ResponseBody
    public R seckill(@RequestParam("killId") String killId,
                     @RequestParam("key") String key,
                     @RequestParam("num") Integer num,
                     HttpServletRequest request) throws InterruptedException {

        String orderSn = seckillService.kill(killId,key,num);
        if (orderSn == null) {
            return R.error();
        }
        return R.ok().data("orderSn",orderSn);
    }

}
