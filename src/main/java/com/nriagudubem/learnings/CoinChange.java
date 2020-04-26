package com.nriagudubem.learnings;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

public class CoinChange {

    private Log log = LogFactory.getLog(CoinChange.class);

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }


        if (coins.length == 1 && amount % coins[0] == 0) {
            return amount / coins[0];
        }

        Arrays.sort(coins);
        int remainder = amount;
        int counter = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (remainder >= coins[i]) {
                if (remainder % coins[i] == 0 && counter == 0) {
                    counter += remainder / coins[i];
                    remainder = remainder % coins[i];
                    break;
                } else {
                    counter += remainder / coins[i];
                    remainder = remainder % coins[i];
                }
            }
        }

        return (remainder == 0) ? counter : -1;
    }

}
