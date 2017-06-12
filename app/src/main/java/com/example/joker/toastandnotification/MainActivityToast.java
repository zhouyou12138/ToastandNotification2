package com.example.joker.toastandnotification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joker on 2017/6/10.
 */

public class MainActivityToast extends AppCompatActivity {
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button10)
    Button button10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_toast);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button11, R.id.button10})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button11:
                setTitle("短时提醒");
                Toast.makeText(this, "这是个短时提醒", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button10:
                setTitle("长时提醒");
                Toast.makeText(this, "这是个长时提醒", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
