package com.example.pixeltest;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
    
     TextView width, height, dpi, resolution, dp, folder;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
         
          width = (TextView)findViewById(R.id.txt_width);
          height = (TextView)findViewById(R.id.txt_height);
          dpi = (TextView)findViewById(R.id.txt_DPI);
          resolution = (TextView)findViewById(R.id.txt_Resolution);
          dp = (TextView)findViewById(R.id.txt_DP);
          folder = (TextView)findViewById(R.id.txt_folder);
         
          Display dis = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
          DisplayMetrics disMetrics = new DisplayMetrics();
          getWindowManager().getDefaultDisplay().getMetrics(disMetrics);
          int deviceWidth = disMetrics.widthPixels;
          int deviceHeight = disMetrics.heightPixels;
          int result = disMetrics.densityDpi;
         
          Log.i("disMetrics", "disMetrics : " + disMetrics);
          //Log.i("deviceWidth", "deviceWidth" + Integer.toString(deviceWidth));
          //Log.i("deviceHeight", "deviceHeight" + Integer.toString(deviceHeight));
          //Log.i("resolution", "resolution : " + dis.getWidth()*dis.getHeight()/deviceWidth*deviceHeight);
          //Log.i("DPI", "DPI : " + result);
          //Log.i("DP", "DP : " + disMetrics.densityDpi/160);
                   
          width.setText("deviceWidth : " + Integer.toString(deviceWidth));
          height.setText("deviceHeight : " + Integer.toString(deviceHeight));
          resolution.setText("ÇØ»óµµ : " + dis.getWidth()*dis.getHeight()/deviceWidth*deviceHeight);
          dpi.setText("DPI : " + result);
          dp.setText("DP : " + disMetrics.densityDpi/160 + "px");
         
          if ( result > 0 && result < 160 ) {
               folder.setText("ldpi");
          } else if ( result >= 160 && result < 240 ) {
               folder.setText("mdpi");
          } else if ( result >= 240 && result < 320 ) {
               folder.setText("hdpi");
          } else if ( result >= 320 && result < 480 ) {
               folder.setText("xhdpi");
          } else {
               folder.setText("xxhdpi");
          }
         
     }
}
