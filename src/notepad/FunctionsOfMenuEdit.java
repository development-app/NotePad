/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EXTREME
 */
public class FunctionsOfMenuEdit {
    
   Frame frame;
   
   public FunctionsOfMenuEdit(Frame frame){
   this.frame = frame;
   }
   
   public void callItemUndo (){
    try{
       frame.undoManager.undo();
    } catch(Exception ex) {
    
       }
   }
   
   public void callItemRedo(){
     try {
         frame.undoManager.redo();
    } catch (Exception ex) {
       
         }
   }
   
   public void callItemTimeDate(){
   Date date = new Date();
   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("k:mm:ss  dd.MM.yyyy г.");
   frame.textArea.setText(frame.textArea.getText() + simpleDateFormat.format(date));
   }
    
}
