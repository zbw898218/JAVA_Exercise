package Exercise.DVDSystem;

/**
 * 普通客户类
 * Created by Charles on 2017/6/15
 */
public class Commer extends Customer {
    {
        super.setLevel(Customer.COMMER_LEVEL);
    }

    public Commer() {
    }

    public Commer(String name, String pwd) {
        super(name, pwd);
    }



    @Override
    public boolean returnDvd(String dvdName) {
        return false;
    }

    @Override
    public String toString() {
        return "Commer{}"+super.toString();
    }
}
