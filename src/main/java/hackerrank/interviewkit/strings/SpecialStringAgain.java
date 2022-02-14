package hackerrank.interviewkit.strings;

public class SpecialStringAgain {

    public static void main(String[] args) {
        String str = "asabsb";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);
        System.out.println("count = " + count);
    }

    long count(String str) {
        long result = 0L;

        int[] charCountArr = new int[str.length()];

        for (int i = 0; i < str.length(); ) {
            int j = i+1;
            int charCount = 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                charCount++;
                j++;
            }
            result += (charCount * (charCount+1))/2;
            charCountArr[i] = charCount;
            i = j;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i)) {
                charCountArr[i] = charCountArr[i-1];
            }

            if ((i+1) < str.length() && str.charAt(i-1) == str.charAt(i+1) && str.charAt(i) != str.charAt(i-1)) {
                result += Math.min(charCountArr[i-1], charCountArr[i+1]);
            }
        }
        return result;
    }

    long count_old(String str) {
        long count = str.length();
        int startIndex = 0;
        for (int i = 0, j = i+1; i < str.length() && j < str.length(); ) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                //when all characters in string are same ex: aaaaa
                if (j == str.length()) {
                    if ((j - startIndex) == str.length()) {
                        count = (str.length() * (str.length() +1))/2;
                    } else {
                        int length = j-startIndex;
                        count += ((length * (length +1))/2) - length;
                    }
                }
            } else {
                String subStr1 = str.substring(startIndex, j);
                int currentLength = j-startIndex;
                if (j+currentLength+1 <= str.length()) { //make sure we do not go out of bounds
                    String subStr2 = str.substring(j+1, j+currentLength+1); // add +1 because last index is exclusive
                    if (subStr1.equals(subStr2)) {
                        count++;
                        i++;
                        j = i+1;
                    }else {
                        int length = j-startIndex;
                        count += ((length * (length +1))/2) - length;
                        i++;
                        j = i+1;
                    }
                } else {
                    i++;
                    j++;
                }
                startIndex = i;
            }
        }
        return count;
    }
}
