package leetcode;

import java.util.*;

public class DinnerPlateStack_1172 {

    private final List<Stack> stacks = new ArrayList<>();
    private final int capacity;
    //stack to push onto will be first element
    private final SortedSet<Integer> pushPriority = new TreeSet<>();
    //stack to pop from will be first element. Sorted in reverse order. Need to pop from right most stack
    private final SortedSet<Integer> popPriority = new TreeSet<>(Comparator.reverseOrder());

    public DinnerPlateStack_1172(int capacity) {
        this.capacity = capacity;
        System.out.println("null");
    }

    public static void main(String[] args) {
        {
            DinnerPlateStack_1172 obj = new DinnerPlateStack_1172(2);
            obj.push(1);
            obj.push(2);
            obj.push(3);
            obj.push(4);
            obj.push(5);

            obj.popAtStack(0);

            obj.push(20);
            obj.push(21);

            obj.popAtStack(0);
            obj.popAtStack(2);

            obj.pop();
            obj.pop();
            obj.pop();
            obj.pop();
            obj.pop();
        }

    /*    {
            DinnerPlateStack_1172 obj = new DinnerPlateStack_1172(1);
            obj.push(1);
            obj.push(2);
//            obj.push(3);
            obj.popAtStack(1);
            obj.pop();
            obj.push(1);
            obj.push(2);
            obj.pop();
            obj.pop();
        }*/
    }

    public void push(int val) {
        if (pushPriority.size() == 0) {
            Stack stack = new Stack(this.capacity);
            stack.push(val);
            stacks.add(stack);
            if (stack.size < this.capacity) {
                pushPriority.add(stacks.size()-1);
            }
            popPriority.add(stacks.size()-1);
        } else {
            Integer targetPushStackIndex = pushPriority.first();
            Stack stack = stacks.get(targetPushStackIndex);
            stack.push(val);
            if (stack.size == capacity) {
                pushPriority.remove(targetPushStackIndex);
            }
            popPriority.add(targetPushStackIndex);
        }
        System.out.println("null");
    }

    public int pop() {
        int retval = -1;
        if (popPriority.size() > 0) {
            Integer targetPopStackIndex = popPriority.first();
            Stack stack = stacks.get(targetPopStackIndex);
            retval = stack.pop();
            if (stack.size == 0) {
                popPriority.remove(targetPopStackIndex);
            }
            pushPriority.add(targetPopStackIndex);
        }
        System.out.println("retval = " + retval);
        return retval;
    }

    public int popAtStack(int index) {
        int returnVal = -1;
        if(index <= stacks.size()-1) {
            Stack stack = stacks.get(index);
            returnVal = stack.pop();
            if (stack.size == 0) {
                popPriority.remove(index);
            }
            pushPriority.add(index);
        }
        System.out.println("popAtStack(" + index + ") = " + returnVal);
        return returnVal;
    }

    class Stack {
        int[] vals;
        int size;
        int capacity;

        Stack(int capacity) {
            this.capacity = capacity;
            vals = new int[capacity];
        }

        public void push(int val) {
            if(size < capacity) {
                vals[size] = val;
                size++;
            }
        }

        public int pop() {
            int ret = -1;
            if(size > 0) {
                ret = vals[size-1];
                size--;
            }
            return ret;
        }

    }
}

