package Exercise.DVDSystem;

/**
 * Created by Charles on 2017/6/15
 */
public class DVD {
    private int price;
    private String name;
    private int id;
    private int rent=0;//租借状态：1.已被租借；0.可以租借；默认可以租借
    private int isDel=0;//删除状态：1.已被删除；0.没有删除
    public DVD() {
    }

    public DVD(String name) {
        this.name = name;
    }

    public DVD(int price, String name, int id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public DVD(String name, int price) {
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "dvd信息{" +
                " 编号=" + id +
                ", 名称='" + name + '\'' +
                "租金=" + price +
                ", 租借状态=" + rent +
                ", 删除状态="+ isDel+
                '}';
    }

}
