package dp;

public class FourKeyWord651 {

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
}
