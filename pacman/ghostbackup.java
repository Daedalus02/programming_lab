import java.util.Scanner;

public class ghostbackup extends Thread{

    static int[][] map={{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1},
                        {1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1},
                        {1,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1},
                        {1,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1},
                        {1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1},
                        {1,1,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,1,0,1,1,1,1,1},
                        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                        {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1},
                        {1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1},
                        {1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1},
                        {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
                        {1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1},
                        {1,0,0,0,0,0,1,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},};
    static int scounter=0;
    static int[][] wpos=new int[20][20];
    static int superLine=0;
    static int[][] posx=new int[20][20];
    static int[][] posy=new int[20][20];
    static int[][]pos=new int[20][20];
    static int[] badsol=new int[20];
    static boolean won=false;
    static int winLine=0;
    /*static int[][] map={{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},};*/
    //TEST THE POSSIBLE SOLUTION FOR GHOST
    public static int[] solutionTest(int[][] pos){
        int[] optimal=new int[20];
        return optimal;
    }

   

    //RETURN THE NUMBER OF OCCUOIED CELLS IN THE ARRAY
    public static int check(int[] arr){
        int size=0;
        for(int i=0;i<20;i++){
            if(arr[i]==0){
            return size;
            }
            size++;
        }
        return size;
    }

    //CORRECT THE POSSIBILITIES OF THE GHOST IN A SPECIEFIED POSITION
    public static boolean[] checkNext(int x,int y,boolean[] last){
            boolean[] possible=new boolean[4];
            
            if(x<23 && map[y][x+1]!=1 && last[2]!=true){
                possible[0]=true;
            }
            if(y>0 && map[y-1][x]!=1 && last[3]!=true){
                possible[1]=true;
            }
            if(x>0 && map[y][x-1]!=1 && last[0]!=true){
                possible[2]=true;
            }
            if(y<23 && map[y+1][x]!=1 && last[1]!=true){
                possible[3]=true;
            }
            if(y==11 && x==23){
                possible[0]=true;
            }
            if(y==11 && x==0){
                possible[2]=true;
            }
            if(y==11 && (x==11 || x==10 )){
                possible[2]=false;
            }
            if(y==11 && (x==12 || x==13)){
                possible[0]=false;
            }
            return possible;
    }    

    //ALLOW THE GHOST NOT TO CROSS A POINT OF THE MAP ALREADY CROSSED 
    public static void hansel(int line, int lineCounter,int x,int y){
        posy[line][lineCounter]=y;
        posx[line][lineCounter]=x;
        for(int i=0;i<lineCounter;i++){
                if(posx[line][i]==posx[line][lineCounter] && posy[line][i]==posy[line][lineCounter]){
                    //System.out.println(posx[line][i]+" "+posx[line][lineCounter]+" "+posy[line][i]+" "+posy[line][lineCounter]);
                    pos[line][19]=5;
                    
                }
            }
    }

 
    public static void rebuild(int line,int lineCounter){
       
        for(int i=0;i<lineCounter;i++){
            posx[line][i]=posx[line-1][i];
            posy[line][i]=posy[line-1][i];
            pos[line][i]=pos[line-1][i];
        }
    }
    public static void win(int line,int lineCounter){
        //SETTING INCREMENT
        //System.out.println(check(pos[line]));
        if(winLine<20){
           //System.out.println("win case: ");

        for(int i=0;i<=lineCounter ;i++){
            wpos[winLine][i]=pos[line][i];
            //System.out.print(wpos[winLine][i]+" ");
        }
        //System.out.println();
      
        //RETURN
        winLine++;
        won=true;
    }
     
    }

    //RETURN THE BEST POSSIBLE SOLUTION FOR THE GHOST 
    public static int[] pathToPac(int x,int y,boolean[] last,int xp, int yp,int line,int lineCounter){
        
        //System.out.println("x: "+x+" y: "+y);

        //VARIABLE DECLARATION
        boolean[] next=new boolean[4];
        boolean[] tmp=new boolean[4];
        boolean[] won=new boolean[4];
        boolean direction=false;
        boolean poswon=false;
        int[] posup=new int[20];
        int[] posdown=new int[20];
        int[] posleft=new int[20];
        int[] posright=new int[20];
        int counter=0;
        int better=1;
        int[] size=new int[4];
        int bestsize=20;
        int tmpX=0;
        

        //CHECK POSSIBLE MOVES
        next=checkNext(x,y,last);
     
    

            //CASES EXAMINATION
            for(int i=0;i<4;i++){

                if(next[i]){
               
                    switch(i){
                        case 0: 
                        //System.out.println("R");
                        //there's a possible direction
                        direction=true;
                        //the next position in this line in right (1)
                        pos[line][lineCounter]=1;

                        //CHECK IF ON THE TELEPORT PLACE
                        if(!(x==23 && y==11)){
                            //move ghost position to right
                            x++;
                        }else{
                            tmpX=x;
                            x=0;
                        }
                            //check if the ghost didn't cross its own road
                            hansel(line,lineCounter,x,y);
                            //CHECK IF THE GHOST GOT TO THE PACMAN POSITION
                            //System.out.println("x: "+x+" y: "+y+"xp: "+xp+" yp: "+yp);
                            if(x==xp && y==yp){
                                 //IF GHOST GOT TO PACMAN POSITION 
                                 //System.out.println("win");
                                //fill the winning position in the winning matrix
                                win(line,lineCounter);
                                //setting the won array int the i-positon to true to track which of the four moves won
                                won[i]=true;
                                //setting the poswon array to true indicating that in this iteration of the method the ghost got to pacman position
                                poswon=true;
                                  
                            }else{
                               //IF IT DIDN'T GET TO THE PACMAN POSITION:

                                //increment the position in the line we're considering
                                lineCounter++;
                                // CONSIDERING THE CASE LINECOUNTER EXCEEDED THE MAX LIMIT
                                if(lineCounter>19){
                                    lineCounter--;
                                    break;
                                }
                                // setting the last movement 
                                tmp[i]=true;
                                //call the method again to try getting to pacman with other moves
                                posright=pathToPac(x,y,tmp,xp,yp,line,lineCounter);
                                //decrease the position to let other moves be done correctly
                                lineCounter--;
                                // setting back the last movement to false
                                tmp[i]=false;
                            }

                            //CHECK IF IN THE TELEPORT PLACE
                            if(!(tmpX==23 && y==11)){
                                //decrementing back to the starting value of x to allow other line to operate correctly
                                x--;
                            }else{
                                x=tmpX;
                            }
                            //saving the size of the line 
                            size[i]=check(pos[line]);
                            //incrementing counter to indicate the the line has already been used
                            counter++;
                            break;
                        case 1:
                            //System.out.println("U");
                            direction=true;
                            //considering the case this is not the first attempt in the current position
                            if(counter>0){
                                //increment line so that we pass to the next line
                                line++; 
                                //IF LINE > 19 WE MAKE ENOUGH CONSIDERATION
                                if(line>19){
                                    line--;
                                    break;
                                }
                                //copying back all of the previous moves done in this position
                                rebuild(line,lineCounter);
                            }
                            pos[line][lineCounter]=2;
                            y--;
                            hansel(line,lineCounter,x,y);
                            //System.out.println("x: "+x+" y: "+y+"xp: "+xp+" yp: "+yp);
                            if(x==xp && y==yp){
                                //System.out.println("win");
                                win(line,lineCounter);
                                won[i]=true;
                                poswon=true;
                               
                            }else{
                                lineCounter++;
                                if(lineCounter>19){
                                    lineCounter--;
                                    break;
                                }
                                tmp[i]=true;
                                posup=pathToPac(x,y,tmp,xp,yp,line,lineCounter);
                                lineCounter--;
                                tmp[i]=false;
                            }
                            size[i]=check(pos[line]);
                            y++;
                            counter++;
                            break;
                        case 2:
                       
                            //System.out.println("L");
                            direction=true;
                            if(counter>0){
                                line++;
                                if(line>19){
                                    line--;
                                    break;
                                }
                                rebuild(line,lineCounter);
                            }
                            pos[line][lineCounter]=3;
                            if(!(x==0 && y==11)){
                                x--;
                            }else{
                                tmpX=x;
                                x=23;
                            }
                            
                            hansel(line,lineCounter,x,y);
                            //System.out.println("x: "+x+" y: "+y+"xp: "+xp+" yp: "+yp);
                            if(x==xp && y==yp){
                                //System.out.println("win");
                                win(line,lineCounter);
                                won[i]=true;
                                poswon=true;
                                
                            }else{
                                lineCounter++;
                                if(lineCounter>19){
                                    lineCounter--;
                                    break;
                                }
                                tmp[i]=true;
                                posleft=pathToPac(x,y,tmp,xp,yp,line,lineCounter);
                                lineCounter--;
                                tmp[i]=false;
                            }

                            if(!(x==23 && y==11)){
                                x++;
                            }else{
                                x=tmpX;
                            }

                            size[i]=check(pos[line]);
                            counter++;
                            break;
                        case 3:
                            
                            //System.out.println("D");
                            direction=true;
                            if(counter>0){
                                line++;
                                if(line>19){
                                    line--;
                                    break;
                                }
                                rebuild(line,lineCounter);
                            }
                            pos[line][lineCounter]=4;
                            y++;
                            hansel(line,lineCounter,x,y);
                            //System.out.println("x: "+x+" y: "+y+"xp: "+xp+" yp: "+yp);
                            if(x==xp && y==yp){
                                //System.out.println("win");
                                win(line,lineCounter);
                                won[i]=true;
                                poswon=true;
                            }else{
                                lineCounter++;
                                if(lineCounter>19){
                                    lineCounter--;
                                    break;
                                }
                                tmp[i]=true;
                                posdown=pathToPac(x,y,tmp,xp,yp,line,lineCounter);
                                lineCounter--;
                                tmp[i]=false;
                            }
                            y--;
                            size[i]=check(pos[line]);
                            counter++;
                            break;
                            
                    }
                    //END SWITCH
                }
                //END IF 
            }
            //END FOR LOOP
    


            //CONSIDERING THE CASE THAT THE GHOST GOT TO A POINT WHERE IT COULDN'T MOVE FROM
            if(!direction){
                //this make the line invalidated
                pos[line][19]=5;
            }

            //DECIDING THE BEST LINE 
            for(int i=0;i<4;i++){
                if(size[i]<bestsize && won[i]==poswon){
                    bestsize=size[i];
                    better=i;
                }
            }

            //RETURNING THE BEST SOLUTION
            switch(better){
                case 1:
                    return posright;
                case 2:
                    return posup;
                case 3:
                    return posleft;
                case 4:
                    return posdown;
            }

       
        
       

   


        return pos[0];
    }
    
   


    public static int[] ghostRoad(int x,int y,boolean[] last,int xp, int yp,int line,int lineCounter){
        int[] bestRoad=new int[20];
        int size=0;
        int bestSize=21;
        int bestIndex=0;
        pathToPac(x, y, last, xp, yp, line, lineCounter);
        for(int i=0;i<20;i++){
            size=check(wpos[i]);
            if(size<bestSize && wpos[i][19]!=5 && size!=0){
                bestSize=size;
                bestIndex=i;
            }
        }
        if(bestSize==21){
            return new int[1];
        }
        for(int i=0;i<20;i++){
            bestRoad[i]=wpos[bestIndex][i];
        }
        return bestRoad;

    }
    /*public static void main(String Args[]){
        int x=10;
        int y=11;
        int xp=7;
        int yp=12;
        cls cls=new cls();
        Scanner console=new Scanner(System.in);
        System.out.println("enter the x value of the ghost");
        x=console.nextInt();
        cls.clear();
        System.out.println("enter the y value of the ghost");
        y=console.nextInt();
        cls.clear();
        System.out.println("enter the xp value of the pacman");
        xp=console.nextInt();
        cls.clear();
        System.out.println("enter the yp value of the pacman");
        yp=console.nextInt();
        cls.clear();
        System.out.println("with x="+x+" y="+y+" xp="+xp+" yp="+yp);
        
        boolean[] tmp=new boolean[4];
        int[] street=ghostRoad(x,y,tmp,xp,yp,0,0);
        
       
        if(won){
            System.out.println("path to pac: ");
            for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                    System.out.print(wpos[i][j]+" ");
                }
                System.out.println();
            }
            for(int i=0;i<20;i++){
            
                
                switch(street[i]){
                    case 1:
                    System.out.println("Right");
                    break;
                    case 2:
                    System.out.println("Up");
                    break;
                    case 3:
                    System.out.println("Left");
                    break;
                    case 4:
                    System.out.println("Down");
                    break;
                    
                }
            }
        }else{
            for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                    System.out.print(pos[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("we failed"); 
        }
        
        
    }*/
   
}
