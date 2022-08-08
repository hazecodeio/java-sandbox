package _ocp8;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void getSlidingStream_Size_01_Step_01() {
        List<String> list = Utils.getSlidingStream("0123456789".toCharArray(), 1, 1)
                .collect(Collectors.toList());
        list.stream().collect(Collectors.joining(",", "[", "]")).chars().mapToObj(Character::toString).forEach(System.out::print);
        assertThat(list)
                .containsExactlyElementsOf(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        System.out.println();
    }

    @Test
    public void getSlidingStream_Size_03_Step_02() {
        List<String> list = Utils.getSlidingStream("0123456789".toCharArray(), 3, 2)
                .collect(Collectors.toList());
        list.stream().collect(Collectors.joining(",", "[", "]")).chars().mapToObj(Character::toString)
                .forEach(System.out::print);

        assertThat(list)
                .containsExactlyElementsOf(List.of("012", "234", "456", "678", "89"));
    }

    @Test
    public void getSlidingStream_Size_04_Step_02() {
        List<String> list = Utils.getSlidingStream("0123456789".toCharArray(), 4, 2)
                .collect(Collectors.toList());
        list.stream().collect(Collectors.joining(",", "[", "]")).chars().mapToObj(Character::toString)
                .forEach(System.out::print);

        assertThat(list)
                .containsExactlyElementsOf(List.of("0123", "2345", "4567", "6789", "89"));
    }

    @Test
    public void getSlidingStream_Size_02_Step_02() {
        List<String> list = Utils.getSlidingStream("0123456789".toCharArray(), 2, 2)
                .collect(Collectors.toList());
        list.stream().collect(Collectors.joining(",", "[", "]")).chars().mapToObj(Character::toString)
                .forEach(System.out::print);

        assertThat(list)
                .containsExactlyElementsOf(List.of("01", "23", "45", "67", "89"));
    }
}