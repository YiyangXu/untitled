public class Solution {

    public int maxA(int N) {
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = i;
            for (int j = 1; j <= i - 3; j++) {
                result[i] = Math.max(result[i], result[j] * (i - j - 1));
            }
        }

        return result[N];
    }

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
