class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int length = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }

            length = Math.max(length, r - l + 1);
            r++;
        }

        return length;
    }
}
