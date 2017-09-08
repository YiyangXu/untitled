package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers638 {
    // exceed ttl
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] count = new int[price.size() + special.size()];
        return shoppingHelper(price, special, needs, new int[needs.size()], count, 0);
    }

    public int shoppingHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] current,
                              int[] count, int cost) {
        boolean good = true;
        for (int i = 0 ; i < current.length; i++) {
            if (current[i] != needs.get(i)) {
                good = false;
            }
            if (current[i] > needs.get(i)) {
                return Integer.MAX_VALUE;
            }
        }

        if (good) {
            return cost;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            count[i] += 1;
            if (i >= price.size()) {
                List<Integer> offer = special.get(i - price.size());
                for (int j = 0; j < offer.size() - 1; j++) {
                    current[j] += offer.get(j);
                }
                cost += offer.get(offer.size() - 1);

            } else {
                current[i] += 1;
                cost += price.get(i);
            }
            min = Math.min(shoppingHelper(price, special, needs, current, count, cost), min);
            count[i] -= 1;
            if (i >= price.size()) {
                List<Integer> offer = special.get(i - price.size());
                for (int j = 0; j < offer.size() - 1; j++) {
                    current[j] -= offer.get(j);
                }
                cost -= offer.get(offer.size() - 1);
            } else {
                current[i] -= 1;
                cost -= price.get(i);
            }
        }
        return min;
    }
}
