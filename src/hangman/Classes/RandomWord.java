/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.Classes;

import java.util.Random;

/**
 *
 * @author armanmasangkay
 */
public class RandomWord {
    private final Dictionary dict;
    private String word;
            
    public RandomWord(Dictionary dict) {
        this.dict = dict;
    }

    public String getWord() {
        return word;
    }
    
    public void generate(){
        
       String tempWord;
       
        //this will make sure that we only have 3 or more letters to guess
        do{
            Random rand=new Random();
            int randIndex=rand.nextInt(dict.getWords().size());
            tempWord=dict.getWords().get(randIndex);
        }while(tempWord.length()<3);
        
        
      word=tempWord;
    }
}
