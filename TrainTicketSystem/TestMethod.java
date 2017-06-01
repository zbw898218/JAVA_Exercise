package TrainTicketSystem;

/**
 * Created by Charles on 2017/5/30.
 */
public class TestMethod {
    public static void main(String[] args){
//        创建5个买票的乘客对象
        Passenger p1=new Passenger("张三");
        Passenger p2=new Passenger("李四");
        Passenger p3=new Passenger("王五");
        Passenger p4=new Passenger("赵六");
        Passenger p5=new Passenger("孙奇");

//        创建乘客想购买的两张车票对象
        TrainTicket ticket1=new TrainTicket("T10","10","2017-05-30");
        TrainTicket ticket2=new TrainTicket("T13","10","2017-05-30");
//        p1,p2,p3同抢一张票 p4 p5同抢另一张票
        p1.buyTicket(ticket1);
        p2.buyTicket(ticket2);
        p3.buyTicket(ticket1);
        p4.buyTicket(ticket2);
        p5.buyTicket(ticket2);

        
        p1.returnTicket(ticket1);
        p2.returnTicket(ticket2);


    }
}
