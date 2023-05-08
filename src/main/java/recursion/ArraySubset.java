package recursion;

import java.util.HashSet;
import java.util.Set;

public class ArraySubset {


    // todo : need to fix

    public static void main(String[] args) {
        printAllSubSet(new int[]{1, 2, 3}, 0, new HashSet<>());

        System.out.println(values1);
    }

    static Set<String> values1 = new HashSet<>();

    private static void printAllSubSet(int[] arr, int start, Set<Integer> output) {
        if (start >= arr.length) {
            values1.add(output.toString());
            return;
        }

        printAllSubSet(arr, start + 1, output);
        output.add(arr[start]);
        printAllSubSet(arr, start + 1, output);
    }
}
