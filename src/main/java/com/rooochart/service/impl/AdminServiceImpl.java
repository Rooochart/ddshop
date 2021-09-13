package com.rooochart.service.impl;

import com.rooochart.mapper.AdminMapper;
import com.rooochart.pojo.Admin;
import com.rooochart.pojo.AdminExample;
import com.rooochart.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
// 登录验证层
@Service
public class AdminServiceImpl implements com.rooochart.service.AdminService {
   //在业务逻辑层一定会有数据访问层对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
     /** 根据传入的用户到DB中查找相应的用户对象，
      * 如果有条件，一定要创建adminExample对象，用来封装条件
      *  如何添加条件  select * from admin where a_name=admin
      * */
      //添加用户a_name条件
        AdminExample example=new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list=adminMapper.selectByExample(example);
        if (list.size()>0){
            Admin admin=list.get(0);
           if (admin.getaPass().equals(MD5Util.getMD5(pwd))){
               return admin;
           }
        }
        return null;
    }


}
