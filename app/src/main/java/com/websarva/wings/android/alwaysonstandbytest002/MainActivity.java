package com.websarva.wings.android.alwaysonstandbytest002;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.TimerTask;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private int count_num = 0;
    private boolean count_flag = false;
    private Button bt_count_start;                                                                  // グローバル化するため登録だけしておく
    private TextView tv_counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_count_start = (Button) findViewById(R.id.bt_count_start);                                // オブジェクトに登録
        tv_counter = (TextView) findViewById(R.id.tv_counter);

        MainListener mainListener = new MainListener();                                             // リスナ開始
        bt_count_start.setOnClickListener(mainListener);                                            // ボタンをリスナに登録

    }


    @Override
    public void onDestroy() {    // アプリが終了した場合
        super.onDestroy();
    }


    // クリック ～ ビュー関係 オーバーライド
    private class MainListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int objID = view.getId();

            switch (objID) {
                case R.id.bt_count_start:
                    count_flag = !count_flag;                                                       // カウントフラグのスイッチ動作（false,true)
                    if(count_flag){
                        startService(new Intent(getBaseContext(),TestService.class));
                    }else if (!count_flag){
                        stopService(new Intent(getBaseContext(),TestService.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "なんで？", Toast.LENGTH_SHORT).show();
                    }
                    break;

                default:
                    String mesg = "認識されないオブジェクトがクリックされました。:" + String.valueOf(objID);
                    Toast.makeText(getApplicationContext(), mesg, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}


