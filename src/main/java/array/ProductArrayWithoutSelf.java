package array;

import java.util.Arrays;

public class ProductArrayWithoutSelf {

    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};

        System.out.println(Arrays.toString(productArrayWithoutSelf(arr)));
    }




    public static int[] productArrayWithoutSelf(int[] arr){

        //1,2,3,4
        int[] start = new int[arr.length];
        int[] end = new int[arr.length];
        int[] result = new int[arr.length];

        start[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            int product = arr[i] * start[i - 1];
            start[i] = product;
        }

        end[arr.length - 1] = arr[arr.length - 1];
        int z = 0;
        for(int i = arr.length - 2; i >= 0; i--){
            int product = arr[i] * end[i + 1];
            end[i] = product;
        }

        for(int j = 0; j < arr.length; j++){
            int k = 1;

            if(j + 1 < arr.length){
                k = end[j + 1];
            }

            if(j - 1 >= 0){
                k = k * start[j - 1];
            }

            result[j] = k;
        }
        return result;
    }
}
