package com.tj.product_service.service.impl;

import com.tj.product_service.domain.Product;
import com.tj.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ProduceServiceImpl implements ProductService {

    private static final Map<Integer,Product> daoMap=new HashMap<>();
    static{
        Product product=new Product(1,"iphonx",9999,10);
        Product product2=new Product(2,"冰箱",9999,10);
        Product product3=new Product(3,"洗衣机",9999,10);
        Product product4=new Product(4,"电话",9999,10);
        Product product5=new Product(5,"汽车",9999,10);
        Product product6=new Product(6,"椅子",9999,10);
        Product product7=new Product(7,"java编程思想",9999,10);
        daoMap.put(product.getId(),product);
        daoMap.put(product2.getId(),product2);
        daoMap.put(product3.getId(),product3);
        daoMap.put(product4.getId(),product4);
        daoMap.put(product5.getId(),product5);
        daoMap.put(product6.getId(),product6);
        daoMap.put(product7.getId(),product7);
    }
    @Override
    public List<Product> listProduct() {
        Collection<Product> collection=daoMap.values();
        List<Product> list=new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        log.info("service findById");
        return daoMap.get(id);
    }
}
