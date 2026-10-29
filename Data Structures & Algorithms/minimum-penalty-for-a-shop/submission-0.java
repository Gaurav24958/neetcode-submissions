class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] countN = new int[n + 1];
        int[] countY = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            countN[i] = countN[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                countN[i]++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            countY[i] = countY[i + 1];
            if (customers.charAt(i) == 'Y') {
                countY[i]++;
            }
        }

        int minP = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = countN[i] + countY[i];

            if (penalty < minP) {
                minP = penalty;
                index = i;
            }
        }

        return index;
    }
}