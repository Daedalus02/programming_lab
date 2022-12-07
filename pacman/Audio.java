import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.sound.sampled.*;

public class Audio {
    public void player(String name) throws LineUnavailableException, InterruptedException, UnsupportedAudioFileException, IOException{
        name=name+".wav";
        File file=new File(name);
        AudioInputStream stream=AudioSystem.getAudioInputStream(file);
        Clip clip=AudioSystem.getClip();
   
        CountDownLatch synclatch=new CountDownLatch(1);
        clip.addLineListener(e->{

            if(e.getType()==LineEvent.Type.STOP){
                synclatch.countDown();
            }
        });
        clip.open(stream);
        clip.start();
        synclatch.await();
        /*AudioFormat format=stream.getFormat();
        long frames=stream.getFrameLength();
        double duration=(frames+0.0)/format.getFrameRate();
        double dur=0.0D;
        while(dur<duration){
            Thread.sleep(50);
            dur=dur+0.05D;
        }*/

    }
}