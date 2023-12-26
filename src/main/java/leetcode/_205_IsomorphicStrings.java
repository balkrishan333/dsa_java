package leetcode;

public class _205_IsomorphicStrings {

    public static void main(String[] args) {
        _205_IsomorphicStrings obj = new _205_IsomorphicStrings();

        String s = "paper", t = "title";
        System.out.println(obj.isIsomorphic(s,t));
    }

    public boolean isIsomorphic(String s, String t) {
        int[] tMap = new int[256];
        int[] sMap = new int[256];

        //To start of, all indexes in tMap and sMap are equal (equal to 0)

        for (int i = 0; i < s.length(); i++) {
            //below condition will be true only if chars in both strings are not in same order. For eg: s = aab, t = bbb
            if (sMap[s.charAt(i)] != tMap[t.charAt(i)]) {
                return false;
            }

            //set the chars at index i to same value, that means char in s at index i is mapped to char in t at index i
            sMap[s.charAt(i)] = i +1;
            tMap[t.charAt(i)] = i +1;
        }
        return true;
    }
}
