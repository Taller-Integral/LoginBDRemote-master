package com.ramiromadraiga.loginbdremote;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailEmpresas extends Activity implements View.OnClickListener{
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep, sub, msg,tel,email,nombre;
    String rec, subject, textMessage,phone,correo,name,mensajeCompleto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_empresas);


        context = this;

        Button login = (Button) findViewById(R.id.btn_submit);
        reciep = (EditText) findViewById(R.id.et_to);
        sub = (EditText) findViewById(R.id.et_sub);
        msg = (EditText) findViewById(R.id.et_text);
        tel = (EditText) findViewById((R.id.et_sub_phone));
        email = (EditText) findViewById(R.id.et_sub_email_contact) ;
        nombre = (EditText)  findViewById(R.id.et_sub_nombre_empresa);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rec = reciep.getText().toString();
        subject = sub.getText().toString();
        textMessage = msg.getText().toString();
        phone = tel.getText().toString();
        correo = email.getText().toString();
        name = nombre.getText().toString();

        mensajeCompleto = "Mensaje: " + textMessage +"\n" + "Teléfono: " + phone +"\n" + "Correo: " +correo + "\n"+ "Nombre Empresa: " + name ;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ttinkacontacto@gmail.com", "ttinka2017");
            }
        });

        pdialog = ProgressDialog.show(context, "", "Sending Mail...", true);


        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(mensajeCompleto, "text/html; charset=utf-8");
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
            /*reciep.setText("");*/
            msg.setText("");
            sub.setText("");
            tel.setText("");
            email.setText("");
            nombre.setText("");
            Toast.makeText(getApplicationContext(), "Message Enviado a ttinkacontacto@gmail.com " , Toast.LENGTH_LONG).show();
        }
    }
}
