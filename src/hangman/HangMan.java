/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import hangman.Classes.Dictionary;
import java.io.IOException;

/**
 *
 * @author armanmasangkay
 */
public class HangMan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Dictionary dict=new Dictionary();
        dict.loadWords();
        
        System.out.println(dict.getWords().size());
    }
    
}
