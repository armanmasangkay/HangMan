/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author armanmasangkay
 */
public class Dictionary {
    private List<String> words;

    public Dictionary() {
        words=new ArrayList<>();
    }

    public List<String> getWords() {
        return words;
    }
    
    
    
    public boolean loadWords() throws IOException{
        
        
        File file = new File("res/words.txt"); 
   
        System.out.println(file.getPath());
        BufferedReader br; 
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
           return false;
        }
         //saves every line to the list
        String st; 
        while ((st = br.readLine()) != null) {
            words.add(st);
        }
        return true;
          
     }       
        
}
    
    
