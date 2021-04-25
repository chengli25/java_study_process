package basic_class;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @author: Zero
 * @Date: 2021/3/21 - 11:02
 * @since: jdk 1.8
 */
public class TestStringTokenizer {
    @Test
    public void test() {
        StringTokenizer st = new StringTokenizer("abc,dfe.gjk",",.",true);
        System.out.println("拥有的令牌数：" + st.countTokens());
        for(int i = 0; i < st.countTokens(); i++) {
            System.out.print(st.nextToken()+ "==>");
        }
        System.out.println();
        System.out.println("后面是否还有令牌："+st.hasMoreElements());

    }
}
