package whiteboard;

import java.util.Arrays;

public class LargestSmallest {

    public static int[] rearrange(int[] arr){
        return rearrangeToLargestSmallestOrder(sort(arr));
    }

    private static int[] rearrangeToLargestSmallestOrder(int[] arr) {
        int n = arr.length;
        if(n<=1) return arr;
        int i = 0;
        int nextEl = arr[0];

        do{
            i = (i< n /2 ? 2*i+1 : 2*(n-1-i));
            int temp = arr[i];
            arr[i] = nextEl;
            nextEl = temp;
        }while (i!= 0);
        i=2;
        do{
            i = (i< n /2 ? 2*i+1 : 2*(n-1-i));
            int temp = arr[i];
            arr[i] = nextEl;
            nextEl = temp;
        }while (i!=2);
        return arr;
    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
