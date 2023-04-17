package array;

public class MaxSum {


    private static int maxSubArray(int[] nums) {

        if (nums.length < 1)
            return -1;

        int globalSum = nums[0];

        int localSum  = 0;
        for (int num : nums) {
            localSum += num;

            if (localSum > globalSum)
                globalSum = localSum;

            if (localSum < 0) {
                localSum = 0;
            }
        }
        return globalSum;

    }

    public static void main(String[] args) {
        int[] arr = {-2,5,-3,4,-1,-2,1,-5,14};
        System.out.println(maxSubArray(arr));
    }
}
