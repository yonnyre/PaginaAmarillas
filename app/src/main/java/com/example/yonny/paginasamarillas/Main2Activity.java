package com.example.yonny.paginasamarillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    String dato1,dato2,dato3,dato4,dato5,dato6,dato7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       textView1=(TextView)findViewById(R.id.nombreText);
       textView2=(TextView)findViewById(R.id.direccionText);
       textView3=(TextView)findViewById(R.id.correoText);
       textView6=(TextView)findViewById(R.id.infoText);
       textView4=(TextView)findViewById(R.id.rubroText);
       textView7=(TextView)findViewById(R.id.telefonoText);
       textView5=(TextView)findViewById(R.id.urlText);



        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {
             dato1=(String)extras.get("nombre");
             dato2=(String)extras.get("direccion");
             dato3=(String)extras.get("correo");
             dato4=(String)extras.get("rubro");
             dato5=(String)extras.get("url");
             dato6=(String)extras.get("info");
             dato7=(String)extras.get("telefono");


            textView1.setText(dato1);
            textView2.setText(dato2);
            textView3.setText(dato3);
            textView5.setText(dato4);
            textView4.setText(dato5);
            textView6.setText(dato6);
            textView7.setText(dato7);
        }

    }

    public void goUrl(View v) {
        Uri uri = Uri.parse(dato5);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void goMail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, dato3);
        emailIntent.putExtra(Intent.EXTRA_CC, dato3);

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Main2Activity.this,
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }
    }

    public void goSms(View v) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("vnd.android-dir/mms-sms");
        sendIntent.putExtra("address", dato7);
        sendIntent.putExtra("sms_body", "");
        startActivity(sendIntent);
    }

    public void goShare(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, dato5);
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void goCall(View v){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    Integer.parseInt("123"));
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+ dato7)));
        }
    }

}
