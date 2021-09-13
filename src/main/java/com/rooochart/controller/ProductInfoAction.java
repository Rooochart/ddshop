package com.rooochart.controller;

import com.github.pagehelper.PageInfo;
import com.rooochart.pojo.ProductInfo;
import com.rooochart.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    public static final int PAGE_SIZE =5;
    //控制器必须有service对象
    @Autowired
    ProductInfoService productInfoService;

    //显示全部商品，不分页
    //list将内容带到product.jsp页面

    @RequestMapping("/getAll")
    public  String getAll(HttpServletRequest request){
        List<ProductInfo> list= productInfoService.getAll();
        request.setAttribute("list",list);

        return "product";
    }
    //显示商品，分页，一页分5条数据
    @RequestMapping("/split")
   public  String split(HttpServletRequest request){
        //得到第一页的数据
        PageInfo info=productInfoService.splitPage(1,PAGE_SIZE);
        request.setAttribute("info",info);
        return  "product";
   }
   //Ajax分页翻页处理
    @ResponseBody
    @RequestMapping("/ajaxsplit")
    public void ajaxsplit(int page, HttpSession session){
        PageInfo info=productInfoService.splitPage(page,PAGE_SIZE);
        session.setAttribute("info",info);

    }


}
