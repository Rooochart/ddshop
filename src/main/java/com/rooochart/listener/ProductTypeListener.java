package com.rooochart.listener;

import com.rooochart.pojo.ProductType;
import com.rooochart.service.ProductTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.applet.AppletContext;
import java.util.List;

/** web.xml文件里监听器ContextLoaderListener 也是ServletContextListener的实现类
 * 如果这里用注入的方式创建，则无法分辨是ProductTypeListener还是ContextLoaderListener，
 * 所以需要用手动方式进行创建
 * */
@WebListener
public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手动获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_*.xml");
      ProductTypeService productTypeService= (ProductTypeService) context.getBean("productTypeServiceImpl");
      // 放入全局应用作用域中，供前台新增，修改，查询页面获取全部商品类别集合
        List<ProductType> typeList=productTypeService.getAll();
      servletContextEvent.getServletContext().setAttribute("typeList",typeList);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
