/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.UI;

import hangman.Classes.Dictionary;
import hangman.Classes.GameManager;
import hangman.Classes.Guess;
import hangman.Classes.MysteryWord;
import hangman.Classes.RandomWord;
import java.awt.Color;

import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *
 * @author armanmasangkay
 */
public final class MainForm extends javax.swing.JFrame {
    Guess myGuess;
    RandomWord randomWord;
    MysteryWord mWord;
    GameManager gm;
    private DrawPane pane;
    /**
     * Creates new form MainForm
     */
    
//    class DrawPane extends JPanel{
//        @Override
//        public void paintComponent(Graphics g) {
//            g.fillRect(0, 0, 100, 200); // Draw on g here e.g.
//        }
//    }
 
    
    
    public MainForm() {
        initComponents();
        //[386, 313]
        Dictionary dict=new Dictionary(); 
        //creates the drawing area
        pane=new DrawPane();
        pane.setSize(386, 313);
        pane.setLocation(25, 50);
        pane.setBackground(Color.lightGray);
        
        pane.setVisible(true);
        this.add(pane);
        this.validate();
      

        gm=new GameManager();
        try {
            dict.loadWords();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problem loading words to the dictionary");
        }
        
        myGuess=new Guess();
        
        
        randomWord=new RandomWord(dict);
        randomWord.generate();
        mWord=new MysteryWord(randomWord);
        System.out.println(randomWord.getWord());
        mysteryLbl.setText(mWord.getWord());
        scoreLbl.setText(String.valueOf(gm.getScore()));
    }
    
    
    public void createBoard(){
        
    }
    
    public void generateNewWord(){
        randomWord.generate();
        mWord=new MysteryWord(randomWord);
        System.out.println(randomWord.getWord());
        mysteryLbl.setText(mWord.getWord());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();
        mysteryLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Score:");

        scoreLbl.setText("<<Score>>");

        mysteryLbl.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        mysteryLbl.setText("<<Word to guess>>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mysteryLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreLbl)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(scoreLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(mysteryLbl)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        pane.draw1();
        pane.draw2();
        pane.draw3();
        pane.draw4();
        pane.draw5();
        //check if there are still available tries
        System.out.println(gm.getTriesLeft());
        if (gm.getTriesLeft()>1){
            //gets your keypressed and update the mystery word everytime you get it right
            myGuess.setKeyGuess(evt.getKeyChar());
            if(mWord.checkGuess(myGuess)){
                mWord.update(myGuess);
                mysteryLbl.setText(mWord.getWord());
                
                
                //checks if the player cracked the word or not
                if(mWord.getWordWithoutSpace().equalsIgnoreCase(randomWord.getWord())){
                   
                    //if yes we show them an option to proceed;
                    //if no we close the app
                    int choice=JOptionPane.showConfirmDialog(rootPane, "Would you like to proceed?",
                            "Horray! You cracked the word",JOptionPane.YES_NO_OPTION);
                    
                    if(choice==0){
                      gm.addScore();
                      scoreLbl.setText(String.valueOf(gm.getScore()));
                      this.generateNewWord(); 
                      gm.retry();
                    }else{
                      System.exit(1);
                    }
                    
                }
                
            }else{
                gm.deductTries();
            }
        }else{
            int choice=JOptionPane.showConfirmDialog(rootPane, "Game Over\n Try again?",
                            "Ooops!",JOptionPane.YES_NO_OPTION);
            
            if (choice==0){
                this.generateNewWord();
                gm.resetScore();
                scoreLbl.setText(String.valueOf(gm.getScore()));
                gm.retry();
            }else{
                System.exit(1);
            }
        }
        
      
      
       
        
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
   
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                 DrawPane dp=new DrawPane();
//                 dp.setSize(386, 313);
//                 dp.setLocation(25, 50);
//                 dp.setBackground(Color.darkGray);
//     
                MainForm main=new MainForm();
//                main.add(dp);
                main.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mysteryLbl;
    private javax.swing.JLabel scoreLbl;
    // End of variables declaration//GEN-END:variables
}
