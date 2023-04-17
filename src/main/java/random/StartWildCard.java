package random;

public class StartWildCard {


    static boolean match(String first, String second) {

        // If we reach at the end of both strings,
        // we are done
        if (first.length() == 0 && second.length() == 0)
            return true;

        // Make sure to eliminate consecutive '*'
        /*
         **ks and geeks

         */
        first = removeConsecutiveStar(first);

        // Make sure that the characters after '*'
        // are present in second string.
        // This function assumes that the first
        // string will not contain two consecutive '*'

        // *ks and geeks
        if (first.length() > 1 && first.charAt(0) == '*' &&
                second.length() == 0)
            return false;


        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (first.length() > 0 && first.charAt(0) == '*')
            return match(first.substring(1), second) || match(first, second.substring(1));


        // If the first string contains '?',
        // or current characters of both strings match
        if ((first.length() != 0 && second.length() != 0 && first.charAt(0) == second.charAt(0)))
            return match(first.substring(1), second.substring(1));

        return false;
    }

    private static String removeConsecutiveStar(String first) {
        if (first.length() > 1 && first.charAt(0) == '*') {
            int i = 0;
            while (i + 1 < first.length() && first.charAt(i + 1) == '*')
                i++;
            first = first.substring(i);
        }
        return first;
    }

    // A function to run test cases
    static void test(String first, String second) {
        if (match(first, second))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


    public static void main(String[] args) {
       test("*", "aaaaaaa");
    }
}
