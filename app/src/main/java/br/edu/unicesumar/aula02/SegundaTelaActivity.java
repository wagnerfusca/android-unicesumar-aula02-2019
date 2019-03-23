package br.edu.unicesumar.aula02;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SegundaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cordinator_segunda_tela);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_segunda_activity));

        Intent it = getIntent();
        String msg = it.getStringExtra("msg");

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        //Snackbar.make(findViewById(R.id.segundaactivity), getIntent().getStringExtra("msg"), Snackbar.LENGTH_SHORT).show();

        abrirSite();

        fazerLigacao();

        abriCamera();

        notificacaoSimples();

        notificacaoBig();

        notificacaoComAcao();
    }

    private void notificacaoComAcao() {
        Button btnNotificacaoComAcao = findViewById(R.id.btnNotificacaoComAcao);
        btnNotificacaoComAcao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notifyID = 3;
                String CHANNEL_ID = "my_channel_03";
                CharSequence name = "my_channel_03";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                PendingIntent it = PendingIntent.getBroadcast(getApplicationContext(), 0,
                        new Intent(Intent.ACTION_VIEW),0);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_student_borda_arredondada)
                        .setContentTitle("Notificacao Com Ação")
                        .setContentText("Toca ou nao toca?")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .addAction(android.R.drawable.ic_media_pause, "Pausar", it)
                        .addAction(android.R.drawable.ic_media_play, "Play", it);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(mChannel);
                notificationManager.notify(notifyID, builder.build());

            }
        });
    }

    private void notificacaoBig() {
        Button btnNotificacaoBig = findViewById(R.id.btnNotificacaoBig);
        btnNotificacaoBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notifyID = 2;
                String CHANNEL_ID = "my_channel_02";
                CharSequence name = "my_channel_02";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                List<String> lista = new ArrayList<>();
                lista.add("Primeira linha");
                lista.add("Segunda linha");
                lista.add("terceira linha");
                lista.add("terceira linha");
                lista.add("terceira linha");
                lista.add("terceira linha");
                lista.add("terceira linha");

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("NOTIFACAO BIG");
                for(String s: lista){
                    inboxStyle.addLine(s);
                }
                inboxStyle.setSummaryText("voce possui " + lista.size() + " novas mensagens" );

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_student_borda_arredondada)
                        .setContentTitle("NOTIFACAO BIG")
                        .setContentText("FEITO!!!!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setStyle(inboxStyle);


                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(mChannel);
                notificationManager.notify(notifyID, builder.build());
            }
        });
    }

    private void notificacaoSimples() {
        Button btnNotificacaoSimples = findViewById(R.id.btnNotificacaoSimples);
        btnNotificacaoSimples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int notifyID = 1;
                String CHANNEL_ID = "my_channel_01";
                CharSequence name = "my_channel_01";
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_student_borda_arredondada)
                        .setContentTitle("Minha Primeira Notificação")
                        .setContentText("FEITO!!!!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(mChannel);
                notificationManager.notify(notifyID, builder.build());

            }
        });
    }

    private void abriCamera() {
        Button btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(it);

            }
        });
    }

    private void fazerLigacao() {
        Button btnLigar = findViewById(R.id.btnLigar);
        btnLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtLigar = findViewById(R.id.edtLigar);
                Uri uri = Uri.parse("tel:"+edtLigar.getText().toString());

                Intent it = new Intent(Intent.ACTION_CALL, uri);
                startActivity(it);
            }
        });
    }

    private void abrirSite() {
        Button btnSite = findViewById(R.id.btnAbrirSite);
        btnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtSite = findViewById(R.id.edtAbrirSite);
                Uri uri = Uri.parse("http://" + edtSite.getText().toString());

                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_segunda_tela, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.mn_sair):
                finish();

                break;

            default:
                break;
        }
        return true;
    }
}
