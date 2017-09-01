package TrainTicketSystem;

/**
 * Created by Charles on 2017/5/30.
 */
public class Passenger {
    private String name;
    public  Passenger(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
//提供买票方法
    public void buyTicket(TrainTicket ticket){
        System.out.println("乘客: "+getName()+" 打算购买车票:"+ticket);
//        创建购票线程，将买票的乘客和车票对象作为参数传入
        Thread th=new Thread(new BuyTicketThread(this,ticket));
        th.start();

    }
//    提供退票方法
    public void returnTicket(TrainTicket ticket){
        System.out.println("乘客: "+getName()+" 正在退票:"+ticket);
        Thread t=new Thread(new ReturnTicketThread(this,ticket));
        t.start();
    }

    @Override
    public String toString() {
        return "乘客："+"[姓名="+name+"]";
    }
}
