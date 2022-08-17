package Unique_Morse_Code_Words;

import java.util.*;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String code[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> uniqueCode=new HashSet<String>();
        for(String word:words){
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<word.length();i++){
                builder.append(code[word.charAt(i)-'a']);
            }
            uniqueCode.add(builder.toString());
        }
        
        return uniqueCode.size();
    }
}
