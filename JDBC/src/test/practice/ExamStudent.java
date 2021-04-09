package test.practice;

/**
 * @author TIMI
 * @Date 2021/2/26 - 17:06
 */
public class ExamStudent {
    private int id;
    private  int Type;
    private  String IDCard;
    private String ExamCard;
    private String StudentName;
    private String Location;
    private int Grade;

    public ExamStudent(){
        super();
    }
    public ExamStudent(int id, int type, String IDCard, String examCard, String studentName, String location, int grade) {
        this.id = id;
        Type = type;
        this.IDCard = IDCard;
        ExamCard = examCard;
        StudentName = studentName;
        Location = location;
        Grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return ExamCard;
    }

    public void setExamCard(String examCard) {
        ExamCard = examCard;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "ExamStudent{" +
                "id=" + id +
                ", Type=" + Type +
                ", IDCard=" + IDCard +
                ", ExamCard=" + ExamCard +
                ", StudentName='" + StudentName + '\'' +
                ", Location='" + Location + '\'' +
                ", Grade=" + Grade +
                '}';
    }
}
