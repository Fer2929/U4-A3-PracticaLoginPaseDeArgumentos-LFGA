package angel.alberto.loginpasedeargumetos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import angel.alberto.loginpasedeargumetos.R;
import angel.alberto.loginpasedeargumetos.daos.UsuariosDao;
import angel.alberto.loginpasedeargumetos.models.Usuario;


public class Login extends Activity {
    EditText txtusuario, txtpass;
    Button btnboton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtusuario = findViewById(R.id.TxtUsuario);
        txtpass = findViewById(R.id.TxtPassword);
        btnboton =findViewById(R.id.btnLogin);

        btnboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuariosDao udao=new UsuariosDao();

                boolean resul= udao.usuarioExist(new Usuario(txtusuario.getText().toString(),
                                                              txtpass.getText().toString()));
                Intent respuesta = new Intent();
                respuesta.putExtra("resultado", resul);
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //se comenta el super y se deja vacio para que no cancele la activity login con la tecla back
        //super.onBackPressed();
    }
}