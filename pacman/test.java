public class test {
    
    public static void main(String Args[]){
                Thread t=new ghostbackup();
                boolean[] tmp=new boolean[4];
                int[] street=((ghostbackup) t).ghostRoad(7, 7, tmp, 1, 2, 0, 0);
                for(int i=0;i<20 && street[i]!=0;i++){
                    System.out.print(street[i]+" ");
                }
                System.out.println();
                }
    
}
