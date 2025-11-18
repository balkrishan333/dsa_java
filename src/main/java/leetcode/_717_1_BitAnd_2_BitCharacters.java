package leetcode;

public class _717_1_BitAnd_2_BitCharacters {

    public static void main(String[] args) {
        _717_1_BitAnd_2_BitCharacters obj =
                new _717_1_BitAnd_2_BitCharacters();

        int[] bits = {1,1,1,0};
        System.out.println(obj.isOneBitCharacter(bits));
    }

    /*
            When reading from the i-th position, if bits[i] == 0, the next character must be at i + 1,
            because 0 is 1-bit; else if bits[i] == 1, the next character must be at i + 2, because 1 is only present
            in 2-bit characters 10 and 11. We increment our read-pointer i to the start of the next character appropriately.
            At the end, if our pointer is at bits.length - 1, then the last character must have a size of 1 bit.
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length-1) {
            i += bits[i] + 1;
        }
        return i == bits.length-1;
    }
}
