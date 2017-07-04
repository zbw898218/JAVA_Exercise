package TrainTicket;

import java.util.ArrayList;

/**
 * Created by Charles on 2017/5/30.
 *
 * TrainSeller类：模拟票务网站处理购票和退票流程
 */
public class TrainSeller {
//    pool:车票池
    private static ArrayList<TrainTicket> pool=new ArrayList<TrainTicket>();
//    静态块。在调用该类时加载
    static{
        pool.add(new TrainTicket("G10","1","2017-5-30"));
        pool.add(new TrainTicket("G10","2","2017-5-30"));
        pool.add(new TrainTicket("G10","3","2017-5-30"));
        pool.add(new TrainTicket("G10","4","2017-5-30"));
        pool.add(new TrainTicket("G10","5","2017-5-30"));
        pool.add(new TrainTicket("G10","6","2017-5-30"));
    }
//    提供sellerTicket方法模拟票务网站，将乘客预定的车票对象作为参数传入
//    通过遍历票池，如果有票。将车票对象赋值给车票对象并返回
//    如果没有票。返回空值
    public static TrainTicket sellerTicket(TrainTicket ticket){
        TrainTicket t=null;
       
        for(TrainTicket ti:pool) {
            if (ti.equals(ticket)) {
                System.out.println("正在出票！" + ticket);
                t = ti;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pool.remove(ti);
                break;
            }
        
        }
        return t;
    }
//    提供returnTicket方法，接受乘客退票的车票对象并加入票池
    public static void returnTicket(TrainTicket ticket){
        pool.add(ticket);
       
    }
}
