package com.ramiromadraiga.loginbdremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ramiro on 25/01/2015.
 */
public class ReadComments extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // note that use read_comments.xml instead of our single_post.xml
        setContentView(R.layout.read_comments);

        setTitle("Bienvenido a T-tinka...");

        Button orderButton = (Button)findViewById(R.id.btnIngresar);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       Intent intent = new Intent(FirstActivity.this, OrderScreen.class);
                Intent button_uno = new Intent (ReadComments.this, MenuEmpresas.class);
                startActivity(button_uno);
            }
        });
        //---END BOTON---//


    }
}
