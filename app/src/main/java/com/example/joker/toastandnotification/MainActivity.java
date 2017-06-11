package com.example.joker.toastandnotification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                setTitle("这是Notification");
                Intent intent = new Intent(MainActivity.this, MainActivityNotification.class);
                startActivity(intent);
                break;
            case R.id.button2:
                setTitle("这是Toast");
                Intent intent1 = new Intent(MainActivity.this, MainActivityToast.class);
                startActivity(intent1);
                break;
        }
    }
}
