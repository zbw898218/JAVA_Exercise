package TrainTicketSystem;

import java.util.HashSet;

/**
 * Created by Charles on 2017/5/30.
 */
public class TrainSeller {
    private static HashSet<TrainTicket> pool=new HashSet<TrainTicket>();//pool：票池
    static {
        pool.add(new TrainTicket("T10","10","2017-05-30"));
        pool.add(new TrainTicket("T10","10","2017-05-31"));
        pool.add(new TrainTicket("T10","11","2017-05-31"));
        pool.add(new TrainTicket("T11","11","2017-05-31"));
        pool.add(new TrainTicket("T12","10","2017-05-30"));
        pool.add(new TrainTicket("T13","10","2017-05-30"));
    }
    
//    sellerTicket方法将乘客想买的票作为参数传入，进行判定，如有，出票，将其从pool删除，没有返回null
    public static  TrainTicket sellerTicket(TrainTicket ticket){
        
        TrainTicket tk=null;
        for(TrainTicket tc:pool){
            if(tc.equals(ticket)){
                tk=tc;
                System.out.println("正在出票："+ticket);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pool.remove(tc);
                break;
            }
        }
        return  tk;
    }
//    提供退票方法
    public static void returnTicket(TrainTicket ticket){
        pool.add(ticket);
    }
}
