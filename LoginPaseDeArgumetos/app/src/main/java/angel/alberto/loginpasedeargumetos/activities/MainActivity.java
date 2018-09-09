package angel.alberto.loginpasedeargumetos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import angel.alberto.loginpasedeargumetos.R;

public class MainActivity extends Activity {
    public static final int LOGIN_INTENT_CODE = 20;
    public static final int ALUMNOS_INTENT_CODE = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent loginIntent = new Intent(MainActivity.this,Login.class);
        startActivityForResult(loginIntent,LOGIN_INTENT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==LOGIN_INTENT_CODE){
            // Programar lo que hay que hacer cuando regrese el usuario y contraseña
            boolean res = data.getBooleanExtra("resultado",false);
            if (res){
                Toast.makeText(this,"Bienvenido Usuario :D" ,Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"Autenticacion Fallida, Vuelva a intentarlo" ,Toast.LENGTH_LONG).show();
                Intent loginIntent = new Intent(MainActivity.this,Login.class);
                startActivityForResult(loginIntent,LOGIN_INTENT_CODE);
            }

        }
    }
}
