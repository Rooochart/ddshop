package com.rooochart.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rooochart.mapper.ProductInfoMapper;
import com.rooochart.pojo.ProductInfo;
import com.rooochart.pojo.ProductInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInfoServiceImpl implements com.rooochart.service.ProductInfoService {
    //业务逻辑层一定要有数据访问层对象
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    @Override
    public PageInfo splitPage(int pageNum, int PageSize) {
        //分页插件使用PageHelper工具类完成
        PageHelper.startPage(pageNum, PageSize);
        //进行pageInfo的数据封装
        //进行有条件的查询，必须封装productInfoExample对象
        ProductInfoExample productInfoExample=new ProductInfoExample();

        //设置排序，按主键降序排列，方便查看最新修改的数据
        /** ProductInfoMapper.xml 文件里：     SQL语句的拼接
         *  <if test="orderByClause != null" >
         order by ${orderByClause}
         </if>  */
        productInfoExample.setOrderByClause("p_id desc");
        //设置完排序后，取集合，一定在取集合之前完成PageHelper.startPage(pageNum, PageSize);
        List<ProductInfo> list=productInfoMapper.selectByExample(productInfoExample);
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
