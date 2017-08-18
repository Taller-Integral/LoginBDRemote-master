package com.ramiromadraiga.loginbdremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends ActionBarActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    Button siguiente,empresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        siguiente = (Button)findViewById(R.id.button3);
        siguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(MainActivity.this, Login.class);
                startActivity(siguiente);
            }
        });
        empresa = (Button)findViewById(R.id.button6);
        empresa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent empresa = new Intent(MainActivity.this, LoginEmpresas.class);
                startActivity(empresa);
            }


        });
        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
    }
}
