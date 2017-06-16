package com.test.milton.halfcircleprogressview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    HalfCircleProgressView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (HalfCircleProgressView) this.findViewById(R.id.halfCircle);
        new  Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (i <= 100){
                    view.setProgress(i++);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
