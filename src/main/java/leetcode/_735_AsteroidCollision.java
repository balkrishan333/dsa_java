package leetcode;

import java.util.*;

public class _735_AsteroidCollision {

    public static void main(String[] args) {
        _735_AsteroidCollision obj = new _735_AsteroidCollision();

        int[] asteroids = {-2,1,-1,-1};
        System.out.println(Arrays.toString(obj.asteroidCollision(asteroids)));
    }

    /*
        Approach : Stack

        See inline comments
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean flag = true; //will be added to stack

            // 2nd condition is the only condition when asteroids will be moving towards each other
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {

                // If the top asteroid in the stack is smaller, then it will explode.
                // so pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if (flag) {
                st.push(asteroid);
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.pop();
        }

        return remainingAsteroids;
    }
}
