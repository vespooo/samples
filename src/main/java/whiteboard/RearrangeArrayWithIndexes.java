package whiteboard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RearrangeArrayWithIndexes {

    public int[] rearrange1approach(int[] arr){
        Set<Integer> present =
        Arrays.stream(arr)
                .boxed()
                .filter(e -> e>=0)
                .collect(Collectors.toSet());
       for (int i=0; i< arr.length; i++) {
            if(present.contains(i)){
                arr[i]=i;
            } else {
                arr[i] = -1;
            }
        }
        return arr;
    }

    public int[] rearrange2approach(int[] arr){
        int i;
        for (i=0; i<=arr.length-1; i++){
            rearrange(arr, i);
        }
        return arr;
    }

    private void rearrange(int[] arr, int i) {
        if(i>=0 && arr[i]>=0 && arr[i]!=i){
            swap(arr, i);
            rearrange(arr, i);
        }
    }

    private void swap(int[] arr, int i) {
        int ref = arr[arr[i]];
        arr[arr[i]] = arr[i];
        arr[i] = ref;
    }


}
