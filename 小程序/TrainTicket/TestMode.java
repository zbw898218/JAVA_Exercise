package TrainTicket;

/**
 * Created by Charles on 2017/5/30.
 * 测试类
 */
public class TestMode {
    public static void main(String[] args){
//        创建5个购票乘客对象
        Passenger p1=new Passenger("张三",3201);
        Passenger p2=new Passenger("李四",2201);
        Passenger p3=new Passenger("王五",2301);
        Passenger p4=new Passenger("孙六",1001);
        Passenger p5=new Passenger("赵七",1201);
        
//        创建2个车票对象
        TrainTicket ticket1=new TrainTicket("G10","1","2017-5-30");
        TrainTicket ticket2=new TrainTicket("G10","2","2017-5-30");
        
//        模拟多人抢票
        p1.buyTicket(ticket1);
        p2.buyTicket(ticket2);
        p3.buyTicket(ticket1);
        p4.buyTicket(ticket1);
        p5.buyTicket(ticket2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        模拟退票
        p1.returnTicket(ticket1);
        p2.returnTicket(ticket2);
    }
}
