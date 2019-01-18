package sample.tatastrive.snehal.khichmeriphoto;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView IMVW;
    ImageButton IMBTN;
    Button WALLLBTN;
    Intent invokecam;//camera invoking by implicit intent
    final static int picbycamera = 10;
    Bitmap bitmp;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bitmp = (Bitmap) extras.get("data");
            IMVW.setImageBitmap(bitmp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IMVW = findViewById(R.id.iv);
        IMBTN = findViewById(R.id.ib);
        WALLLBTN = findViewById(R.id.b1);

        InputStream is = getResources().openRawResource(R.raw.ic_launcher_background);
        bitmp = BitmapFactory.decodeStream(is);
        //Iage Button Start
        IMBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokecam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(invokecam, picbycamera);

            }
        });


        //Set wallpaper button start
        WALLLBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getApplicationContext().setWallpaper(bitmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}