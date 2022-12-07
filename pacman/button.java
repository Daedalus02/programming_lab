import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


public  class button extends JFrame implements ActionListener, MouseInputListener{
    public static final int SCREEN_WIDTH=600;
    public static final int SCREEN_HEIGHT=600;
    JButton button1;
    ImageIcon start;
    JButton button2=new JButton();
    JButton button3=new JButton();
    JLabel label3=new JLabel();
    JLabel label4=new JLabel();
    JLabel image=new JLabel();
    ImageIcon character=new ImageIcon("pacman.png");
    ImageIcon lx=new ImageIcon("left.png");
    ImageIcon dx=new ImageIcon("right.png");
    String[] names={"pacman","pepe","pepe"};
    String png=".png";
    int counter;

    button(){
        this.setVisible(true);
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setFocusable(false);
        this.setLayout(new BorderLayout(10,10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        


        button1=new JButton();
        button1.setFont(new Font("Monospaced",Font.ITALIC,40));
        button1.setText("START");
        button1.setVerticalTextPosition(button1.CENTER);
        button1.setHorizontalTextPosition(button1.CENTER);
        button1.setBounds(225, 25, 150, 75);
        button1.setPreferredSize(new Dimension(150,75));
        button1.setVisible(true);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setForeground(Color.white/*new Color(255,255,102)*/);
        button1.setBackground(Color.gray);
        //button1.setLayout(new FlowLayout(FlowLayout.CENTER));
        button1.setBorder(BorderFactory.createLineBorder(Color.darkGray/*new Color(0,0,70)*/, 5, false));

        
        button2=new JButton();
        button2.setFont(new Font("Monospaced",Font.ITALIC,40));
        button2.setVerticalTextPosition(button2.CENTER);
        button2.setHorizontalTextPosition(button2.CENTER);
        button2.setPreferredSize(new Dimension(75,150));
        button2.setVisible(true);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setForeground(Color.white/*new Color(255,255,102)*/);
        button2.setBackground(Color.lightGray);
        button2.setBorderPainted(false);
        button2.setIcon(lx);
        button2.addMouseListener(this);


        button3=new JButton();
        button3.setFont(new Font("Monospaced",Font.ITALIC,40));
        button3.setVerticalTextPosition(button3.CENTER);
        button3.setHorizontalTextPosition(button3.CENTER);
        button3.setPreferredSize(new Dimension(75,150));
        button3.setVisible(true);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setForeground(Color.white/*new Color(255,255,102)*/);
        button3.setBackground(Color.lightGray);
        button3.setBorderPainted(false);
        button3.setIcon(dx);
        button3.addMouseListener(this);

        image.setIcon(character);
        
        JPanel panel1=new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setVisible(true);
        panel1.add(button1);
        panel1.setPreferredSize(new Dimension(100,100));
        panel1.setBackground(Color.lightGray);
        this.add(panel1,BorderLayout.NORTH);

        JPanel panel2=new JPanel();
        panel2.setVisible(true);
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(100,100));
        panel2.setBackground(Color.lightGray);
        panel2.add(button2);
        this.add(panel2,BorderLayout.WEST);

      
        JPanel panel3=new JPanel();
        panel3.setVisible(true);
        panel3.setPreferredSize(new Dimension(100,100));
        panel3.setBackground(Color.lightGray);
        panel3.setLayout(new BorderLayout());
        panel3.add(button3);
        this.add(panel3,BorderLayout.EAST);

        JPanel panel4=new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.setVisible(true);
        panel4.setBackground(Color.lightGray);
        panel4.setPreferredSize(new Dimension(100,100));
        this.add(panel4,BorderLayout.SOUTH);
        
        JPanel panel5=new JPanel();
        panel5.setLayout(new FlowLayout());
        panel5.setVisible(true);
        panel5.add(image);
        panel5.setBackground(Color.lightGray);
        this.add(panel5,BorderLayout.CENTER);
        
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    if(counter!=0){
                        counter--;
                    }
                    break;
                    case KeyEvent.VK_RIGHT:
                    System.out.println("right");
                    if(counter<2){
                        counter++;
                    }
                    break;
        
                }
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        
        
        
        });
        //this.add(panel1,.SOUTH);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            new GameFrame(names[counter]);
            this.setVisible(false);
            this.dispose();
            //this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
        }
        
        character=new ImageIcon(names[counter]+png);
        image.setIcon(character);
        
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==button2){
            System.out.println("left");
            if(counter!=0){
                counter--;
            }
        }else if(e.getSource()==button3){
            System.out.println("right");
            if(counter<2){
                counter++;
            }
        }
        
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    
}
