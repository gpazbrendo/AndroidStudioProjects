package br.senac.pi.demoviews;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ProgressDialogDemoActivity extends AppCompatActivity {

    private static final String URL = "http://livroandroid.com.br/imgs/livro_android.png";
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        dialog = ProgressDialog.show(this, "Exemplo", "Buscando imagem, por favor aguarde.", false, true);
        downloadImage(URL);
    }

    public void downloadImage(final String urlImage) {
        new Thread() {
            @Override
        public void run() {
                try {
                    //Faz o dowload da imagem
                    URL url = new URL(urlImage);
                    InputStream in = url.openStream();
                    //Converte a inputStream do Java para Bitmap
                    final Bitmap imagem = BitmapFactory.decodeStream(in);
                    in.close();
                    //Atualisa a tela, seta a imagem do dowload no ImagemView
                    atualizaImagem(imagem);
                } catch (IOException e) {
                    //Uma aplicação real deverar tratar este erro...
                    Log.e("Erro Dowload:" , e.getMessage(), e);
                }
            }
        }.start();
    }

    public void atualizaImagem(final Bitmap imagem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                ImageView imageView = (ImageView) findViewById(R.id.imge);
                imageView.setImageBitmap(imagem);

            }
        });
    }

}

