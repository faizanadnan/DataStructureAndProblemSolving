package array;

public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};

        System.out.println(maxProductSubArray(arr));
    }


    private static int maxProductSubArray(int[] nums){

        int localProduct = 0;
        int globalProduct = 0;
        int localProductReverse = 0;
        int j = nums.length - 1;
        for (int left : nums) {
            int right = nums[j--];

            if (localProductReverse == 0) {
                localProductReverse = right;
            } else {
                localProductReverse = localProductReverse * right;
            }
            if (localProduct == 0) {
                localProduct = left;
            } else {
                localProduct = localProduct * left;
            }
            if (left == 0) {
                localProduct = left;
            }
            if (right == 0) {
                localProductReverse = right;
            }
            globalProduct = Math.max(localProduct, globalProduct);
            globalProduct = Math.max(localProductReverse, globalProduct);

        }
        return globalProduct;
    }
}
