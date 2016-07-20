package mx.unam.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.unam.petagram.email.SendEmail;

public class Contacto extends AppCompatActivity {

    EditText nombre, email, comentario;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.etNombre);
        email = (EditText) findViewById(R.id.etEmail);
        comentario = (EditText) findViewById(R.id.etComentario);
        boton = (Button) findViewById(R.id.MiBoton);

    }

    public void sendEmail(View v) {
        //Getting content for email
        String Email = email.getText().toString().trim();
        String subject = nombre.getText().toString().trim();
        String message = comentario.getText().toString().trim();

        //Creating SendMail object
        SendEmail sm = new SendEmail(this, Email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

}
