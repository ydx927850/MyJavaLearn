package functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Yandx
 * @version 1.0
 * @date created on 2019/5/22 9:26
 */
public class LamdbaTest {
    public static void main(String[] args) {
        List<String> list = Stream.of("a","v","s").map(String::toUpperCase).collect(toList());
        String result = list.stream().collect(Collectors.joining(",","[","]"));
    }


}
