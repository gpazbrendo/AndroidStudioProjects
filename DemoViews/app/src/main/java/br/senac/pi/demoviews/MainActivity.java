package br.senac.pi.demoviews;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        findViewById(R.id.btnTextViewDemo).setOnClickListener(abrirTextViewDemo());
        findViewById(R.id.btnEditTextDemo).setOnClickListener(abrirEditTextDemo());
        findViewById(R.id.imgViemDemo).setOnClickListener(abrirImgViewDemo());
        findViewById(R.id.btnCompleteDemo).setOnClickListener(abrirAutoComplete());
        findViewById(R.id.btnImageButton).setOnClickListener(abrirImagemButton());
        findViewById(R.id.btnButton).setOnClickListener(abrirCheckButton());
        findViewById(R.id.btnProgressDialog).setOnClickListener(abrirProgressDialog());
    }
    private View.OnClickListener abrirTextViewDemo(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirEditTextDemo(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditTextDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirImgViewDemo(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageViewDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirAutoComplete(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AutoCompleteDemo.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirImagemButton(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageButtonDemo.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener abrirCheckButton(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckBoxToggleButton.class);
                startActivity(intent);
            }
        };
    }
    private View.OnClickListener abrirProgressDialog(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgressDialogDemoActivity.class);
                startActivity(intent);
            }
        };
    }

    //public void abrirTextViewDemo(View view){
    //    Intent intent = new Intent(this, TextViewDemo.class);
    //    startActivity(intent);
    //        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
