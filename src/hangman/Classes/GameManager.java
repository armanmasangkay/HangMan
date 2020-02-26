/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.Classes;

/**
 *
 * @author armanmasangkay
 */
public class GameManager {
    private final int triesLimit;
    private int tries;
    private int score;

    public GameManager() {
        triesLimit=10;
        tries=triesLimit;
    }

    public int getTriesLeft() {
        return tries;
    }

    public int getScore() {
        return score;
    }
    
    public int getTriesLimit() {
        return triesLimit;
    }
    
    public void retry(){
        tries=triesLimit;
    }
    public void resetScore(){
        score=0;
    }
    
    public void addScore(){
        score+=1;
    }
     
    public boolean deductTries() {
        if(tries>0){
           tries-=1;
           return true;
        }else{
            return false;
        }
        
    }
    
    
    
    
    
    
    
}
