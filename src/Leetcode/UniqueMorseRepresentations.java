package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] MORSECODE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> sets = new HashSet<>();
        for(int i=0;i<words.length;i++){
            StringBuffer tmp =new StringBuffer();
            String word=words[i].toLowerCase();
            for(int j=0;j<word.length();j++){
                char ch = word.charAt(j);
                tmp.append(MORSECODE[ch-97]);
            }
            sets.add(tmp.toString());
        }
        return sets.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }
}

