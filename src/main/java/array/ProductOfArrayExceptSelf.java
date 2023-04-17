package array;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductOfArrayExceptSelf {

   // https://www.youtube.com/@CodeHelp/playlists
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        Stream.of(findProduct(arr))
                .forEach(System.out::print);


    }

    private static int[] findProduct(int[] arr) {
        return new int[0];
    }
}


class  Bucket {
    int key;
    TreeSet arr;

}

class HashTable {
    List<Bucket> buckets;


}


