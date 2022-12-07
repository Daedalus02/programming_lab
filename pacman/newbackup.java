public class newbackup {
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
    
        static int superLine=0;
        static int[][] posx=new int[20][20];
        static int[][] posy=new int[20][20];
        static int[][]pos=new int[20][20];
        static int[][]wpos=new int[20][20];
        static int[] badsol=new int[20];
        static boolean won=false;
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
    
    
    
        public static boolean[] specialAnd( boolean[] last,boolean[] next){
    
            if(last.length!=last.length)
                System.exit(1);
    
            for(int i=0;i<last.length;i++){
                if(last[i]){
                switch(i){
                    case 0: 
                    next[2]=false;
                    break;
                    case 1:
                    next[3]=false;
                    break;
                    case 2:
                    next[0]=false;
                    break;
                    case 3:
                    next[1]=false;
                    break;
                }
            }
        }
            return next;
        }
    
        
    
        public static int check(int[] arr){
            int size=0;
            for(int i=0;i<20;i++){
                if(arr[i]==0)
                return size;
                size++;
            }
            return size;
        }
    
    
    
        public static boolean[] checkNext(int x,int y){
                boolean[] possible=new boolean[4];
                
                if(map[y][x+1]!=1){
                    possible[0]=true;
                }
                if(y>1 && map[y-1][x]!=1){
                    possible[1]=true;
                }
                if(x>1 && map[y][x-1]!=1){
                    possible[2]=true;
                }
                if(map[y+1][x]!=1){
                    possible[3]=true;
                }
                return possible;
            }
    
    
    
            
        public static void hansel(int line, int lineCounter){
            for(int i=0;i<lineCounter;i++){
                    if(posx[line][i]==posx[line][lineCounter] && posy[line][i]==posy[line][lineCounter]){
                        pos[line][0]=5;
                    }
                }
        }
            public static int checkProximity(int x, int y){
                return x+y;
            }
    
    
        public static int[] builder(int x,int y,boolean[] last,int xp, int yp,int line,int lineCounter){
            System.out.println("position: x: "+x+" y: "+y);
    
    
            //VARIABLE DECLARATION
            int worstProx=1000;
            boolean[] next=new boolean[4];
            boolean[] tmp=new boolean[4];
            int better=1;
            int size=20;
            int[] posup=new int[20];
            int[] posdown=new int[20];
            int[] posleft=new int[20];
            int[] posright=new int[20];
            int counter=0;
            int bestEnd=20;
            int bestLine=0;
            int worstEnd=20;
            int worstLine=0;
            boolean direction=false;
    
            next=checkNext(x,y);
            next=specialAnd(last, next);
    
    
            if(lineCounter<19 && line<19){
            //CASES EXAMINATION
            if((x!=xp || y!=yp) ){
            for(int i=0;i<4;i++){
                if(next[i]){
                    switch(i){
                        case 0: 
                            direction=true;
                            pos[line][lineCounter]=1;
                            x++;
                            posy[line][lineCounter]=y;
                            posx[line][lineCounter]=x;
                            hansel(line,lineCounter);
    
                            lineCounter++;
                            tmp[i]=true;
                            posright=builder(x,y,tmp,xp,yp,line,lineCounter);
                            lineCounter--;
    
                            if(check(posright)<size){
                                size=check(posright);
                                better=1;
                            }
    
                            tmp[i]=false;
                            x--;
                            counter++;
                            break;
                        
    
    
                        case 1:
                            direction=true;
    
                            if(counter>0){
                                /* 
                               while(line>0 && check(pos[line])==0){
                                line--;
                                }*/
                               line++; 
                            }
                            
                            pos[line][lineCounter]=2;
                            y--;
                            posy[line][lineCounter]=y;
                            posx[line][lineCounter]=x;
                            hansel(line,lineCounter);
    
                            lineCounter++;
                            tmp[i]=true;
                            posup=builder(x,y,tmp,xp,yp,line,lineCounter);
                            lineCounter--;
    
                            if(check(posup)<size){
                                size=check(posup);
                                better=2;
                            }
    
                            tmp[i]=false;
                            y++;
                            counter++;
                            break;
                            
    
    
    
                        case 2:
                            direction=true;
                            
                            if(counter>0){
                                /* 
                                while(line>0 &&check(pos[line])==0){
                                    line--;
                                 }*/
                                line++;
                            }
    
                            pos[line][lineCounter]=3;
                            x--;
                            posy[line][lineCounter]=y;
                            posx[line][lineCounter]=x;
                            hansel(line,lineCounter);
    
                            lineCounter++;
                            tmp[i]=true;
                            posleft=builder(x,y,tmp,xp,yp,line,lineCounter);
                            lineCounter--;
    
                            if(check(posleft)<size){
                                size=check(posleft);
                                better=3;
                            }
    
                            x++;
                            tmp[i]=false;
                            counter++;
                            break;
    
    
    
                        case 3:
                            direction=true;
    
                            if(counter>0){
                                /*
                                while(line>0 &&check(pos[line])==0){
                                    line--;
                                 }*/
                                line++;
                            }
                            
                            pos[line][lineCounter]=4;
                            y++;
                            posy[line][lineCounter]=y;
                            posx[line][lineCounter]=x;
                            hansel(line,lineCounter);
    
                            lineCounter++;
                            tmp[i]=true;
                            posdown=builder(x,y,tmp,xp,yp,line,lineCounter);
                            lineCounter--;
    
                            if(check(posdown)<size){
                                size=check(posdown);
                                better=4;
                            }
    
                            tmp[i]=false;
                            y--;
                            counter++;
                            break;
                    }
                }
            }
        }else{
             
          
            //SPACE ELIMINATION
            int prox;
            for(int i=0;i<20;i++){
                
                /*for(int j=0;j<20;j++){
                    if(j>0 && i>0 && pos[i][j]!=0 && pos[i][j-1]==0){
                        //System.arraycopy(pos[i-1],0,pos[i],0,j);
                    }
                    
                }
                for(int j=0;j<20;j++){
                    System.out.print(wpos[i][j]+" ");
                }*/
                System.out.println();
                System.arraycopy(pos[i],0,wpos[i],0,check(pos[i]));
                
                //System.out.println("proximity: "+prox);
                if((check(pos[i])<bestEnd) && (check(pos[i])!=0) && (pos[i][0]!=5)){
                    bestEnd=check(pos[i]);
                    bestLine=i;
                }
            }
    
    
    
            //GRID PRINT
            /*for(int i=0;i<20;i++){
                for(int j=0;j<20;j++){
                    System.out.print(pos[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            */
    
            //RETURN
            won=true;
            superLine=bestLine;
            return wpos[bestLine];
    
                
        }
    
        }else{
            /* 
            //SPACE ELIMINATION
            int prox;
            int nullcounter=0;
            for(int i=0;i<20;i++){
               //FILLING CLEAR LINES
                for(int j=0;j<20;j++){
                    if(j>0 && i>0 && pos[i][j]!=0 && pos[i][j-1]==0){
                        System.arraycopy(pos[i-1],0,pos[i],0,j);
                    }
                    
                }
                //CHECK IF SOLUTION IS IMPOSSIBLE
                if(check(pos[i])==0){
                   nullcounter++;
                }
                
                //CHECK PROXIMITY
                prox=checkProximity(Math.abs(posx[i][check(posx[i])]-xp),Math.abs(posy[i][check(posx[i])]));
                //System.out.println("proximity: "+prox);
                if((check(pos[i])<worstEnd) && (check(pos[i])!=0) && (pos[i][0]!=5) && prox<worstProx && nullcounter==0){
                    worstEnd=check(pos[i]);
                    worstProx=prox;
                    worstLine=i;
                }
               }
               //GRID PRINT
               /*for(int i=0;i<20;i++){
                   for(int j=0;j<20;j++){
                       System.out.print(wpos[i][j]+" ");
                   }
                   System.out.println();
               }
               System.out.println();
               
       
               //RETURN (BAD SOLUTION)
               if(nullcounter==0){
                   won=false;
                   superLine=worstLine;
                   return pos[worstLine];
               }
               */
               
        }
        
        
            if(!direction && counter<19){
                pos[line][0]=5;
            }
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
        
       
    
    
        /*public void followPac(int xp, int yp){
            int sum=0;
            int finalX=x/25;
            int finalY=y/25;
             int[][] possible;
            boolean[] nextStep=new boolean[4];
            int[] path=new int[20];
            boolean[] lastStep=new boolean[4];
            if(Math.abs(x-xp)<6 || Math.abs(y-yp)<6){
                while(finalX!=xp && finalY!=yp){
                  
                    if(map[finalY][finalX]!=1){
                        nextStep=checkNext(finalX,finalY);
                        
                        
                        
                    }
                    
                }
    
    
            }
    
        }*/
        public static void main(String Args[]){
            int x=1;
            int y=2;
            int xp=7;
            int yp=7;
            boolean[] tmp=new boolean[4];
            builder(x,y,tmp,xp,yp,0,0);
            for(int i=0;i<20;i++){
                //System.out.println(pos[i][0]);
               /*  for(int j=0;j<20;j++){
                    if(pos[i][j]!=0){
                        //System.out.println("il valore della migliore linea è "+ superLine);
                        //System.out.println("il valore della i: "+i+" il valore della j: "+j);
                        
                    }
                    System.out.print(pos[i][j]+" ");
                }
                System.out.println();*/
                if(won){
                    System.out.println("won");
                switch(wpos[superLine][i]){
                    case 1:
                    System.out.println("R");
                    break;
                    case 2:
                    System.out.println("U");
                    break;
                    case 3:
                    System.out.println("L");
                    break;
                    case 4:
                    System.out.println("D");
                    break;
                    
                }
            }else{
                switch(pos[superLine][i]){
                    case 1:
                    System.out.println("R");
                    break;
                    case 2:
                    System.out.println("U");
                    break;
                    case 3:
                    System.out.println("L");
                    break;
                    case 4:
                    System.out.println("D");
                    break;
                    
                }
            }
            }
    
        }
    }
    

