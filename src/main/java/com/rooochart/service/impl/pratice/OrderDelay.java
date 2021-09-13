package com.rooochart.service.impl.pratice;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**延时类就写好了，后面调用就行啦
 * 优点效率高，延迟低
 * 缺点 数据库重启数据全丢失，集群扩展相当麻烦，代码复杂度高
 **/
public class OrderDelay implements Delayed {
    private String orderID;
    private long timeOut;

    public OrderDelay(String orderID, long timeOut) {
        this.orderID = orderID;
        this.timeOut = timeOut+System.nanoTime();
    }

    @Override
    public int compareTo(Delayed o) {
        if (o==this){
            return 0;
        }
        OrderDelay t=(OrderDelay) o;
        long d=(getDelay(TimeUnit.NANOSECONDS)-t.getDelay(TimeUnit.NANOSECONDS));
        return (d==0)?0:((d<0)?-1:1);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeOut-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    void print(){
        System.out.println(orderID+"编号的订单要删除啦。。。");
    }


}
