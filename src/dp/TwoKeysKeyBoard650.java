package dp;

public class TwoKeysKeyBoard650 {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = i;
            for (int j = 2; j <= Math.pow(i, 0.5); j ++) {
                if (i % j == 0) {
                    result[i] = result[j] + result[i / j];
                    break;
                }
            }
        }
        return result[n];
    }
}
