package stack;

public class NextGreaterElement {


    static int count = 0;


    /*
  7, 4, 5, 6, 5


   7, 4, 5, 6, 5

   [4, 5, 6],
   4,5
   5,6

   = 73




  i  =  7, 4, 5, 6
  j =  5, 6, 5
  sum = 7, 9, 15, 4, 11, 5, 11, 6 + 5
  windowSum =7, 4, 9, 15, 5, 11, 6, 11,
*/
    public static int sumOfGoodArithmetic(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int prevWindowSum = 0;
        int prevDiff = 0;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int diff = j < n ? nums[j] - nums[i] : 0;
            int windowSum = nums[i];

            if (i > 0 && diff == prevDiff && (diff == -1 || diff == 1)) {
                windowSum = prevWindowSum + nums[j];
                sum = sum + windowSum;
            }
            // update the previous window sum and difference
            prevWindowSum = windowSum;
            prevDiff = diff;

            sum += nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int arr[] = {7, 4, 5, 6, 5};
        System.out.println(sumOfGoodArithmetic(arr));
    }
}