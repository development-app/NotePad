/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Color;

/**
 *
 * @author EXTREME
 */
public class FunctionsOfMenuColor {
    Frame frame;
    
    public FunctionsOfMenuColor(Frame frame){
     this.frame = frame;
    }
    
    public void setColor(String color){
      // Установим цвет шрифта
      if (color == "Smoky"){frame.textArea.setBackground(new Color(220,220,220));
      // Установим цвет шрифта
      frame.textArea.setForeground(Color.black);
      // Установим цвет курсора
      frame.textArea.setCaretColor(Color.black);}
      
      if (color == "AntiqueWhite") {
      frame.textArea.setBackground(new Color(250,235,215));
      frame.textArea.setForeground(new Color(128,0,128));
      frame.textArea.setCaretColor(new Color(128,0,128));}
      
      if (color == "BlackТоmato") {
      frame.textArea.setBackground(Color.black);
      frame.textArea.setForeground(new Color(255,99,71)); 
      frame.textArea.setCaretColor(new Color(255,99,71));}
      
      if (color == "AquaMarine") {frame.textArea.setBackground(new Color(102,205,170));
      frame.textArea.setForeground(new Color(0,0,139));
      frame.textArea.setCaretColor(new Color(0,0,139));}
    }
    
    
    
}
