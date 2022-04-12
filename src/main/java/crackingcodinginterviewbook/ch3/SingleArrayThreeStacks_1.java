package crackingcodinginterviewbook.ch3;

public class SingleArrayThreeStacks_1 {

    private static final int noOfStacks = 3;
    private static final int stackCapacity = 3;
    private final int[] vals = new int[noOfStacks*stackCapacity];
    private final int[] stackSize = new int[noOfStacks];

    public static void main(String[] args) {
        SingleArrayThreeStacks_1 obj = new SingleArrayThreeStacks_1();
        obj.push(0, 1);
        obj.push(0, 2);
        obj.push(0, 3);
        obj.push(1, 4);
        obj.push(1, 5);
        obj.push(1, 6);
        obj.push(2, 7);
        obj.push(2, 8);
        obj.push(2, 9);

        System.out.println("obj.pop(0) = " + obj.pop(0));
        System.out.println("obj.pop(1) = " + obj.pop(1));
        System.out.println("obj.pop(2) = " + obj.pop(2));
        System.out.println("obj.pop(0) = " + obj.pop(0));
        System.out.println("obj.pop(1) = " + obj.pop(1));
        System.out.println("obj.pop(2) = " + obj.pop(2));
        System.out.println("obj.pop(0) = " + obj.pop(0));
        System.out.println("obj.pop(1) = " + obj.pop(1));
        System.out.println("obj.pop(2) = " + obj.pop(2));
    }

    public void push(int index, int val) {
        if (stackSize[index] == stackCapacity) {
            return;
        }

        int insertIndex = index*stackCapacity + stackSize[index];
        vals[insertIndex] = val;
        stackSize[index]++;
    }

    public int pop(int index) {
        if (index > noOfStacks-1) {
            throw new IllegalArgumentException();
        }

        if (stackSize[index] == 0) {
            throw new IllegalArgumentException("Stack empty");
        }

        int valIndex = index*stackCapacity + stackSize[index]-1;
        stackSize[index]--;
        return vals[valIndex];
    }
}
