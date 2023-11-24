package io.codeforall.heapsdontlie;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameMusicPlayer {
    private Clip audioClip;
    private boolean isPlaying = false;

    public File soundFile;
    public GameMusicPlayer(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        URL url = this.getClass().getResource(audioFilePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);

        DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
        soundFile = new File(audioFilePath);
        audioClip = AudioSystem.getClip();
        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);

    }


    public void play() {
        if (audioClip != null && !isPlaying) {
            audioClip.start();
         //   audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            isPlaying = true;
        }
    }


    public void resume() {
        if (audioClip != null && !isPlaying) {
            audioClip.start();
            isPlaying = true;
        }
    }

    public void stop() {
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
            isPlaying = false;
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}




