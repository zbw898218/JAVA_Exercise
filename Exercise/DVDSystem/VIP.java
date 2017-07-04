package Exercise.DVDSystem;

/**VIP客户
 * Created by Charles on 2017/6/15
 */
public class VIP extends Customer{
    {
        super.setLevel(Customer.VIP_LEVEL);
    }
    public VIP() {
    }

    public VIP(String name, String pwd, double balance) {
        super(name, pwd, balance);
    }



    @Override
    public boolean returnDvd(String dvdName) {
        return false;
    }

    @Override
    public String toString() {
        return "VIP{} " + super.toString();
    }
}
