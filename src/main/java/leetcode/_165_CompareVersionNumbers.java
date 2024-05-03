package leetcode;

public class _165_CompareVersionNumbers {

    public static void main(String[] args) {
        _165_CompareVersionNumbers obj = new _165_CompareVersionNumbers();

        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(obj.compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1Split = version1.split("\\.");
        String[] v2Split = version2.split("\\.");

        int max = Math.max(v1Split.length, v2Split.length);

        for (int i = 0; i < max; i++) {
            int v1 = i < v1Split.length ? Integer.parseInt(v1Split[i]) : 0;
            int v2 = i < v2Split.length ? Integer.parseInt(v2Split[i]) : 0;

            if (v1 > v2) {
                return 1;
            } else if (v2 > v1) {
                return -1;
            }
        }
        return 0;
    }
}
