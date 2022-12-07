import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;;

public class panelbackup extends JPanel implements KeyListener, ActionListener{
    public final static int SCREEN_WIDTH=600;
    public final static int SCREEN_HEIGHT=600;
    public final static int UNIT_SIZE=25;
    public final static int GAME_UNT=(SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    public final static String[] songs={"Intro","Chomp","Fruit","Ghost","CutScene","Extra","Death","waka1"};
    double time=System.currentTimeMillis()/1000;
    double currentTime=System.currentTimeMillis()/1000;
    double cherry;
    boolean first=true;
    boolean last=false;
    boolean checkp=true;
    boolean scare;
    int image=0;
    int DELAY=100;
    int lastIncrementX=0;
    int lastIncrementY=0;
    int lastAttemptX=0;
    int lastAttemptY=0;
    int ovalSize;
    int nGhost=0;
    int[] ghostTurn;
    double ghostTime=System.currentTimeMillis()/1000;
    double ghostCurrent=System.currentTimeMillis()/1000;
    int[] xg;
    int[] yg;
    int[][] randonpath;
    int[] counter;
    int[] size;
    boolean[] start;
    boolean[] turbo;
    int[] maxLimit;
    int incrementY=0;
    int incrementX=0;
    Timer timer;
    Random rand;
    JLabel label;
    JLabel cherrylab;
    JLabel[] ghostlab;
    ImageIcon px;
    ImageIcon cx;
    ImageIcon[] gx;
    Rectangle rect;
    Rectangle pac;
    JButton button;
    int score=0;
    Audio audio=new Audio();
    Audio eatAudio=new Audio();   
    Thread song=new Thread();
    songThread eat=new songThread(eatAudio,songs[7]);
    Thread eating=new Thread(eat);
    Thread ghost=new ghost();
    int[][] map={{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                 {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1},
                 {1,4,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,4,1},
                 {1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1},
                 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1},
                 {1,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1},
                 {1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1},
                 {1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1},
                 {1,1,1,1,1,0,1,0,1,1,1,3,3,1,1,1,0,1,0,1,1,1,1,1},
                 {0,0,0,0,0,0,0,0,1,2,2,2,2,2,2,1,0,0,0,0,0,0,0,0},
                 {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1},
                 {1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1},
                 {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1},
                 {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1},
                 {1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1},
                 {1,4,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,4,1},
                 {1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1},
                 {1,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1},
                 {1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1},
                 {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                 {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                 {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},};
    //Polygon pg;
    int x=1*UNIT_SIZE;
    int y=2*UNIT_SIZE;
    panelbackup(){
        playTrack(songs[0]);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        timer=new Timer(DELAY,this);
        rand=new Random();
        gx=new ImageIcon[4];
        gx[0]=new ImageIcon("ghost1.png");
        gx[1]=new ImageIcon("ghost2.png");
        gx[2]=new ImageIcon("ghost3.png");
        gx[3]=new ImageIcon("ghost4.png");
        ghostlab=new JLabel[4];
        xg=new int[4];
        yg=new int[4];
        randonpath=new int[4][20];
        counter=new int[4];
        ghostTurn=new int[4];
        size=new int[4];
        start=new boolean[4];
        maxLimit=new int[4];
        turbo=new boolean[4];
        for(int i=0;i<4;i++){
        ghostlab[i]=new JLabel();
        ghostlab[i].setIcon(gx[i]);
        ghostlab[i].setBounds(11*UNIT_SIZE,11*UNIT_SIZE,UNIT_SIZE,UNIT_SIZE);
        ghostlab[i].setVisible(false);
        start[i]=true;
        maxLimit[i]=6;
        xg[i]=11*UNIT_SIZE;
        yg[i]=11*UNIT_SIZE;
        this.add(ghostlab[i]);
        }
        newGhost();
        

        cx=new ImageIcon("cherry.png");
        cherrylab=new JLabel();
        cherrylab.setIcon(cx);
        cherrylab.setBounds(11*UNIT_SIZE,13*UNIT_SIZE,2*UNIT_SIZE,UNIT_SIZE+1);
        cherrylab.setVisible(true);
        newCherry();

        px=new ImageIcon("pcr.png");
        label=new JLabel();
        label.setIcon(px);
        label.setBounds(x, y, UNIT_SIZE, UNIT_SIZE);

        rect=new Rectangle(0,0,UNIT_SIZE,UNIT_SIZE);
        pac=new Rectangle(x,y,UNIT_SIZE,UNIT_SIZE);


        timer.start();
        this.addKeyListener(this);
        this.add(label);
        this.add(cherrylab);
    }
    public void playTrack(String name){
        if(!song.isAlive()){
        songThread st=new songThread(audio, name);
        song=new Thread(st);
        song.start();
        }
        
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.blue);
        Graphics2D g2=(Graphics2D) g;
        g2.setColor(Color.blue);
        g2.setFont(new Font("Monospaced",Font.BOLD,UNIT_SIZE));
        FontMetrics metrics=g2.getFontMetrics();
        g2.drawString("SCORE: "+score,(SCREEN_WIDTH-metrics.stringWidth("SCORE: "+score))/2, (UNIT_SIZE-metrics.getHeight())/2+UNIT_SIZE);
        for(int j=0;j<24;j++){
            for(int k=0;k<24;k++){
                switch(map[k][j]){
                    case 1:
                        g2.setColor(Color.blue);
                        g2.drawRect(j*UNIT_SIZE, k*UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
                        break;
                    case 0:
                        ovalSize=7;
                        g2.setColor(Color.lightGray);
                        g2.fillOval(j*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, k*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, ovalSize, ovalSize);
                        break;
                    case 3:
                        int height=5;
                        g2.setColor(Color.pink);
                        g2.fillRect(j*UNIT_SIZE,(k+1)*UNIT_SIZE-height,UNIT_SIZE,height);
                        break;
                    case 4: 
                        ovalSize=11;
                        g2.setColor(Color.orange);
                        g2.fillOval(j*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, k*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, ovalSize, ovalSize);
                        break;
                    case 5:
                        break;
                    case 2:
                        break;
                    default:
                        ovalSize=23;
                        g2.setColor(Color.black);
                        g2.fillRect(j*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, k*UNIT_SIZE+(UNIT_SIZE-ovalSize)/2, ovalSize, ovalSize);
                        break;

                }
               
                
            }
        }
        repaint();

    }
    public boolean checkCollision(int xi, int yi){
        
        pac.setLocation(x+xi,y+yi);
        for(int j=0;j<24;j++){
            for(int k=0;k<24;k++){
               
                if((map[k][j]==1 && !(x==0 && y==11*UNIT_SIZE) && !(x==23*UNIT_SIZE && y==11*UNIT_SIZE) || map[k][j]==3 )){
                    //System.out.println(x+" "+y);
                    rect.setLocation(j*UNIT_SIZE,k*UNIT_SIZE);
                    if(rect.intersects(pac)){
                        if(xi==UNIT_SIZE){
                            px=new ImageIcon("pcr.png");
                        }else if(xi==(-1)*UNIT_SIZE){
                            px=new ImageIcon("pcl.png");
                        }else if(yi==UNIT_SIZE){
                            px=new ImageIcon("pcd.png");
                        }else{
                            px=new ImageIcon("pcu.png");
                        }
                        label.setIcon(px);
                        label.setLocation(x, y);
                        return true;
                    }
                }
            }
                
            
        }
        if(map[y/25][x/25]==0){
            score++;
            eatingSound();
        }
        if(map[y/UNIT_SIZE][x/UNIT_SIZE]==4){
            score+=10;
            eatingSound();
        }
        if(map[y/UNIT_SIZE][x/UNIT_SIZE]==5){
            score+=100;
            map[13][11]=2;
            map[13][12]=2;
            cherrylab.setVisible(false);
            System.out.println("cherry");
            playTrack(songs[2]);
        }
        map[y/25][x/25]=2;
        return false;
    }
    public void eatingSound(){
        if(!eating.isAlive()){
            try{
                eating=new Thread(eat);
                eating.start();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                incrementX=(-1)*UNIT_SIZE;
                incrementY=0;
                lastAttemptX=incrementX;
                lastAttemptY=incrementY;
                break;
            case KeyEvent.VK_RIGHT: 
                incrementX=UNIT_SIZE;
                incrementY=0;
                lastAttemptX=incrementX;
                lastAttemptY=incrementY;
                break;
            case KeyEvent.VK_UP: 
                incrementY=(-1)*UNIT_SIZE;
                incrementX=0;
                lastAttemptX=incrementX;
                lastAttemptY=incrementY;
                break;
            case KeyEvent.VK_DOWN: 
                incrementY=UNIT_SIZE;
                incrementX=0;
                lastAttemptX=incrementX;
                lastAttemptY=incrementY;
                break;
        }
       

    }
    @Override
    public void keyReleased(KeyEvent e){
        //rect.con
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void move(){
        if(incrementX==0 && incrementY==UNIT_SIZE && y<=22*UNIT_SIZE && !checkCollision(0,UNIT_SIZE)){
            switch(image){
                case 0:
                px=new ImageIcon("cpc.png");
                break;
                case 1:
                px=new ImageIcon("pcd.png");
                break;
                case 2:
                px=new ImageIcon("spcd.png");
                break;
                case 3:
                px=new ImageIcon("pcd.png");
                break;
            }
            image=(image+1)%4;
            label.setIcon(px);
            label.setLocation(label.getX()+incrementX,label.getY()+incrementY);
            x=x+incrementX;
            y=y+incrementY;
            lastIncrementX=incrementX;
            lastIncrementY=incrementY;
        }
        if(incrementX==0 && incrementY==-UNIT_SIZE && y>=UNIT_SIZE && !checkCollision(0, (-1)*UNIT_SIZE)){
            switch(image){
                case 0:
                px=new ImageIcon("cpc.png");
                break;
                case 1:
                px=new ImageIcon("pcu.png");
                break;
                case 2:
                px=new ImageIcon("spcu.png");
                break;
                case 3:
                px=new ImageIcon("pcu.png");
                break;
            }
            image=(image+1)%4;
            label.setIcon(px);
            label.setLocation(label.getX()+incrementX,label.getY()+incrementY);
            x=x+incrementX;
            y=y+incrementY;
            lastIncrementX=incrementX;
            lastIncrementY=incrementY;
        }
        if(incrementX==UNIT_SIZE && incrementY==0 && x<=22*UNIT_SIZE && !checkCollision(UNIT_SIZE,0)){
            switch(image){
                case 0:
                px=new ImageIcon("cpc.png");
                break;
                case 1:
                px=new ImageIcon("pcr.png");
                break;
                case 2:
                px=new ImageIcon("spcr.png");
                break;
                case 3:
                px=new ImageIcon("pcr.png");
                break;
            }
            image=(image+1)%4;
            label.setIcon(px);
            if(x==22*UNIT_SIZE && y==11*UNIT_SIZE){
                x=0;
                label.setLocation(x,y);
            }else{
                label.setLocation(label.getX()+incrementX,label.getY()+incrementY);
                x=x+incrementX;
                y=y+incrementY;
            }
            
            lastIncrementX=incrementX;
            lastIncrementY=incrementY;
        }
        if(incrementX==(-1)*UNIT_SIZE && incrementY==0 && x>=UNIT_SIZE && !checkCollision((-1)*UNIT_SIZE,0)){
            switch(image){
                case 0:
                px=new ImageIcon("cpc.png");
                break;
                case 1:
                px=new ImageIcon("pcl.png");
                break;
                case 2:
                px=new ImageIcon("spcl.png");
                break;
                case 3:
                px=new ImageIcon("pcl.png");
                break;
            }
            image=(image+1)%4;
            label.setIcon(px);
            if(x==UNIT_SIZE && y==11*UNIT_SIZE){
                x=23*UNIT_SIZE;
                label.setLocation(x,y);
            }else{
                label.setLocation(label.getX()+incrementX,label.getY()+incrementY);
                x=x+incrementX;
                y=y+incrementY;
            }
            
            lastIncrementX=incrementX;
            lastIncrementY=incrementY;
        }
        if(!checkCollision(lastAttemptX, lastAttemptY)){
            incrementX=lastAttemptX;
            incrementY=lastAttemptY;
        }else{
            if(!checkCollision(lastIncrementX,lastIncrementY)){
                incrementX=lastIncrementX;
                incrementY=lastIncrementY;
            }
        }
        //System.out.println(x+" "+y);
        pac.setLocation(x, y);
    }
    public void checkPoint(){
        if(score==266 && checkp==true){
            playTrack(songs[5]);
            checkp=false;
        }
    }
   
    public void checkCherry(){
        if((currentTime-time)>cherry){
            time=currentTime;
            newCherry();
        }
        currentTime=System.currentTimeMillis()/1000;
    }
    public void newCherry(){
        map[13][11]=5;
        map[13][12]=5;
        cherrylab.setVisible(true);
        cherry=rand.nextInt(15)+15;
        System.out.println(cherry);
    }

    public void checkGhost(){
        if((ghostCurrent-ghostTime)>15){
            ghostTime=ghostCurrent;
            newGhost();
        }
        ghostCurrent=System.currentTimeMillis()/1000;
    }

    public void newGhost(){
        ghostlab[nGhost].setVisible(true);
        nGhost++;
    }

    public void normalMove(int n){
        maxLimit[n]=12;
        turbo[n]=true;
        int[] street=new int[20];
        ghost=new ghost();
        counter[n]=0;
        size[n]=0;

        street=((ghost) ghost).ghostRoad(xg[n]/UNIT_SIZE,yg[n]/UNIT_SIZE,new boolean[4],this.x/UNIT_SIZE,this.y/UNIT_SIZE,0,0);
        //System.out.println(this.x/ UNIT_SIZE+" "+this.y/UNIT_SIZE);
        //System.out.print("     "+xg[n]/UNIT_SIZE+" "+ yg[n]/UNIT_SIZE);
        //System.out.println();
        moveGhost(n,street[0]);
    }
    public  void randomMove(int n){
        int randy=UNIT_SIZE;
        int randx=UNIT_SIZE;
        maxLimit[n]=6;
        turbo[n]=false;
        ghost=new ghost();
        if( counter[n]==size[n]){
            start[n]=true;
        }
        while(start[n] && map[randy/UNIT_SIZE][randx/UNIT_SIZE]!=0){
            randx=rand.nextInt(23)*UNIT_SIZE;
            randy=rand.nextInt(23)*UNIT_SIZE;
            //System.out.println("hi");
        }
        if(start[n]){
            randonpath[n]=((ghost) ghost).ghostRoad(xg[n]/UNIT_SIZE,yg[n]/UNIT_SIZE,new boolean[4],randx/UNIT_SIZE,randy/UNIT_SIZE,0,0);
            /*for(int i=0;i<20;i++){
                System.out.println(randonpath[n][i]);
            }*/
            counter[n]=0;
            size[n]=0;
            //System.out.println("x: "+xg[n]/UNIT_SIZE+" y: "+yg[n]/UNIT_SIZE+" xp: "+x/UNIT_SIZE+" y: "+y/UNIT_SIZE);
            for(int i=0;i<20 && randonpath[n][i]!=0; i++){
                //System.out.print(randonpath[n][i]+" ");
                size[n]++;
            }
            // System.out.println();
            start[n]=false;
            //System.out.println("size: "+size[n]);
        }
        moveGhost(n,randonpath[n][counter[n]]);
        counter[n]++;
        
    }
    public void moveGhost(int n,int move){
        switch(move){
            case 1:
                if(xg[n]==23*UNIT_SIZE && yg[n]==11*UNIT_SIZE){
                    xg[n]=0*UNIT_SIZE;
                }else{
                    xg[n]+=UNIT_SIZE;
                }

                ghostlab[n].setLocation(xg[n], yg[n]);
                //System.out.println("R");
                break;
            case 2:
                yg[n]-=UNIT_SIZE;
                ghostlab[n].setLocation(xg[n], yg[n]);
                //System.out.println("U");
                break;
            case 3:
                if(xg[n]==0*UNIT_SIZE && yg[n]==11*UNIT_SIZE){
                    xg[n]=23*UNIT_SIZE;
                }else{
                    xg[n]-=UNIT_SIZE;
                }
                ghostlab[n].setLocation(xg[n], yg[n]);
                //System.out.println("L");
                break;
            case 4:
                yg[n]+=UNIT_SIZE;
                ghostlab[n].setLocation(xg[n], yg[n]);
                //System.out.println("D");
                break;
        }

    }

    public void actionPerformed(ActionEvent e) {
     move();
     checkPoint();
     checkCherry();
     for(int i=0;i<4;i++){
        if(ghostlab[i].isVisible() && (ghostTurn[i]==1 ) ){
            if(((Math.abs(xg[i]/UNIT_SIZE-x/UNIT_SIZE)<maxLimit[i]) && (Math.abs(yg[i]/UNIT_SIZE-y/UNIT_SIZE)<maxLimit[i]))){
                normalMove(i);
            }else{
                randomMove(i);

            }
            
            //System.out.println(maxLimit[i]);

        }
        if(ghostlab[i].isVisible() && turbo[i] && (ghostTurn[i]==2)){
            //System.out.println("turbo");
            if(((Math.abs(xg[i]/UNIT_SIZE-x/UNIT_SIZE)<maxLimit[i]) && (Math.abs(yg[i]/UNIT_SIZE-y/UNIT_SIZE)<maxLimit[i]))){
                normalMove(i);
            }else{
                randomMove(i);
            }
        }
        

            ghostTurn[i]=(ghostTurn[i]+1)%3;
    }
    if(nGhost<4){
        checkGhost();
    }
    }
    
    
}
