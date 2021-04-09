package pojo;

/**
 * @author: Zero
 * @Date: 2021/3/18 - 12:48
 * @since: jdk 1.8
 */
public class Person {
    private Integer id;
    private String username;
    private String gender;
    private int age;

    public Person() {
        super();
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(Integer id, String username, String gender, int age) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
