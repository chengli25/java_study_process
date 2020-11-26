package customexception;

/**
 * @author TIMI
 * @Date 2020/11/25 - 14:41
 */
public class ZaoTang {
    public void na(Person p) throws GerderException {
        if(p.sex.equals("男")){
            System.out.println("欢迎光临");
        }
        else{
            throw new GerderException("性别不对");
        }
    }
}
