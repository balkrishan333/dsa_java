package leetcode;

public class _1061_LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        _1061_LexicographicallySmallestEquivalentString obj = new _1061_LexicographicallySmallestEquivalentString();

//        String s1 = "dccaccbdafgeabeeghbigbhicggfbhiccfgbechdicbhdcgahi";
//        String s2 = "igfcigeciahdafgegfbeddhgbacaeehcdiehiifgbhhehhccde";
//        String baseStr = "igfcigeciahdafgegfbeddhgbacaeehcdiehiifgbhhehhccde";

        String s1 = "leetcode", s2 = "programs", baseStr = "sourcecode";

        System.out.println(obj.smallestEquivalentString(s1,s2,baseStr));
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] p = new int[26];

        for (int i = 0; i < 26; ++i) {
            p[i] = i;
        }
        for (int i = 0; i < s1.length(); ++i) {
            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
            int pa = find(a, p), pb = find(b, p);
            if (pa < pb) {
                p[pb] = pa;
            } else {
                p[pa] = pb;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a : baseStr.toCharArray()) {
            char b = (char) (find(a - 'a', p) + 'a');
            sb.append(b);
        }
        return sb.toString();
    }

    /*
        union- find
     */
    private int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }
        return p[x];
    }

}
