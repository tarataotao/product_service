package com.tj.product_service.domain;



import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable{

    private int id;
    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格，分为单位
     */
    private int price;
    /**
     * 库存
     */
    private int store;


}
