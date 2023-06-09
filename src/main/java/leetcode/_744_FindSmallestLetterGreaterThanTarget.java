package leetcode;

public class _744_FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        _744_FindSmallestLetterGreaterThanTarget obj = new _744_FindSmallestLetterGreaterThanTarget();

        char[] letters = {'c','f','j'};
        char target = 'k';

        System.out.println(obj.nextGreatestLetter(letters, target));
    }

    /*
        Binary search
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left >= letters.length ? letters[0] : letters[left];
    }

    public char nextGreatestLetter_v1(char[] letters, char target) {
        int lo = 0, hi = letters.length;

        while (lo < hi) {
            int mid = lo + (hi -lo)/2;

            if (letters[mid] == target) {
                mid++;
                while (mid < letters.length) {
                    if (letters[mid] != target) {
                        return letters[mid];
                    }
                    mid++;
                }
                //no letter larger than target found, loop through and return 1st letter
                return letters[0];
            } else if (letters[mid] < target) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }

        if (lo < letters.length && letters[lo] > target) {
            return letters[lo];
        }

        if (lo+1 < letters.length) {
            return letters[lo+1];
        }
        return letters[0];
    }
}
