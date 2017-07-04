package TrainTicket;

/**
 * Created by Charles on 2017/5/30.
 * 此类用于模拟票务网站买票进程
 */
public class BuyTicketThread implements Runnable {
    private TrainTicket ticket;
    private Passenger passenger;
    
//    买票类构造方法，将进行买票行为的乘客和所购车票作为参数实例化
    public BuyTicketThread(Passenger passenger,TrainTicket ticket) {
        this.ticket = ticket;
        this.passenger = passenger;
    }
    
    @Override
    public void run() {
        
        synchronized (ticket){//乘客准备买某一张车票时，给该车票加锁，不让其他乘客购买
            TrainTicket t = TrainSeller.sellerTicket(ticket);
            while (t == null) {
                System.out.println(passenger.getName() + " 抱歉，票已售完！ 请稍后重试！");
                try {
                    ticket.wait(1000);//等待退票
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (t != null) {
                System.out.println(passenger.getName() + " 购票成功！" + ticket);
            }
    }
    }
}
