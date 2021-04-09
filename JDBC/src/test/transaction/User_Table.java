package test.transaction;

/**
 * @author TIMI
 * @Date 2021/2/27 - 18:21
 */
public class User_Table {
    private String user;
    private String password;
    private int balance;

    public User_Table() {
        super();
    }

    public User_Table(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
