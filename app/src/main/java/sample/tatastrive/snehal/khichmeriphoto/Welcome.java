package sample.tatastrive.snehal.khichmeriphoto;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Welcome extends AppCompatActivity {
    MediaPlayer mediaPlayer ;
    Thread timer;


    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mediaPlayer=MediaPlayer.create(Welcome.this,R.raw.sound);
        mediaPlayer.start();
        timer=new Thread()
        {
            public void run(){
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent on=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(on);
                }

            }
        };
        timer.start();

    }
}