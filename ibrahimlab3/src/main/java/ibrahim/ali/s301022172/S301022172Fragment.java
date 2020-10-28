/**
 * Full Name: Ibrahim Ali
 * Student ID: 301022172
 * Section: COMP 304 - 002
 * */
package ibrahim.ali.s301022172;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class S301022172Fragment extends Fragment {
    //Declare variables
    ImageView moonImage, earthImage;
    Button startBtn, stopBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Initialize variables
        View root = inflater.inflate(R.layout.fragment_s301022172, container, false);
        moonImage = (ImageView) root.findViewById(R.id.ibrahimMoonImg);
        earthImage = (ImageView) root.findViewById(R.id.ibrahimEarthImg);
        startBtn = (Button) root.findViewById(R.id.ibrahimStartBtn);
        stopBtn = (Button) root.findViewById(R.id.ibrahimStopBtn);

        // Handle Buttons event onClick event listener
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimationMoon(R.anim.moon);
                performAnimationEarth(R.anim.earth);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moonImage.clearAnimation();
                earthImage.clearAnimation();
            }
        });

        return root;
    }

    public void performAnimationMoon(int animationResourceID)
    {
        // animate the imageview
        moonImage.setImageResource(R.drawable.moon);
        moonImage.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an =  AnimationUtils.loadAnimation(getActivity(), animationResourceID);

        // Start the animation
        moonImage.startAnimation(an);
    }


    public void performAnimationEarth(int animationResourceID)
    {
        // animate the imageview
        earthImage.setImageResource(R.drawable.earth);
        earthImage.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation earth =  AnimationUtils.loadAnimation(getActivity(), animationResourceID);

        //Start animation
        earthImage.startAnimation(earth);
    }
}