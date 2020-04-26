package com.nriagudubem.learnings

import com.nriagudubem.learnings.CoinChange
import spock.lang.Specification

class CoinChangeSpec extends Specification {

    private CoinChange coinChange

    void setup() {
        coinChange = new CoinChange()
    }

    def 'test coinChange when amount cannot be made up should return -1'() {
        given:
        int[] coins = [2]
        int amount = 3

        when:
        int numberOfCoins = coinChange.coinChange(coins, amount)

        then:
        assert numberOfCoins == -1
    }

    def 'test coinChange when amount can be made should return correct number of coins'() {
        given:
        int[] coins = [1, 2, 5]
        int amount = 11

        when:
        int numberOfCoins = coinChange.coinChange(coins, amount)

        then:
        assert numberOfCoins == 3
    }

    def 'test coinChange when amount can be made up with only one denomination should return correct number of coins'() {
        given:
        int[] coins = [1, 2, 5, 7]
        int amount = 14

        when:
        int numberOfCoins = coinChange.coinChange(coins, amount)

        then:
        assert numberOfCoins == 2
    }

    def 'test coinChange when coins is empty should return -1'() {
        given:
        int[] coins = []
        int amount = 11

        when:
        int numberOfCoins = coinChange.coinChange(coins, amount)

        then:
        assert numberOfCoins == -1
    }

    def 'test coinChange with large input should return correct number of coins'() {

    }

    def 'test coinChange when amount is 0 should return 0'() {
        given:
        int[] coins = [0, 0, 3, 5, 2]
        int amount = 0

        when:
        int numberOfCoins = coinChange.coinChange(coins, amount)

        then:
        assert numberOfCoins == 0
    }
}
