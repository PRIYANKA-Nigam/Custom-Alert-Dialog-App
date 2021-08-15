package com.example.customalertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { Button b,button; ListView listView=null; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
    listView=new ListView(this);button=(Button)findViewById(R.id.but3);button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
                a.setMessage("do you want ot close this app!!!").setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialogInterface, int i) { finish(); }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { dialogInterface.cancel(); }});
                AlertDialog alert= a.create();alert.setTitle("Alert !!!");alert.show();}
        });
        String[] items={"Facebook","Github","LinkedIn","Stack Overflow","Google Mail","Indeed","E-Litmus","Google Drive","Zoom","Loom",
        "Meet","Skype"}; ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.dialog_list,R.id.tt,items);
        listView.setAdapter(adapter); listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg=(ViewGroup)view; TextView t=(TextView)vg.findViewById(R.id.tt);
                Toast.makeText(MainActivity.this,t.getText().toString(),Toast.LENGTH_SHORT).show(); }});
        b=(Button)findViewById(R.id.but); b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { AlertDialog.Builder mbuilder=new AlertDialog.Builder(MainActivity.this);
                View mview=getLayoutInflater().inflate(R.layout.dialod_login,null);
                final EditText e1=(EditText)mview.findViewById(R.id.editTextTextEmailAddress);
                final EditText e2=(EditText)mview.findViewById(R.id.editTextNumberPassword);
                Button b1=(Button) mview.findViewById(R.id.button); b1.setOnClickListener(new View.OnClickListener() {@Override
                    public void onClick(View v) { if (!e1.getText().toString().isEmpty() && !e2.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,"Login Succesful",Toast.LENGTH_SHORT).show(); }else {
                            Toast.makeText(MainActivity.this,R.string.error_Login_message,Toast.LENGTH_SHORT).show(); } }});
                mbuilder.setView(mview);
              AlertDialog dialog=mbuilder.create(); dialog.show(); }
        }); }
        public void show(View view) { AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this); builder.setCancelable(true);
         builder.setPositiveButton("OK",null);builder.setView(listView);AlertDialog dialog=builder.create();
         dialog.show(); }}