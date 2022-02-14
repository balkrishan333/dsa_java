package hackerrank.interviewkit.dictionaryandhashmap;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        SherlockAndAnagrams anagrams = new SherlockAndAnagrams();
        long count = anagrams.countAnagrams(str);
        System.out.println("count = " + count);
    }

    public long countAnagrams(String str) {
        Map<Long, Integer> anagramMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            long hash  = calculateHash(str.substring(i, i+1));
            anagramMap.merge(hash, 1, Integer::sum);

            for (int j = i+1; j < str.length(); j++) {
                hash  = calculateHash(str.substring(i, j+1));
                anagramMap.merge(hash, 1, Integer::sum);
            }
        }

        long count = 0;
        for (Map.Entry<Long, Integer> e: anagramMap.entrySet()){
            count += (e.getValue() * (e.getValue()-1))/2;
        }

        return count;
    }

    private long calculateHash(String str) {
        long hash = 1;
        for (int i = 0; i < str.length(); i++) {
            hash = (hashMap().get(str.charAt(i)) * hash) % 1000000007;
        }
        return hash;
    }

    private Map<Character, Integer> hashMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 7);
        map.put('e', 11);
        map.put('f', 13);
        map.put('g', 17);
        map.put('h', 19);
        map.put('i', 23);
        map.put('j', 29);
        map.put('k', 31);
        map.put('l', 37);
        map.put('m', 41);
        map.put('n', 43);
        map.put('o', 47);
        map.put('p', 53);
        map.put('q', 59);
        map.put('r', 61);
        map.put('s', 67);
        map.put('t', 71);
        map.put('u', 73);
        map.put('v', 79);
        map.put('w', 83);
        map.put('x', 89);
        map.put('y', 97);
        map.put('z', 101);

        return map;
    }
}
