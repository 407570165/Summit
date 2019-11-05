package com.justin.summit;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView passward;
    private TextView mail;
    private TextView name;
    private Button summit;
    private ImageView smile;
    private ImageView smiles;
    private ImageView smiless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.editName);
        mail = findViewById(R.id.editmail);
        passward = findViewById(R.id.editpassward);
        summit = findViewById(R.id.button);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void reset(){

    }
    public void start (View view){
        int namec =name.getText().length();
        int passwardc =passward.getText().length();
        String message ="";
        smile = findViewById(R.id.imageView);
        smiles = findViewById(R.id.imageView4);
        smiless = findViewById(R.id.imageView5);
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        };
        if (namec<5&&passwardc<5){
            message="name fail&&passward fail";
            listener=null;
            smile.setVisibility(View.VISIBLE);
           // smile.setImageResource(R.drawable.wrong);
            smiless.setVisibility(View.VISIBLE);
            //smiless.setImageResource(R.drawable.wrong);
        }
        else if (namec<5&&passwardc>5){
            message="name fail";
            listener=null;
        }
        else if (namec>5&&passwardc<5){
            message="passward fail";
            listener=null;
        }
        else
            message="註冊成功";
        listener=null;
        smile.setVisibility(View.VISIBLE);
        smiles.setVisibility(View.VISIBLE);
        smiless.setVisibility(View.VISIBLE);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("result")
                .setMessage(message)
                .setPositiveButton("ok",listener)
                .show();
    }
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
