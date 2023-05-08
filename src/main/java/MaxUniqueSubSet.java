import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxUniqueSubSet {


    public static void main(String[] args) {
        System.out.println(findSubSet(Arrays.asList(1,2,3,4,5,1,7)));
    }

    private static String findSubSet(List<Integer> intput) {

        String localSubset = "";
        String globalSubset = "";


        Map<Integer, Boolean> numberVsOccurrence = new HashMap<>();



        for (int i = 0; i < intput.size() ; i++) {

            Integer integer = intput.get(i);

            if (!localSubset.contains(integer.toString())) {
                localSubset += integer.toString();

                if (localSubset.length() > globalSubset.length())
                    globalSubset =  localSubset;
            } else {
                // means now found something which is not unique
                localSubset = "";
                localSubset += integer.toString();
            }
        }

        return globalSubset;
    }
}
