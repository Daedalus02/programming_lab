public class cls {
    public void clear(){
        try{
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
