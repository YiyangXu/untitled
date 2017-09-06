package dp;

public class CountNumbersWithUniqeDigits357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0 || n == 1) {
            return ((Number)Math.pow(10, n)).intValue();
        }

        if (n == 2) {
            return 91;
        }

        if(n > 10) {
            return 0;
        }

        int diffLastTime = 81;
        int totalDiff = 91;

        for (int i = 3; i <= n; i++) {
            diffLastTime = diffLastTime * (10 - i + 1);
            totalDiff += diffLastTime;
        }

        return totalDiff;
    }
}
