package TrainTicket;

/**
 * Created by Charles on 2017/5/30.
 * 此类用于模拟票务网站退票进程
 */
public class ReturnTicketThread implements Runnable {
    private TrainTicket ticket;
    private Passenger passenger;
    
    //    退票类构造方法，将进行买票行为的乘客和所购车票作为参数实例化
    public ReturnTicketThread(Passenger passenger,TrainTicket ticket) {
        this.ticket = ticket;
        this.passenger = passenger;
    }
    
    @Override
    public void run() {
//       调用票务网站退票方法。将退回的票加入票池
        TrainSeller.returnTicket(ticket);
        synchronized (ticket) {
            
                System.out.println(passenger.getName() + " 正在退票....！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.notifyAll();//退票成功，唤醒其他需要此票的线程
                System.out.println(passenger.getName() + " 退票成功！"+ticket);
            }
            
         
        }
    
}
