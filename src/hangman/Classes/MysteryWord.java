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
    

    public MysteryWord(RandomWord rw) {
        this.rw = rw;
        word=rw.getWord().replaceAll(".", "- ");
    }
    
    public boolean checkGuess(Guess guess){
        
        boolean matched=Pattern.compile("["+rw.getWord()+"]")
                .matcher(String.valueOf(guess.getKeyGuess())).matches();
        
        return matched;
    }
  
    public String getWord() {
        return word;
    }
    
    public void update(Guess guess){
        //String guessStr=String.valueOf(guess.getKeyGuess());
        String regex="[^"+rw.getWord()+"]";
        word=rw.getWord().replaceAll(regex, "_ " );
    }
    
    
    
    
    
}
