import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class PlaySound {
      public static void play() {
  	    try{
  	      File dafile = new File(System.getProperty("user.dir")+"/Sound/sound.wav");
  	      AudioInputStream audioIn = AudioSystem.getAudioInputStream(dafile);
  	      AudioFormat format = audioIn.getFormat();
  	      DataLine.Info info = new DataLine.Info(Clip.class, format);
  	      Clip clip = (Clip)AudioSystem.getLine(info);
  	      clip.open(audioIn);
  	      clip.start();
  	   
  	      Thread.sleep(600);
  	    }
  	    catch(Exception e){
  	    	e.printStackTrace();

  	    }
      }
}
