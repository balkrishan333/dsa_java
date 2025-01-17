package leetcode;

public class _2683_NeighboringBitwiseXOR {

    public static void main(String[] args) {
        _2683_NeighboringBitwiseXOR obj = new _2683_NeighboringBitwiseXOR();

        int[] derived = {1,1,0};
        System.out.println(obj.doesValidArrayExist(derived));
    }

    /*
        derived[0] = original[0] XOR original[1]
        derived[1] = original[1] XOR original[2]
        derived[2] = original[2] XOR original[3]
        derived[3] = original[3] XOR original[4]

        ...

        derived[n-1] = original[n-1] XOR original[0]

        Each element in original appears exactly twice in the equations: once as original[i] and once as original[i+1]

        Since XOR is both commutative and associative, the order doesn’t matter. When all occurrences of original[i] are XORed together,
        they cancel each other out: original[0] XOR original[0] XOR original[1] XOR original[1] ... = 0

        we make use of this property.

     */
    public boolean doesValidArrayExist(int[] derived) {
        int xorResult = 0;

        for (int num : derived) {
            xorResult = xorResult ^ num;
        }
        return xorResult == 0;
    }
}
