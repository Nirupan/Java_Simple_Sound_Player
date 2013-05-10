/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsoundplayer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class BasicSoundPlayer extends JApplet implements ActionListener{
	
	private JLabel label;
	private File file;
	private AudioInputStream ai;
	private Clip c;
	private JComboBox playlist ;
	private JButton play, loop, stop,next,prev;
	private URL u;
        private  URL u1[]= new URL [100];
        private int cnt;
        private int lcnt;
        private int playarray [] = new int [100];
	public void init(){
		setVisible(true);
		setSize(300,300);
		setLayout(null);
                setBackground(Color.RED);
    
		
		label = new JLabel("Select  File");
		label.setSize(100,25);
		label.setLocation(100,30);
                label.setBackground(Color.BLACK);
		add(label);
		cnt=0;
                lcnt=0;
		playlist = new JComboBox();
		playlist.addItem("SOUND1.wav");
		playlist.addItem("SOUND2.wav");
		playlist.addItem("SOUND3.wav");
		playlist.addItem("SOUND4.wav");
		playlist.setSize(100,25);
		playlist.setLocation(200,30);
                playlist.setBackground(Color.BLACK);
                playlist.setForeground(Color.WHITE);
		add(playlist);
		
		play = new JButton("PLAY");
		play.setSize(100,25);
		play.setLocation(50,60);
		loop = new JButton("LOOP");
		loop.setSize(100,25);
		loop.setLocation(150,60);
		stop = new JButton("STOP");
		stop.setSize(100,25);
		stop.setLocation(250,60);
                next = new JButton("NEXT");
		next.setSize(100,25);
		next.setLocation(350,60);
                prev = new JButton("PREV");
		prev.setSize(100,25);
		prev.setLocation(450,60);
                play.setBackground(Color.BLACK);
                play.setForeground(Color.WHITE);
                loop.setBackground(Color.BLACK);
                loop.setForeground(Color.WHITE);
                stop.setBackground(Color.BLACK);
                stop.setForeground(Color.WHITE);
		next.setBackground(Color.BLACK);
                next.setForeground(Color.WHITE);
                prev.setBackground(Color.BLACK);
                prev.setForeground(Color.WHITE);
                add(play);
		add(loop);
		add(stop);
                add(next);
                add(prev);
		play.addActionListener(this);
		loop.addActionListener(this);
		stop.addActionListener(this);
		next.addActionListener(this);
		prev.addActionListener(this);
		
		try {
			c =  AudioSystem.getClip();
		} catch (LineUnavailableException e) {
		
			e.printStackTrace();
		}
		this.setContentPane(this.getContentPane());
		validate();
	
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource()==play){
			selectFile();
			
			try {
				        
                                        play.setBackground(Color.WHITE);
                                        play.setForeground(Color.BLACK);
                                        
                                        loop.setBackground(Color.BLACK);
                                        loop.setForeground(Color.WHITE);
                                        stop.setBackground(Color.BLACK);
                                        stop.setForeground(Color.WHITE);
                                        next.setBackground(Color.BLACK);
                                        next.setForeground(Color.WHITE);
                                        prev.setBackground(Color.BLACK);
                                        prev.setForeground(Color.WHITE);
				 
					c.close();
					c =  AudioSystem.getClip();
					c.open(ai);
					c.start();
                                        
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource()==loop){
			selectFile();
			
			try {
				 
					play.setBackground(Color.BLACK);
                                        play.setForeground(Color.WHITE);
                                        
                                        loop.setBackground(Color.WHITE);
                                        loop.setForeground(Color.BLACK);
                                        
                                        stop.setBackground(Color.BLACK);
                                        stop.setForeground(Color.WHITE);
                                        next.setBackground(Color.BLACK);
                                        next.setForeground(Color.WHITE);
                                        prev.setBackground(Color.BLACK);
                                        prev.setForeground(Color.WHITE);
				 
                                        c.close();
				 	c =  AudioSystem.getClip();
					c.open(ai);
					c.loop(Clip.LOOP_CONTINUOUSLY);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource()==stop){
                    
                    
			                play.setBackground(Color.BLACK);
                                        play.setForeground(Color.WHITE);
                                        
                                        loop.setBackground(Color.BLACK);
                                        loop.setForeground(Color.WHITE);
                                        
                                        stop.setBackground(Color.WHITE);
                                        stop.setForeground(Color.BLACK);
                                        
                                        next.setBackground(Color.BLACK);
                                        next.setForeground(Color.WHITE);
                                        prev.setBackground(Color.BLACK);
                                        prev.setForeground(Color.WHITE);
				 
                        c.stop();
			c.close();
		}
                
                if(ae.getSource()==next){
                    
                                        play.setBackground(Color.BLACK);
                                        play.setForeground(Color.WHITE);
                                        
                                        loop.setBackground(Color.BLACK);
                                        loop.setForeground(Color.WHITE);
                                        stop.setBackground(Color.BLACK);
                                        stop.setForeground(Color.WHITE);
                                        
                                        next.setBackground(Color.WHITE);
                                        next.setForeground(Color.BLACK);
                                        
                                        prev.setBackground(Color.BLACK);
                                        prev.setForeground(Color.WHITE);
				 
			selectNextFile();
			
			try {
				 
					c.close();
					c =  AudioSystem.getClip();
					c.open(ai);
					c.start();
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
                if(ae.getSource()==prev){
			selectPrevFile();
                        
                                        play.setBackground(Color.BLACK);
                                        play.setForeground(Color.WHITE);
                                        
                                        loop.setBackground(Color.BLACK);
                                        loop.setForeground(Color.WHITE);
                                        stop.setBackground(Color.BLACK);
                                        stop.setForeground(Color.WHITE);
                                        next.setBackground(Color.BLACK);
                                        next.setForeground(Color.WHITE);
                                        
                                        prev.setBackground(Color.WHITE);
                                        prev.setForeground(Color.BLACK);
				 
			
			try {
				 
					c.close();
					c =  AudioSystem.getClip();
					c.open(ai);
					c.start();
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void selectFile(){
		try {
			u = new URL(getCodeBase()+""+playlist.getSelectedItem());
			if(cnt<=3)
                        {
                        playarray[cnt]=playlist.getSelectedIndex();
                        cnt++;
                        }
                        ai = AudioSystem.getAudioInputStream(u);
                        int i;
                        for (i=0;i<cnt;i++)
                        {
                            System.out.println(playarray[i]);
                        }
                        
                  	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
        public void selectNextFile(){
            try{
                
                 int i=0;
                 int in;
                  u = new URL(getCodeBase()+""+playlist.getSelectedItem());
                  in=playlist.getSelectedIndex();
                  System.out.println(in);
                  
                      
                          if(in==0)
                          {
                              in=1;
                          }
                          else if(in==1)
                          {
                              in=2;
                          }
                          else if(in==2)
                          {
                              in=3; 
                          }    
                          else if(in==3)
                          {
                              in=0;
                          }
                          
                       
                          //in=in+1; 
                          //System.out.println("The second in is");
                          //System.out.println(in);
                          playlist.setSelectedIndex(in);
                          u = new URL(getCodeBase()+""+playlist.getSelectedIndex());    
                      
                 ai = AudioSystem.getAudioInputStream(u);
                 
            }catch(Exception nfe){
                nfe.printStackTrace();
            }
            
        }

public void selectPrevFile(){
            try{
                
                 int i=0;
                 int in;
                  u = new URL(getCodeBase()+""+playlist.getSelectedItem());
                  in=playlist.getSelectedIndex();
                  System.out.println(in);
                  
                      
                          if(in==0)
                          {
                              in=3;
                          }
                          else if(in==1)
                          {
                              in=0;
                          }
                          else if(in==2)
                          {
                              in=1; 
                          }    
                          else if(in==3)
                          {
                              in=2;
                          }
                          
                       
                          //in=in+1; 
                          //System.out.println("The second in is");
                          //System.out.println(in);
                          playlist.setSelectedIndex(in);
                          u = new URL(getCodeBase()+""+playlist.getSelectedIndex());    
                      
                 ai = AudioSystem.getAudioInputStream(u);
                 
            }catch(Exception nfe){
                nfe.printStackTrace();
            }
            
        }

   

}
