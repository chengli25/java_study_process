package basic_class;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Zero
 * @Date: 2021/3/21 - 11:28
 * @since: jdk 1.8
 */
public class TestPatternAndMatch {
    @Test
    public void test() {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        Pattern pattern = Pattern.compile(regex);
        String input = "jfdsajfdsakfjifewojir@df.com";
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.find());
        System.out.println(matcher.group());

    }
}
