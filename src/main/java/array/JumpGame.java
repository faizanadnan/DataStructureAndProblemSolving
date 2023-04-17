package array;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int[] arr1 = new int[]{3, 2, 10, 10, 4};
        System.out.println(isJumpToLastElementPossible(arr));
        System.out.println(isJumpToLastElementPossible(arr1));
    }

    /*
    i = 0
    maxJumpPossible = 0
    2, 3, 1, 1, 4

     i = 1
    maxJumpPossible = 2
     2, 3, 1, 1, 4

      i = 2
    maxJumpPossible = 3
    2, 3, 1, 1, 4

      i = 3
    maxJumpPossible = 4
    2, 3, 1, 1, 4

    i = 4
      maxJumpPossible = 8
    2, 3, 1, 1, 4



     */
    private static boolean isJumpToLastElementPossible(int[] arr) {
        int maxJumpPossible = 0;
        for (int i = 0; i < arr.length; i++) {
            int localMaxJump = arr[i] + i;

            maxJumpPossible = Math.max(localMaxJump, maxJumpPossible);

            if (maxJumpPossible <= i) return false;
        }
        return maxJumpPossible >= arr.length - 1;
    }
}
