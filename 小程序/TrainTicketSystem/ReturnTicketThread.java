package TrainTicketSystem;

/**
 * Created by Charles on 2017/5/30.
 */
public class ReturnTicketThread implements Runnable{
   private TrainTicket ticket;
   private Passenger passenger;
   public  ReturnTicketThread(Passenger passenger,TrainTicket ticket){
       this.ticket=ticket;
       this.passenger=passenger;
   }
   
   
    @Override
    public void run() {
        synchronized (ticket) {
            System.out.println("乘客 " + passenger.getName() + " 正在退票，信息为：" + ticket);
            try {
                Thread.sleep(3000);
                TrainSeller.returnTicket(ticket);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket.notifyAll();
            System.out.println("乘客 " + passenger.getName() + "退票成功！");
        }
    }
}
