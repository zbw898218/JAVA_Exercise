package TrainTicketSystem;

/**
 * Created by Charles on 2017/5/30.
 */
public class TrainTicket {
    private String trainNo;
    private String seatNo;
    private String date;

    public TrainTicket(String trainNo,String seatNo,String date){
        this.trainNo=trainNo;
        this.seatNo=seatNo;
        this.date=date;
    }
    public void  setTrainNo(String trainNo){
        this.trainNo=trainNo;
    }
    public void setSeatNo(String seatNo){
        this.seatNo=seatNo;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getTrainNo() {
        return trainNo;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TrainTicket other = (TrainTicket) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (seatNo == null) {
            if (other.seatNo != null)
                return false;
        } else if (!seatNo.equals(other.seatNo))
            return false;
        if (trainNo == null) {
            if (other.trainNo != null)
                return false;
        } else if (!trainNo.equals(other.trainNo))
            return false;
        return true;

    }
    public  String toString(){
        return  "车票信息："+"[车次="+trainNo+"座位号="+seatNo+"乘车日期="+date+"]";
    }
}
