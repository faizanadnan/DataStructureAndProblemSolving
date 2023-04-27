package random;

public class Fibonacci {



    // 0, 1, 1, 2, 3, 5

    /*
       Base f(0) =  0
            f(1) = 1



     */


    static int calculate(int n, int start) {

        if (start == n) return 1;

        if (start > n) return 0;

         int problem1 = calculate(n, start + 1);

        int problem2  = calculate(n, start + 2);

        return problem1 + problem2;
    }

    public static void main(String[] args) {
        System.out.println((calculate(4, 0)));
    }
}
