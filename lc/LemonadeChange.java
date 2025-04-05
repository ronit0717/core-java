//Generic Solution
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] denomCount = {0, 0, 0};
        int[] denom = {5, 10, 20};
        for (int i = 0; i < bills.length; i++) {
            addDenomCount(denom, denomCount, bills[i]);
            int change = bills[i] - 5;
            int j = 2;
            while(change > 0 && j >= 0) {
                change = getChange(j, denom, denomCount, change);
                j--;
            }
            if (change != 0) {
                return false;
            }
        }
        return true;
    }

    private void addDenomCount(int[] denom, int[] denomCount, int price) {
        for (int i = 0; i < denom.length; i++) {
            if (denom[i] == price) {
                denomCount[i]++;
                return;
            }
        }
    }

    private int getChange(int i, int[] denom, int[] denomCount, int price) {
        if (price < denom[i]) {
            return price;
        }
        int count = Math.min(denomCount[i], price / denom[i]);
        denomCount[i] -= count;
        return price - count * denom[i];
    }
}

//Non generic faster solution
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    }
                    five -= 3;
                } else {
                    if (five == 0) {
                        return false;
                    }
                    ten--;
                    five--;
                }
            }
        }
        return true;
    }
}