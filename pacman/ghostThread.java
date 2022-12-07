public class ghostThread implements Runnable{
    public int x;
    public int y;
    boolean[] tmp=new boolean[4];
    public int xp;
    public int yp;

    public ghostThread(int x, int y, int xp, int yp){
        this.x=x;
        this.y=y;
        this.xp=xp;
        this.yp=yp;
    }
    
    public void run(){
        ghost ghost=new ghost();
        ghost.ghostRoad(x, y, tmp, xp, yp, 0, 0);
    }
}
