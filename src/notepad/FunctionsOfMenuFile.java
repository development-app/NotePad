/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EXTREME
 */
public class FunctionsOfMenuFile   {
    
    Frame frame;
    File file;
    JFileChooser fileChooser;
    private String fileName = null;
    private String fileDirectory = null;
    String selectedFilter;
    final String charSet = "Cp1251";
     
    
    // передадим объект класса Frame в Конструктор класса FunctionsOfMenuFile
    public FunctionsOfMenuFile(Frame frame){
     this.frame = frame;
    }
    
    public void callItemNew(){
     frame.textArea.setText("");
     frame.setTitle("Новый");
    }
    
    public void callItemOpen() throws IOException{
   
    JFileChooser fileChooser = new JFileChooser ();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setFileFilter(new FileTypeFilter(".txt", "Text file"));
   
   int userChoose = fileChooser.showOpenDialog(null);
   
   if (userChoose == JFileChooser.APPROVE_OPTION){
   int lastFullStop = fileChooser.getSelectedFile().getName().lastIndexOf(".");
   fileName = fileChooser.getSelectedFile().getName().substring(0, lastFullStop);
   frame.setTitle(fileName + " - Блокнот");
   
   fileDirectory = fileChooser.getSelectedFile().getAbsolutePath();
 
   }
     readFile(fileDirectory);
    }
    
    
     public void readFile(String fileDirectory) {
       try {
  
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(new FileInputStream(fileDirectory),Charset.forName("UTF-8")));
             
             frame.textArea.setText("");
             
             String line = null;
             
             while ((line = bufferedReader.readLine()) != null) {
             frame.textArea.append(line + "\n"); // Метод append() добавит текст в текстовую область
             }
             bufferedReader.close();
             
             }    catch (Exception e) {
            
            }
             
              
             
     }
    
    public void callItemSave(){
        
        if (fileName == null){
          callItemSaveAs();
        }
        else{
        try{
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileDirectory), Charset.forName("UTF-8")));
        bufferedWriter.write(frame.textArea.getText());
        bufferedWriter.close();
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null, "Что-то пошло не так...");
        }
        }
    }
    
    public void callItemSaveAs(){
    fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Сохранить как...");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
    fileChooser.setFileFilter(new FileTypeFilter(".txt", "Text file"));
    fileChooser.setFileFilter(new FileTypeFilter(".pdf", "Text file"));
    fileChooser.setFileFilter(new FileTypeFilter(".doc", "Word file"));
    fileChooser.setFileFilter(new FileTypeFilter(".docx", "Word file"));
   
    int userChoose = fileChooser.showSaveDialog(null);
  
    if (userChoose == JFileChooser.APPROVE_OPTION){
        fileName = fileChooser.getSelectedFile().getName();
        frame.setTitle(fileName);
        
         addExtensionToFile();
        }
    writeFile(fileDirectory);
    } 
    
     public void addExtensionToFile (){
       
        selectedFilter = fileChooser.getFileFilter().getDescription();
        
        if (selectedFilter.contains("txt")){
        fileDirectory = fileChooser.getSelectedFile().getAbsolutePath().concat(".txt");
        }
        if (selectedFilter.contains("pdf")){
        fileDirectory = fileChooser.getSelectedFile().getAbsolutePath().concat(".pdf");
        }
        if (selectedFilter.contains("doc")){
        fileDirectory = fileChooser.getSelectedFile().getAbsolutePath().concat(".doc");
        }
        if (selectedFilter.contains("docx")){
        fileDirectory = fileChooser.getSelectedFile().getAbsolutePath().concat(".docx");
        }
    
    }
    
      public void writeFile(String fileDirectory){
    try {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileDirectory),"UTF-8"));
        bufferedWriter.write(frame.textArea.getText());
        bufferedWriter.close();
        
         } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Файл не сохранен!");
    }
   
    }
    
    
    public void callItemExit(){
      System.exit(0);
    }
    
   
}
