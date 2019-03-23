package br.edu.unicesumar.aula02;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinatorlayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText edtLogin = (EditText) findViewById(R.id.edtLogin);
        Button btnAutenticar = (Button) findViewById(R.id.btnAutenticar);
        cliqueDoAutenticar(edtLogin, btnAutenticar);

        FloatingActionButton fb = (FloatingActionButton) findViewById(R.id.fab);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.activitymain), "clicou", Snackbar.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_pesquisar:
                Toast.makeText(this, "pesquisar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_configuracoes:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


    private void cliqueDoAutenticar(final EditText edtLogin, Button btnAutenticar) {
        btnAutenticar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), SegundaTelaActivity.class);
                it.putExtra("msg", edtLogin.getText().toString());
                startActivity(it);

            }
        });
    }
}
