/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.musicplayer;

/**
 *
 * @author rcaraos
 */

import javax.swing.*;
import java.awt.*;
public class MusicPlayer extends JFrame {
    public static final Color BACKGROUND = new Color(48,25,52);
    public static final Color FOREGROUND = new Color(211,194,207);
    public MusicPlayer(){
    setTitle("Music Player");
    setIconImage(getImageIcon("C:\\Users\\rcaraos\\Downloads\\basic ass logo maximal version 1.png").getImage());
    setSize(500,550);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(250,400));
    setResizable(false);
    setLocationRelativeTo(null);
    
    JPanel root = new JPanel(new BorderLayout());
    root.setBackground(BACKGROUND);
    
    setContentPane(root);
    
    JPanel header = createPanel(new Dimension (0,70), FOREGROUND);
    JPanel player = createPanel(new Dimension (0,260), BACKGROUND);
    JPanel footer = createPanel(new Dimension (0,70), BACKGROUND);
    root.add(header,BorderLayout.NORTH);
    root.add(player,BorderLayout.CENTER);
    root.add(footer,BorderLayout.SOUTH);
    
    setHeaderUp(header);
    setPlayerUp(player);
    setFooterUp(footer);
    
}
    
    public static JButton createButton(String fileName){
        JButton button = new JButton();
        ImageIcon icon = findImage("C:\\Users\\rcaraos\\Downloads\\" + fileName);
        Image altered = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(altered));
        button.setSize(new Dimension(60,60));
        
        button.addActionListener(e->{
            System.out.println("clicked");
            changeIcon(button);
    });
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFocusable(false);
        return button;
    }
    
    public static void changeIcon(JButton button){
        ImageIcon icon = findImage("C:\\Users\\rcaraos\\Downloads\\pause.png");
        Image altered = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(altered));
    }
    public static void setPlayerUp(JPanel panel){
        panel.setLayout(new BoxLayout (panel,BoxLayout.Y_AXIS));
        ImageIcon original = findImage("C:\\Users\\rcaraos\\Downloads\\album_cover.jpg");
        Image altered = original.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        
        JLabel songPic = new JLabel();
        songPic.setIcon(new ImageIcon(altered));
        songPic.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel control = createPanel(new Dimension(0,40),BACKGROUND);

        JButton prev = createButton("prev.png");
        JButton play = createButton("play.png");
        JButton next = createButton("next.png");
        
        control.add(prev);
        control.add(play);
        control.add(next);
        
        panel.add(songPic);
        panel.add(control);
        
    }
    public static void setHeaderUp(JPanel panel) {
    JLabel song = new JLabel("Now Playing:");
    song.setForeground(BACKGROUND);
    song.setFont(new Font("SansSerif", Font.BOLD,30));
    song.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel label = new JLabel("Now Playing:");
    label.setForeground(BACKGROUND);
    label.setFont(new Font("Times new Roman", Font.PLAIN,20));
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    panel.setBorder(BorderFactory.createBevelBorder(WIDTH));
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    panel.add(song);
    panel.add(label);
    }
    
    
    public static ImageIcon findImage(String path){
        return new ImageIcon(path);
    }
    public static void setFooterUp(JPanel panel){
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        panel.setBackground(FOREGROUND);
    }
    public static JPanel createPanel(Dimension dim, Color col){
        JPanel panel = new JPanel();
        panel.setPreferredSize(dim);
        panel.setBackground(col);
        return panel;
    }
    
    public static ImageIcon getImageIcon(String path){
        ImageIcon image = new ImageIcon(path);
        return image;
                
    }
    public static void main(String[] args) {
       SwingUtilities.invokeLater(()-> {
           MusicPlayer frame = new MusicPlayer();
           frame.setVisible(true);
          
       });
    }

    
    
}
