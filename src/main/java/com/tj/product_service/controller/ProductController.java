package com.tj.product_service.controller;

import com.tj.product_service.domain.Product;
import com.tj.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Resource
    private ProductService productService;

    /**
     * 获取所有商品列表
     * @return
     */
    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    /**
     * 根据id查找商品详情
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object findById(@RequestParam("id")int id){
        log.info("进入product信息");
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Product product= productService.findById(id);
        Product result=new Product();
        BeanUtils.copyProperties(product,result);
        result.setName(result.getName()+" data from port = "+port);
        return result;
    }
}
