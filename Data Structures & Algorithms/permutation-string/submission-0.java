class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowLength = s1.length();
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < windowLength; i++) {
            char ch = s2.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
        }
        if (s1Map.equals(windowMap)) {
            return true;
        }

        for (int right = windowLength; right < s2.length(); right++) {
            char entering = s2.charAt(right);
            char leaving = s2.charAt(right - windowLength);
            windowMap.put(entering,windowMap.getOrDefault(entering, 0) + 1);
            windowMap.put(leaving, windowMap.get(leaving) - 1);
            if (windowMap.get(leaving) == 0) {
                windowMap.remove(leaving);
            }
            if (s1Map.equals(windowMap)) {
                return true;
            }
        }
        return false;
    }
}