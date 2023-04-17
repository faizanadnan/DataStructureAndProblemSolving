package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CountingBits {


    public static void main(String[] args) {
        countBits(5).stream()
                .forEach(System.out::print);
    }

    // todo : read about bit manipulation

    private static List<Integer> countBits(int num) {
        List<Integer> finalValue = new ArrayList<>();
        for (int j = 0; j <= num; j++) {
            int count = 0;
            for (int l = 0; l < 32; l++) {
                if ((num & (1 << l)) > 0)
                    count++;
            }
            finalValue.add(count);
        }

        return finalValue;
    }
}
