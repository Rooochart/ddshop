package com.rooochart.service.impl;

import com.rooochart.mapper.ProductTypeMapper;
import com.rooochart.pojo.ProductType;
import com.rooochart.pojo.ProductTypeExample;
import com.rooochart.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    //业务层一定要有数据访问层对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
