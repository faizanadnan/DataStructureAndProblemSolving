package random;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Extra {
    public static void main(String[] args) throws ParseException {
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 18);
        Date dd = new Date();
    }

    public static void printTables() {
        int x = 70, y = 20;
        int maxSpace = countDigits(x * y);  // 3

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                int ans = i * j;
                System.out.print(ans);
                int count = countDigits(ans);
                for (int k = 0; k <= maxSpace - count; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int countDigits(int n) {
        int i = 0;
        while (n != 0) {
            i++;
            n = n / 10;
        }
        return i;
    }


    public static void printTableTab() {
        int x = 70, y = 15;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void printSubsets(String nums, int i, String ans) {
        if (i >= nums.length()) {
            System.out.println(ans);
            return;
        }

        int result = Integer.parseInt("3") + 1;

        printSubsets(nums, i + 1, ans + nums.charAt(i));
        printSubsets(nums, i + 1, ans);
    }

    public static void printComb(String str, int i, String ans) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        int index = ans.indexOf(str.charAt(i));
        String withSpace = ans.substring(0, index + 1) + " " + ans.substring(index + 1);
        printComb(str, i + 1, withSpace);
        if (i < str.length() - 1) {
            printComb(str, i + 1, ans);
        }
    }


    public static void findMaxProfit(int[] stockPrices) {
        //assume we will have at least two values in the array
        //array:- 8,2,6,4,7,1,4
        //minimumBuy = 2,1
        //maxProfit = 4,5,
        int minimumBuy = stockPrices[0];
        int maxProfit = 0;

        for (int stockPrice : stockPrices) {
            if (stockPrice < minimumBuy) {
                minimumBuy = stockPrice;
            }
            if ((stockPrice - minimumBuy) > maxProfit) {
                maxProfit = stockPrice - minimumBuy;
            }
        }
        System.out.println(maxProfit);
    }

    public static void segregate0And1(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int[] res = new int[arr.length];

        for (int j : arr) {
            if (j == 1) {
                res[left++] = j;
            } else if (j == 0) {
                res[right--] = j;
            }
        }
        System.out.println(Arrays.toString((res)));
    }

    private static String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private static String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return s.substring(i + 1, j);
    }


    public static void findMaximumProfit(int[] arr) {

        //8,4,3,2,1
        //ans =
        int minBuy = arr[0];
        int maxProfit = 0;
        for (int stockPrice : arr) {
            if (stockPrice < minBuy) {
                minBuy = stockPrice;
            }

            if ((stockPrice - minBuy) > maxProfit) {
                maxProfit = stockPrice - minBuy;
            }
        }
        System.out.println(maxProfit);
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int addIndex = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {
                nums[addIndex] = nums[i + 1];
                addIndex++;
            }
        }
        System.out.println(nums[0] + " " + nums[1]);
        return addIndex;

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int climbStairs(int n) {

        if (n <= 2) return n;
        //x=1
        //y=2
        //loop=
        //x=2,3,5
        //y=3,5,8
        //i=2,3,4
        //temp=1,2,3
        int x = 1, y = 2;
        for (int i = 2; i < n; i++) {
            int temp = x;
            x = y;
            y = temp + y;
        }
        return y;

    }

    public static int singleNumberWithNoDuplicate(int[] nums) {

        Arrays.sort(nums);

        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static int findNSum(int[] sum) {
        int result = 0;
        for (int i = 0; i < sum.length; i++) {
            result = result + sum[i];
        }
        return result;
    }

    //TODO: public static String[] topKElements(String[] request, int k)

    public static Stack<Integer> sortStackUsingOtherStack(Stack<Integer>
                                                                  input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!input.isEmpty()) {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while (!tmpStack.isEmpty() && tmpStack.peek()
                    > tmp) {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    private static int maxSubArray(int[] nums) {
        int count = 0;
        int max = nums[0];
        for (int num : nums) {
            count += num;
            if (max < count) {
                max = count;
            }
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }

    public static boolean wildcardMatching(String str, String pattern) {
        boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (pattern.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else if (pattern.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

}















