package TrainTicket;

/**
 * Created by Charles on 2017/5/30.
 * TrainTicket:车票类，用于生成车票对象
 */
public class TrainTicket {
//    定义3个变量，分别代表 车次、座位号、乘车日期
    private String trainNo;
    private String seatNo;
    private String date;
    
    public TrainTicket(String trainNo, String seatNo, String date){
        this.date=date;
        this.seatNo=seatNo;
        this.trainNo=trainNo;
    }
    
    public String getTrainNo() {
        return trainNo;
    }
    
    public String getSeatNo() {
        return seatNo;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    
//    复写equals方法。车次等信息相同即视为同一张火车票
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainTicket)) return false;
        
        TrainTicket that = (TrainTicket) o;
        
        if (trainNo != null ? !trainNo.equals(that.trainNo) : that.trainNo != null) return false;
        if (seatNo != null ? !seatNo.equals(that.seatNo) : that.seatNo != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }
    
    @Override
    public int hashCode() {
        int result = trainNo != null ? trainNo.hashCode() : 0;
        result = 31 * result + (seatNo != null ? seatNo.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
//    复写打印方法。
    @Override
    public String toString() {
        return "车票信息： {" +
                "车次='" + trainNo + '\'' +
                ", 座位号='" + seatNo + '\'' +
                ", 乘车日期='" + date + '\'' +
                '}';
    }
}
