package leetcode;

public class _97_InterleavingString {

    public static void main(String[] args) {
        _97_InterleavingString obj = new _97_InterleavingString();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(obj.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] invalid = new boolean[s1.length()+1][s2.length()+1];
        return dfs(s1, s2, s3, 0, 0, 0, invalid);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {

        if (invalid[i][j]) {
            return false;
        }

        if (k == s3.length()) {
            return true;
        }

        boolean valid = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i+1, j, k+1, invalid)
                || j < s2.length() && s2.charAt(j) == s3.charAt(k) &&dfs(s1, s2, s3, i, j + 1, k+1, invalid);

        if (!valid) {
            invalid[i][j] = true;
        }
        return valid;
    }
}
