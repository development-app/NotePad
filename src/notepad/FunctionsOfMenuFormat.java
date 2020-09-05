/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Font;

/**
 *
 * @author EXTREME
 */
public class FunctionsOfMenuFormat {
 Frame frame;
 Font arial, comicSansMS, courierNew, msGothic;
 String selectedFont;
 
 public FunctionsOfMenuFormat(Frame frame){
  this.frame = frame;
 }
 
 public void createFont(int size){
   arial = new Font("Arial",Font.PLAIN, size);
   comicSansMS = new Font("Comic Sans MS",Font.PLAIN, size);
   courierNew = new Font("Courier New",Font.PLAIN, size);
   msGothic = new Font("MS Gothic",Font.PLAIN, size);
   choiceOfFont(selectedFont);
 }
  
 public void choiceOfFont(String font){
   selectedFont = font;
 
   if (selectedFont.equals("Arial")){ frame.textArea.setFont(arial);}
   if (selectedFont.equals("Comic Sans MS")) {frame.textArea.setFont(comicSansMS);}
   if (selectedFont.equals("Courier New")) {frame.textArea.setFont(courierNew);}
   if (selectedFont.equals("MS Gothic")) {frame.textArea.setFont(msGothic);}
   
   }
   
    
 
 
}
