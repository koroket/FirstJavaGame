/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Mike
 */
public class JavaGame extends JFrame implements Runnable
{
    String lifepoints = "400";
    int x, y, w,z,life,ran,r,t;
    int a = 10;
    int speed;
    int points = 0;
    int q = 0;
    int grav = 0;
    int p = 0;
    int xDirection, yDirection,wdir,zdir;
    int xCord, yCord;
    private Image dbImage;
    private Graphics dbg;
    private Image dbImage2;
    private Graphics dbg2;
    Image pikachu, soccerball,hearty,pikachu2;
    Font font = new Font("Arial",Font.BOLD,55);
     Font font2 = new Font("Arial",Font.BOLD,90);
     Font font3 = new Font("Arial",Font.BOLD,20);
    int i=0;
    
    @Override
    public void run(){
    try{
        life = Integer.parseInt(JOptionPane.showInputDialog(null,"LIFEPOINTS","ENTER THE AMOUNT OF LIFE POINTS",JOptionPane.INFORMATION_MESSAGE));
        if (life>10000){life=10000;}
    while(true){
       for(int n = 0; n<10;n++){ for(int j=0;j<10;j++){
           while(p==1){
           Thread.sleep(2);};
           move();
           if(life>0){points++;}
        movefireball();
        heal();
        Thread.sleep(8);}
        movespace();
       
        lifepointdeduction();
       }
       setfire();
       if(a%2==0){
       r=((int)((Math.random()*700)))+150;
       t=((int)((Math.random()*300)))+150;}
       a++;
    }
    
    }
    catch(Exception e){
        System.out.print("error");
    }
    }
    public void lifepointdeduction(){
    if(w-x>0 && w-x<240 && z-y>0 && z-y<240){life-=100;}
    
    }
    public void setfire(){    ran=(int)(Math.random()*4);}
    public void movefireball(){
       
        if (ran==0){
        setWDirection(2);
        }
         if (ran==1){
        setWDirection(-2);
        }
          if (ran==2){
        setZDirection(2);
        }
           if (ran==3){
        setZDirection(-2);
        }
      
 
    w+=wdir;
    z+=zdir;
          if (z<=30)
                {
                z=30;
                setZDirection(10);
                }
                    
                            if (w<= 0)
                {
                w=0;
                setWDirection(10);
                }
        
                              if (w>= 950)
                {
                w=950;
                setWDirection(-10);
                }
                      
                              if (z>= 600)
                {
                z=600;
                setZDirection(-10);
                }
    }
    public void heal (){
     if(r-x>-50 && r-x<300 && t-y>-50 && t-y<300){life+=1;}
    }
    public void movespace(){
     if (yDirection<340 && grav==1){
               setYDirection(1);
                }
     i++;
     if(yDirection>349){
     setYDirection(0);
     }
             
    }
            public void move(){
               
                
            x+=xDirection;
            y+=yDirection;
           
                            if (y<=100)
                {
                y=100;
                }
                    
                            if (x<= 0)
                {
                x=0;
                }
        
                              if (x>= 840)
                {
                x=840;
                
                }
                      
                              if (y>= 350)
                {
                y=350;
                }
                
        }
        
        public void setXDirection(int xDir){
        xDirection = xDir;
        }
        
             public void setYDirection(int yDir){
        yDirection = yDir;
        }
     
                     public void setWDirection(int wDir){
        wdir = wDir;
        }
        
             public void setZDirection(int zDir){
        zdir = zDir;
        }
             public void setPause(int pp){p=pp;}
        
    public class AL extends KeyAdapter {
        

        public void keyPressed(KeyEvent e) {
            
            int keyCode = e.getKeyCode();
    
            if(keyCode == e.VK_LEFT)
            {
                
                setXDirection(-5);
             
            }
            
            if(keyCode == e.VK_RIGHT)
            {
            setXDirection(5);
                
             
            }
            
            if(keyCode == e.VK_UP)
            {

                 setYDirection(-5);
             
            }
                        
            if(keyCode == e.VK_DOWN)
            {
              setYDirection(5);
            }
            
                   
                      if (keyCode == e.VK_SPACE){
          setYDirection(-10);}
                      
                      if(keyCode == e.VK_P)
            {
                p=1;
                q=0;
                
            
            }
                      if(keyCode == e.VK_U)
                      {
                      q=1;
                      p=0;
                      }
                      if (keyCode==e.VK_G){
                          if (grav==0){grav++;}
                          else {grav--;}
                      }
                      
                      
            if(keyCode == e.VK_O){life+=100;}
        }
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == e.VK_LEFT)
            {
                
                setXDirection(0);
             
            }
            
            if(keyCode == e.VK_RIGHT)
            {
            setXDirection(0);
                
             
            }
            
            if(keyCode == e.VK_UP)
            {

                 setYDirection(0);
             
            }
                        
            if(keyCode == e.VK_DOWN)
            {
              setYDirection(0);
            }

            
            
         
          
        }
        
      
    }
    
    public class Mouse extends MouseAdapter 
    {
    public void mousePressed (MouseEvent e){
        xCord = e.getX();
        yCord = e.getY();
     
    }
    
    public void mousReleased (MouseEvent e){
    
    }
    }
    
    
    
    public JavaGame(){
        ImageIcon i = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/pikachu2.gif");
        ImageIcon hurt = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/pikachu3.gif");
        ImageIcon ball = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/pokeball.gif");
               ImageIcon heart = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/heart.gif");
    pikachu2=hurt.getImage();
               hearty= heart.getImage();
               pikachu = i.getImage();
    soccerball = ball.getImage();
        addKeyListener (new AL());
    addMouseListener (new Mouse());
    setTitle ("Java Game");
    setSize (1000,630);
    setResizable(false);
    setVisible(true);
    setBackground(Color.GREEN);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    x=600;
            y=600;
            xCord=400;
            yCord = 400;
            w=(int)(Math.random()*100);
            z=(int)(Math.random()*100);
            life=1000;
            r=0;
            t=0;
            
    }
    
    public void pause (){
    if(p==1){
    while(p==1)
        {
       
        
    }
        }
    }
    
        public void paint (Graphics g){
    dbImage = createImage(getWidth(), getHeight());
    dbg = dbImage.getGraphics();
    paintComponent(dbg);
   
    g.drawImage(dbImage, 0 , 0, this);
   
}
    
        public void paintComponent(Graphics g){
        //g.setColor(Color.yellow);
        //g.drawOval(x,y,20,20);
        //g.setColor(Color.black);
        //g.fillOval(xCord, yCord, 20,20);
        g.setColor(Color.BLACK);
        g.setFont(font);
         g.drawString("lifepoints " + life, 50, 90);
         g.fillRect(0, 100, 1000, 10);
         g.setFont(font3);
         g.drawString("HIT P TO PAUSE", 600, 90);
            if  (grav==1){g.drawString("GRAVITY ON", 600, 500);}
         g.drawString("POINTS:" + points, 800, 90);
        
           if (w-x>0 && w-x<240 && z-y>0 && z-y<240){g.drawImage(pikachu2, x, y, this);}
           else{g.drawImage(pikachu, x, y, this);}
                  g.setColor(Color.PINK);
              g.drawImage(hearty, r, t,this);
        
         
         g.drawImage(soccerball, w, z,this);
         repaint();
         if(life<1){
             g.setColor(Color.black);
             g.fillRect(0, 0, 1100, 800);
         g.setColor(Color.red);
         g.setFont(font2);
           
         g.drawString("GAME OVER...", 200, 200);
                  g.drawString("POINTS:"+points, 200, 400);
         }
         if(p==1){
             g.setColor(Color.DARK_GRAY);
             g.fillRect(0, 0, 1100, 800);
         g.setColor(Color.WHITE);
         g.setFont(font);
           
         g.drawString("PRESS U to UNPAUSE", 200, 200);
         }

        }
        
          
        
        public static void main (String[] args){
        //new JavaGame();
            JavaGame jg = new JavaGame();
            Thread t1 = new Thread(jg);
            t1.start();
        }
        
}
