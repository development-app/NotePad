/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


/**
 *
 * @author EXTREME
 */
public class Frame extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // Пункты меню Файл
    JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs, menuItemExit;
    // Пункты меню Правка
    JMenuItem menuItemUndo, menuItemRedo, menuItemTimeDate;
    // Подменю меню Формат
    JMenu  menuFont, menuFontSize;
    // Подпункты меню Шрифт (menuItemFont)
    JMenuItem menuItemArial, menuItemComicSansMS, menuItemCourierNew, menuItemMSGothic;
    // Подпункты меню Размер Шрифта (menuFontSize)
    JMenuItem fontSize16, fontSize20, fontSize24, fontSize28, fontSize32, fontSize36; 
    // Пункты меню Цвет
    JMenuItem  menuItemSmoky, menuItemAntiqueWhite, menuItemBlackТоmato, menuItemAquaMarine;
    
   
    
    JTextArea textArea; // Текстовая область для ввода текста
    JScrollPane scrollPane; // Полоса прокрутки
    // передадим объект класса Frame в Конструктор класса FunctionsOfMenuFile посредством this
    FunctionsOfMenuFile functionsOfMenuFile = new FunctionsOfMenuFile(this);
    FunctionsOfMenuFormat functionsOfMenuFormat = new FunctionsOfMenuFormat(this);
    FunctionsOfMenuColor functionsOfMenuColor = new FunctionsOfMenuColor(this);
    FunctionsOfMenuEdit functionsOfMenuEdit = new FunctionsOfMenuEdit(this);
     
     UndoManager undoManager = new UndoManager();
    
    Frame (){
    super("Блокнот");
    setBounds (400, 200, 700, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true); 
    setIconImage(Toolkit.getDefaultToolkit().getImage(
            getClass().getResource("NotePad.png")));
   
    createTextArea();
    createMenuBar();
    createMenuFile();
    createMenuEdit();
    createMenuFormat();
    addItemsInMenuFormat(); 
    createMenuColor();
    
   
    functionsOfMenuFormat.choiceOfFont("Arial");
    functionsOfMenuFormat.createFont(16);
    
    setVisible(true);
  
    }
    
    // Создадим меню в контейнере
    public void createMenuBar () {
    menuBar = new JMenuBar();  
    setJMenuBar(menuBar); // Добавить панель menuBar в контейнер frame
     
    menuFile = new JMenu("Файл");  
    menuBar.add(menuFile); // Добавляем меню menuFile на панель menuBar
    
    
    menuEdit = new JMenu("Правка");
    menuBar.add(menuEdit);
    
    
    menuFormat = new JMenu("Формат");
    menuBar.add(menuFormat);
   
    
    menuColor = new JMenu("Цвет");
    menuBar.add(menuColor);
    }
    
    public void createMenuFile (){
    menuItemNew = new JMenuItem("Новый");
    menuItemNew.addActionListener(this);
    menuItemNew.setActionCommand("New");
    
    menuItemOpen = new JMenuItem("Открыть");
    menuItemOpen.addActionListener(this);
    menuItemOpen.setActionCommand("Open");
    
    menuItemSave = new JMenuItem("Сохранить");
    menuItemSave.addActionListener(this);
    menuItemSave.setActionCommand("Save");
    
    menuItemSaveAs = new JMenuItem("Сохранить как...");
    menuItemSaveAs.addActionListener(this);
    menuItemSaveAs.setActionCommand("Save As");
    
    menuItemExit = new JMenuItem("Выход");
    menuItemExit.addActionListener(this);
    menuItemExit.setActionCommand("Exit");
    
    menuFile.add(menuItemNew);
    menuFile.add(menuItemOpen);// Добавляем пункты в меню menuFile
    menuFile.add(menuItemSave);
    menuFile.add(menuItemSaveAs);
    menuFile.add(menuItemExit);
    }
    
    public void createMenuEdit(){
    menuItemUndo = new JMenuItem("Отменить");
    menuItemRedo = new JMenuItem("Вернуть");
    menuItemTimeDate = new JMenuItem("Дата и Время");
   
    menuEdit.add(menuItemUndo);
    menuEdit.add(menuItemRedo);
    menuEdit.add(menuItemTimeDate);
    
    menuItemUndo.addActionListener(this);
    menuItemUndo.setActionCommand("Undo");
    
    menuItemRedo.addActionListener(this);
    menuItemRedo.setActionCommand("Redo");
    
    menuItemTimeDate.addActionListener(this);
    menuItemTimeDate.setActionCommand("TimeDate");
    
    }
    
    public void createMenuFormat(){
    menuFont = new JMenu("Шрифт");
    menuFontSize = new JMenu("Размер шрифта");
    menuFormat.add(menuFont);
    menuFormat.add(menuFontSize);
    
    menuItemArial = new JMenuItem("Arial");
    menuFont.add(menuItemArial);
    menuItemComicSansMS = new JMenuItem("Comic Sans MS");
    menuFont.add(menuItemComicSansMS);
    menuItemCourierNew = new JMenuItem("Courier New");
    menuFont.add(menuItemCourierNew);
    menuItemMSGothic = new JMenuItem("MS Gothic");
    menuFont.add(menuItemMSGothic);
   
    fontSize16 = new JMenuItem("16");
    menuFontSize.add(fontSize16);
    fontSize20 = new JMenuItem("20");
    menuFontSize.add(fontSize20);
    fontSize24 = new JMenuItem("24");
    menuFontSize.add(fontSize24);
    fontSize28 = new JMenuItem("28");
    menuFontSize.add(fontSize28);
    fontSize32 = new JMenuItem("32");
    menuFontSize.add(fontSize32); 
    fontSize36 = new JMenuItem("36");
    menuFontSize.add(fontSize36);
   }
    
    public void addItemsInMenuFormat(){
    menuItemArial.addActionListener(this);
    menuItemArial.setActionCommand("Arial");
    menuItemComicSansMS.addActionListener(this);
    menuItemComicSansMS.setActionCommand("Comic Sans MS");
    menuItemCourierNew.addActionListener(this);
    menuItemCourierNew.setActionCommand("Courier New");
    menuItemMSGothic.addActionListener(this);
    menuItemMSGothic.setActionCommand("MS Gothic");
    
    
    fontSize16.addActionListener(this);
    fontSize16.setActionCommand("16");
    fontSize20.addActionListener(this);
    fontSize20.setActionCommand("20");
    fontSize24.addActionListener(this);
    fontSize24.setActionCommand("24");
    fontSize28.addActionListener(this);
    fontSize28.setActionCommand("28");
    fontSize32.addActionListener(this);
    fontSize32.setActionCommand("32");
    fontSize36.addActionListener(this);
    fontSize36.setActionCommand("36");
    
    }
    
    public void createMenuColor(){
    menuItemSmoky = new JMenuItem("Дым");
    menuItemAntiqueWhite = new JMenuItem("Античный");
    menuItemBlackТоmato = new JMenuItem("Черный с Помидором");
    menuItemAquaMarine = new JMenuItem("Аквамарин");
    menuColor.add(menuItemSmoky);
    menuColor.add(menuItemAntiqueWhite);
    menuColor.add(menuItemBlackТоmato);
    menuColor.add(menuItemAquaMarine);
    
    menuItemSmoky.addActionListener(this);
    menuItemSmoky.setActionCommand("Smoky");
    
    menuItemAntiqueWhite.addActionListener(this);
    menuItemAntiqueWhite.setActionCommand("AntiqueWhite");
    
    menuItemBlackТоmato.addActionListener(this);
    menuItemBlackТоmato.setActionCommand("BlackТоmato");
    
    menuItemAquaMarine.addActionListener(this);
    menuItemAquaMarine.setActionCommand("AquaMarine");
    
    }
    
    
    // Создадим текстовое поле
    public void createTextArea(){
    textArea = new JTextArea(); // Текстовая область  
    textArea.setBackground(new Color(255,228,196));
    textArea.setCaretColor(Color.black);
    scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
    add(scrollPane);
    
    textArea.getDocument().addUndoableEditListener(new UndoableEditListener(){
        @Override
        public void undoableEditHappened(UndoableEditEvent uee) {
            undoManager.addEdit(uee.getEdit());
        }
    
    });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
     
         if (ae.getActionCommand().equals("New")) {
            functionsOfMenuFile.callItemNew();
         }
         else if (ae.getActionCommand().equals("Open")){
             try {
                 functionsOfMenuFile.callItemOpen();
             } catch (IOException ex) {
                  JOptionPane.showMessageDialog(null, "Ошибка ввода-вывода" + ex);
             }
         }
         
         else if (ae.getActionCommand().equals("Save As")){
         functionsOfMenuFile.callItemSaveAs();
         }
         
         else if (ae.getActionCommand().equals("Save")){
         functionsOfMenuFile.callItemSave();
         }
         
         else if (ae.getActionCommand().equals("Exit")){
         functionsOfMenuFile.callItemExit();
         }
        
          else if (ae.getActionCommand().equals("Arial")){
         functionsOfMenuFormat.choiceOfFont("Arial");
         }
         else if (ae.getActionCommand().equals("Comic Sans MS")){
         functionsOfMenuFormat.choiceOfFont("Comic Sans MS");
         }
         else if (ae.getActionCommand().equals("Courier New")){
         functionsOfMenuFormat.choiceOfFont("Courier New");
         }
         else if (ae.getActionCommand().equals("MS Gothic")){
         functionsOfMenuFormat.choiceOfFont("MS Gothic");
         }
         
         else if (ae.getActionCommand().equals("16")){
          functionsOfMenuFormat.createFont(16);
         }
         
         else if (ae.getActionCommand().equals("20")){
          functionsOfMenuFormat.createFont(20);
         }
         
         else if (ae.getActionCommand().equals("24")){
          functionsOfMenuFormat.createFont(24);
         }
         
         else if (ae.getActionCommand().equals("28")){
          functionsOfMenuFormat.createFont(28);
         } 
          else if (ae.getActionCommand().equals("32")){
          functionsOfMenuFormat.createFont(32);
         }
         
          else if (ae.getActionCommand().equals("36")){
          functionsOfMenuFormat.createFont(36);
         }
          
           else if (ae.getActionCommand().equals("Smoky")){
          functionsOfMenuColor.setColor("Smoky");
          }
          
          else if (ae.getActionCommand().equals("AntiqueWhite")){
          functionsOfMenuColor.setColor("AntiqueWhite");
          }
          
          else if (ae.getActionCommand().equals("BlackТоmato")){
          functionsOfMenuColor.setColor("BlackТоmato");
          }
          
          else if (ae.getActionCommand().equals("AquaMarine")){
          functionsOfMenuColor.setColor("AquaMarine");
          }
 
          else if (ae.getActionCommand().equals("Undo")){
           functionsOfMenuEdit.callItemUndo();
          }
          
         else if (ae.getActionCommand().equals("Redo")){
            functionsOfMenuEdit.callItemRedo();
          }
         
         else if (ae.getActionCommand().equals("TimeDate")){
            functionsOfMenuEdit.callItemTimeDate();
          }
 
      }
     
    
    
}
