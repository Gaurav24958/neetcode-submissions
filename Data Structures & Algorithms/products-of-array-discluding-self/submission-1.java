class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroPos = -1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPos = i;
                zeroCount++;
            } else {
                product = product * nums[i];
            }
        }

        int[] result = new int[nums.length];
        if (zeroCount > 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                result[zeroPos] = product;
            } else {
                int ans = product / nums[i];
                result[i] = ans;
            }
        }

        return result;
    }
}