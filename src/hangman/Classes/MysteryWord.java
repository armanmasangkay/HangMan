/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.Classes;

import java.util.regex.Pattern;

/**
 *
 * @author armanmasangkay
 */
public class MysteryWord {
    
    private final RandomWord rw;
    private String word;
    
    private final char[] randomWord;
    private final char[] mysteryWord;

    public MysteryWord(RandomWord rw) {
        this.rw = rw;
        word=this.rw.getWord();
        
        //save each character to an array;
        randomWord=new char[word.length()];
        mysteryWord=new char[word.length()];
        for (int i=0;i<word.length();i++){
            randomWord[i]=word.charAt(i);
            mysteryWord[i]='_';
        }
        
    }
    
    public boolean checkGuess(Guess guess){
        
        boolean matched=Pattern.compile("["+rw.getWord()+"]")
                .matcher(String.valueOf(guess.getKeyGuess())).matches();
        
        return matched;
    }
  
    public String getWord() {
        String res="";
        for (int i=0;i<mysteryWord.length;i++){
            res+= mysteryWord[i]+" ";
        }
        return res;
    }
    public String getWordWithoutSpace(){
        String res="";
        for (int i=0;i<mysteryWord.length;i++){
            res+= mysteryWord[i];
        }
        return res;
    }
    
    
    public void update(Guess guess){
       for (int i=0;i<mysteryWord.length;i++){        
           if (guess.getKeyGuess()==randomWord[i]){
               mysteryWord[i]=randomWord[i];
           }
       }    
    }
    
    
    
    
    
}
