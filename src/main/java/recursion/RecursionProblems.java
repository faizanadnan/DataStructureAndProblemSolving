package recursion;

public class RecursionProblems {


    public static void main(String[] args) {
       /* System.out.println(sum(new int[]{1, 2, 3, 4, 5}, 0, 5));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 0, 5, 6));
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 0, 5, 4));*/
        int[] ints = {1, 2, 3, 3, 3, 3, 3, 3, 4, 5};
        System.out.println(findFirstAndLastOccurrence(ints, 0, ints.length, 3));



        int[] rotatedArray = {3, 4, 5, 6, 1, 2}; // homework, search element in right rotated array
    }

    private static String findFirstAndLastOccurrence(int[] arr, int start, int end, int element) {
        int indexFirst = findFirstOccurrence(arr, start, end, element);
        int indexLast = findLastOccurrence(arr, start, end, element);
        return indexFirst + "," + indexLast;
    }


    private static int findLastOccurrence(int[] arr, int start, int end, int element) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;

        int midElement = arr[mid];
        if (midElement == element) {
            if (mid == arr.length - 1 || arr[mid + 1] > arr[mid]) return mid;

            if (arr[mid + 1] == arr[mid]) {
                return findLastOccurrence(arr, mid + 1, end, element);
            } else {
                return findLastOccurrence(arr, start, mid - 1, element);

            }
        }

        if (arr[mid] < element)
            return findLastOccurrence(arr, mid + 1, end, element);
        else
            return findLastOccurrence(arr, start, mid - 1, element);
    }

    private static int findFirstOccurrence(int[] arr, int start, int end, int element) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;

        int midElement = arr[mid];
        if (midElement == element) {
            if (mid == 0 || arr[mid - 1] < arr[mid]) return mid;

            if (arr[mid - 1] == arr[mid]) {
                return findFirstOccurrence(arr, start, mid - 1, element);
            } else {
                return findFirstOccurrence(arr, mid + 1, end, element);
            }
        }

        if (arr[mid] < element)
            return findFirstOccurrence(arr, mid + 1, end, element);
        else
            return findFirstOccurrence(arr, start, mid - 1, element);
    }


    private static boolean search(int[] arr, int start, int end, int element) {
        if (start == end) return false;
        // if (arr[start] > element) return false;
        if (arr[start] == element) return true;

        return search(arr, start + 1, end, element);
    }

    private static int sum(int[] arr, int start, int end) {
        if (start == end) return 0;
        return arr[start] + sum(arr, start + 1, end);
    }
}
