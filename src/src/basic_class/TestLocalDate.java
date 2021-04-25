package basic_class;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: Zero
 * @Date: 2021/3/21 - 11:38
 * @since: jdk 1.8
 */
public class TestLocalDate {
    @Test
    public void test() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime local = LocalDateTime.now();

    }
}
