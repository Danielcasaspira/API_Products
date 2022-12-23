package interview;

import java.util.HashMap;
import java.util.Map;

public class _Interview {

    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String word){
        StringBuilder checkWord = new StringBuilder(word);
        return word.equals(checkWord.reverse());

    }

    public static String countWords(String word){
       boolean flag  = false;
       Map<Integer,String > countString =  new HashMap<Integer, String>();
        for(int i= 0; i< word.length();i++){


        }
    }

    select Name,number from Building letf join Aparments on Id.Building = Id.Aparments where Name _= 'Building 1'


}
