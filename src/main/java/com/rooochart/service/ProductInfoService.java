package com.rooochart.service;

import com.github.pagehelper.PageInfo;
import com.rooochart.pojo.ProductInfo;

import java.util.List;

public interface ProductInfoService {
   //查询所有商品
    List<ProductInfo> getAll();
    //分页功能的实现
    PageInfo splitPage(int pageNum,int PageSize);

}
