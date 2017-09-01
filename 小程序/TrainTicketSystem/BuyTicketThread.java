package TrainTicketSystem;

/**
 * Created by Charles on 2017/5/30.
 */
public class BuyTicketThread implements Runnable {
    
    private  TrainTicket ticket;
    private  Passenger passenger;

//    构造方法传入乘客对象和车票对象
    public BuyTicketThread(Passenger passenger,TrainTicket ticket){
        super();
        this.passenger=passenger;
        this.ticket=ticket;
    }


//    复写runnable接口的run方法
    @Override
    public void run() {
        synchronized (ticket) {
            TrainTicket t=TrainSeller.sellerTicket(ticket);
            while (t == null) {
                System.out.println(passenger.getName() + "车票已售完，请等待退票！");
                try{
                    ticket.wait();
                    
                }catch (Exception e){
                    e.getMessage();
                }
               
            }
            if(t!=null){
                System.out.println(passenger.getName() + "购票成功，车票信息:" + ticket);
            }
    
        }
    }
}
