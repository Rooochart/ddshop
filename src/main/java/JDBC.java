import com.rooochart.utils.MD5Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//验证数据库连接
public class JDBC {

   /* public static void main(String[] args) {
       String s= MD5Util.getMD5("123456");
        System.out.println(s);
    }*/
   /*public static void main(String[] args) throws SQLException, ClassNotFoundException {


       String url = "jdbc:mysql://localhost:3306/xiaomissm?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
       //创建一个ch10的数据库
       String userName = "root";
       String password = "root";
       Connection conn = null;

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           System.out.println("加载驱动器类时出现异常");
           e.printStackTrace();
       }
       try {

           conn = DriverManager.getConnection(url, userName, password);
       } catch (SQLException e) {
           System.out.println("链接数据库的过程中出现SQL异常");
           e.printStackTrace();
           System.out.println(e.getMessage());
       }
       if (conn == null) {
           System.out.println("链接数据库失败");
       } else {
           System.out.println("链接数据库成功");
           try {
               conn.close();
           } catch (SQLException e) {
               System.out.println("关闭数据库连接时出现SQL异常");
           }
       }

   }*/
}