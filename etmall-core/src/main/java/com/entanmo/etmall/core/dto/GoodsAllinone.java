package com.entanmo.etmall.core.dto;

import com.entanmo.etmall.db.domain.EtmallGoods;
import com.entanmo.etmall.db.domain.EtmallGoodsAttribute;
import com.entanmo.etmall.db.domain.EtmallGoodsProduct;
import com.entanmo.etmall.db.domain.EtmallGoodsSpecification;

public class GoodsAllinone {

    EtmallGoods goods;
    EtmallGoodsSpecification[] specifications;
    EtmallGoodsAttribute[] attributes;
    EtmallGoodsProduct[] products;

    public EtmallGoods getGoods() {
        return goods;
    }

    public void setGoods(EtmallGoods goods) {
        this.goods = goods;
    }

    public EtmallGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(EtmallGoodsProduct[] products) {
        this.products = products;
    }

    public EtmallGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(EtmallGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public EtmallGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(EtmallGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }
}
