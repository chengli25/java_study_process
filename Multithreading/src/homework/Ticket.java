package homework;

/**
 * @author TIMI
 * @Date 2020/11/28 - 16:00
 */
public class Ticket {
    private int id;
    private String name;
    public Ticket(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
