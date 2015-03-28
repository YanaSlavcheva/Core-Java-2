package com.hackbulgaria.corejava;

import org.apache.commons.lang3.StringUtils;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        
        for (int i = 0; i < words.length; i++){
        	String reverseWord = reverse(words[i]).toString();
            words[i] = reverseWord;
        }
//        for (String word: words){
//        	String reverseWord = reverse(word).toString();
//            sentence = sentence.replace(word, reverseWord);
//        }
        sentence = StringUtils.join(words, " ");
        
        return sentence;
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
