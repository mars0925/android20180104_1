package com.mars.android20180104_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    //progressbar 從0到100教學
    int pi;
    ProgressBar pb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb2 = (ProgressBar) findViewById(R.id.progressBar);
    }


    public void clickgo(View v) {

        new Thread() {
            @Override
            public void run() {
                super.run();

                for (pi = 0; pi <= 100; pi++) {
                    //副執行緒
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //pi的變數要在class層做宣告 不然讀不到
                            pb2.setProgress(pi);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
