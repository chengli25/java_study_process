package test.preparedstatement.crud;

/**
 * @author TIMI
 * @Date 2021/2/23 - 21:10
 */
public class order {
    private int orderid;
    private String ordername;

    public order() {
        super();
    }
    public order(int orderid, String ordername) {
        this.orderid = orderid;
        this.ordername = ordername;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderid=" + orderid +
                ", ordername='" + ordername + '\'' +
                '}';
    }
}
