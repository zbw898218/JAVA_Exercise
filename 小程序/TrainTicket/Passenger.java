package TrainTicket;

/**
 * Created by Charles on 2017/5/30.
 * Passenger:乘客类，提供乘客对象，以及买票退票方法
 */
public class Passenger {
    //    使用name,id表示乘客姓名和身份证号
    
    private String name;
    private int id;
    
    public Passenger(String name,int id) {
        this.name = name;
        this.id=id;
    }
//    提供 set/get方法
    public String getName() {
        return name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
//    乘客类需要提供购票和退票两个方法,需要购买或退回的车票作为方法参数
//    这里每一个想买票的乘客都需要调用买票方法，有并发和同步的需求，使用非继承多线程方法。
//    重新创建一个BuyTicketThread类实现Runnable接口，来实现线程调度
    public void buyTicket(TrainTicket ticket){
        System.out.println("乘客 "+this.getName()+" 正在购买车票 "+ticket);
        Thread t=new Thread(new BuyTicketThread(this,ticket));
        t.start();
        
    }
    
    public void returnTicket(TrainTicket ticket){
        System.out.println("乘客 "+this.getName()+" 正在退票 "+ticket);
        Thread t=new Thread(new ReturnTicketThread(this,ticket));
        t.start();
    }
    
    
    
    @Override
    public String toString() {
        return "乘客信息： {" +
                "姓名=" + name + '\'' +
                ", 身份证号=" + id +
                '}';
    }
}
