package ibrahim.ali.s301022172;

import android.content.DialogInterface;
import android.graphics.RadialGradient;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class ibrahimActivity extends AppCompatActivity {

    private CanvasView customCanvas;
    String paint, brush;
    RadioButton black, green, red;
    RadioButton size10, size20, size30;
    AnimationDrawable mframeAnimation = null;
    ImageView img;
    RadioButton rd1,rd2,rd3,rd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void selectPaintBrush(View view) {
        customCanvas = (CanvasView) findViewById(R.id.ibrahimCanvas);
        black = (RadioButton) findViewById(R.id.ibrahimPaintBlack);
        green = (RadioButton) findViewById(R.id.ibrahimPaintGreen);
        red = (RadioButton) findViewById(R.id.ibrahimPaintRed);
        size10 = (RadioButton) findViewById(R.id.ibrahimBrush10ft);
        size20 = (RadioButton) findViewById(R.id.ibrahimBrush20ft);
        size30 = (RadioButton) findViewById(R.id.ibrahimBrush30ft);

        if(black.isChecked()){
            paint = "black";
        }else if(green.isChecked()){
            paint = "green";
        }else if(red.isChecked()){
            paint = "red";
        }

        if(size10.isChecked()){
            brush = "10ft";
        }else if(size20.isChecked()){
            brush = "20ft";
        }else if(size30.isChecked()){
            brush = "30ft";
        }

        if (brush != null && paint != null) {
            customCanvas.radiosPaintBrushSelection(paint, brush);
        }
    }

    public void selectSpeed(View view){

        rd1 = (RadioButton) findViewById(R.id.ibrahimSpeedOne);
        rd2 = (RadioButton) findViewById(R.id.ibrahimSpeedTwo);
        rd3 = (RadioButton) findViewById(R.id.ibrahimSpeedThree);
        rd4 = (RadioButton) findViewById(R.id.ibrahimSpeedFour);

        if(rd1.isChecked()){
            startAnimation(650);
        }else if(rd2.isChecked()){
            startAnimation(450);
        }else if(rd3.isChecked()){
            startAnimation(200);
        }else if(rd4.isChecked()){
            startAnimation(50);
        }
    }

    public void startAnimation(int speed)
    {
        img = (ImageView) findViewById(R.id.ibrahimImageBird);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird9);
        BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird10);
        BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird11);
        BitmapDrawable frame12 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird12);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = speed;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);
        mframeAnimation.addFrame(frame10, reasonableDuration);
        mframeAnimation.addFrame(frame11, reasonableDuration);
        mframeAnimation.addFrame(frame12, reasonableDuration);


        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    public void stopAnimation(View view)
    {
        img = (ImageView) findViewById(R.id.ibrahimImageBird);

        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }

    //If back btn pressed, display alert dialog
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setCancelable(false);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(1);
                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
