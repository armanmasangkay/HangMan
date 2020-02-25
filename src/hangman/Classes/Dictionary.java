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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        URL url=getClass().getResource("HangMan/res/1-1000.txt");
        File file = new File(url.getPath()); 
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
    
    
