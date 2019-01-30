package anton;

public class PowerArray {
    public int[] powerArray(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int i = 0;
        int j = n-1;
        int k = n-1;
        while (i<j){
            int beginEl = arr[i]*arr[i];
            int endEl = arr[j]*arr[j];
            if (beginEl>=endEl){
                result[k] = beginEl;
                i++;
                k--;
            } else{
                result[k] = endEl;
                j--;
                k--;
            }
        }
        if (k==0) result[k] = arr[i]*arr[i];
        return result;
    }
}
