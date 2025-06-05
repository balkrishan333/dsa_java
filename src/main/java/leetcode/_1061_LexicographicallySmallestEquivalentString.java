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

    /*
        Use union find (disjoint set) algo to create sets/partitions. Root (Representative) element should be the
        smallest element. For each charter get the root element from the group, since root is the smallest element,
        it guarantees that it will be lexicographically the smallest string.
     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];

        //create a new group for each character
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); ++i) {
            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';

            int parent_a = find(a, parent), parent_b = find(b, parent);
            if (parent_a < parent_b) { //make smaller parent the root
                parent[parent_b] = parent_a;
            } else {
                parent[parent_a] = parent_b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char a : baseStr.toCharArray()) {
            char b = (char) (find(a - 'a', parent) + 'a');
            sb.append(b);
        }
        return sb.toString();
    }

    /*
        union-find
     */
    private int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }
        return p[x];
    }

}
