package whiteboard;

import java.util.Arrays;

public class MinimumSwapsToBringElTogether {

    public static int countSwaps(int[] arr, int k) {
        if(arr.length<=2) return 0;
        int lessThenK = (int) Arrays.stream(arr).boxed().filter(e -> e <= k).count();
        if (lessThenK<=1) return 0;
        int moreThenKInWindow = (int) Arrays.stream(arr, 0, lessThenK).boxed().filter(e -> e > k).count();
        int minswaps = moreThenKInWindow;
        for (int i = 1, j = lessThenK; j < arr.length; i++, j++) {
            if (arr[i - 1] > k) moreThenKInWindow--;
            if (arr[j] > k) moreThenKInWindow++;
            if (minswaps > moreThenKInWindow) minswaps = moreThenKInWindow;
        }
        return minswaps;
    }
}
