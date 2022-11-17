/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ajusa
 */
public class View extends JFrame implements ActionListener {
    
    JButton compressButton;
    JButton decompressButton;
    
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,200);
        
        compressButton = new JButton("Compress a File");
        compressButton.addActionListener(this);
        compressButton.setBounds(30, 100, 170, 30);
        
        decompressButton = new JButton("Decompress a File");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(220, 100, 180, 30);
        
        this.add(compressButton);
        this.add(decompressButton);
        
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(450, 250);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Compress.method(file);
                } catch(Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                } 
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Decompress.method(file);
                } catch(Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                } 
            }
        }
        
    }
    
    public static void main(String[] args){
        View view = new View();
        view.setVisible(true);
    }
    
}
