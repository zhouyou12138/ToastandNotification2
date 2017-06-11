package com.example.joker.toastandnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by joker on 2017/6/10.
 */

public class MainActivityNotification extends Activity {
    private static int NOTIFICATIONS_ID = R.layout.activity_notification;
    @BindView(R.id.button3)
    Button button4;
    @BindView(R.id.button4)
    Button button3;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    private NotificationManager mNotificationManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        mNotificationManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); //得到NotificationManager
    }

    @OnClick({R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button3:
                setWeather("天气消息","天气状况","晴",R.drawable.ic_weather_sun);
                break;
            case R.id.button4:
                setWeather("天气消息","天气状况","雨",R.drawable.ic_weather_rain);
                break;
            case R.id.button5:
                setWeather("天气消息","天气状况","阴",R.drawable.ic_weather_cloud);
                break;
            case R.id.button6:
                setDefault(Notification.DEFAULT_VIBRATE);//震动提示
                break;
            case R.id.button7:
                setDefault(Notification.DEFAULT_SOUND);  //声音提示
                break;
            case R.id.button8:
                setDefault(Notification.DEFAULT_ALL);//声音+震动提示
                break;
            case R.id.button9:
                mNotificationManger.cancel(NOTIFICATIONS_ID);
                break;
        }
    }

    private void setWeather(String tickerText, String title, String text, int drawable) {
//        Notification notification = new Notification(drawable,tickerText,System.currentTimeMillis());
//        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
//        notification.setLatestEventInfo(this,title,content,contentIntent);
//        mNotificationManger.notify(NOTIFICATIONS_ID,notification);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText(text)   //设置上下文内容
                .setContentTitle(title)//设置下拉列表里的标题
                .setSmallIcon(drawable)//设置状态栏里面的图标（小图标）
                .setTicker(tickerText)//设置状态栏的显示的信息
                .setAutoCancel(true)//设置可以清除
                .setWhen(System.currentTimeMillis());//通知发生的时间为系统当前时间
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivityNotification.class), 0);
        builder.setContentIntent(pendingIntent);
        mNotificationManger.notify(NOTIFICATIONS_ID, builder.build());
    }

    private void setDefault(int defaults) {
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        String title = "天气情况";
        String text = "天气如何";
        String tickerText = "您有一条天气消息";
        int drawable = R.drawable.ic_weather_deafult;
        final Notification.Builder notification = new Notification.Builder(this);
        notification.setContentText(text)
                .setContentTitle(title)
                .setSmallIcon(drawable)
                .setTicker(tickerText)
                .setDefaults(defaults)
                .setContentIntent(contentIntent);
        mNotificationManger.notify(NOTIFICATIONS_ID, notification.build());
    }

}
