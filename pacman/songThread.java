public class songThread implements Runnable{
    Audio audio;
    String name;
    songThread(Audio audio, String name){
        this.audio=audio;
        this.name=name;
    }
    public void run(){
        try{
        audio.player(this.name);
        }catch(Exception e ){
            System.out.println(e);
        }
        
    }
}
