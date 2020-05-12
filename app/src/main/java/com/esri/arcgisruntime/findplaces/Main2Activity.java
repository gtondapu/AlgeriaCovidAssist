package com.esri.arcgisruntime.findplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
    String filename="nwfile.txt";
    EditText loginUser ;
    EditText loginPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button  button=(Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
            }
        });

    }
    public String readFile(String file){
        loginUser = (EditText) findViewById(R.id.editUser);
        loginPass = (EditText) findViewById(R.id.editPass);
        String text="";
        String code="######";
        String ExCode="@@@@@@";
        String UserID = loginUser.getText().toString().trim();
        String Password = loginPass.getText().toString().trim();
        try{

            FileInputStream in = openFileInput(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
           // Toast.makeText(Main2Activity.this,"s"+sb+"n",Toast.LENGTH_SHORT).show();
            String st=sb.toString();
String x="N";
            String[] Users = st.split(ExCode);
            String[] UserData;
            for(int i=0;i<=Users.length;i++){
                String test=Users[i].toString();
                 UserData= test.split(code);
                 if(test.equals("")){
                     continue;
                 }else {
                     String reUser=UserData[3].toString().trim();
                     String rePass=UserData[4].toString().trim();
                     // Toast.makeText(Main2Activity.this,reUser,Toast.LENGTH_SHORT).show();
                     if(reUser.equals(UserID) && rePass.equals(Password)){
                         Intent intent=new Intent(getApplicationContext(),Main8Activity.class);
                         startActivity(intent);
                         Toast.makeText(Main2Activity.this,"succes Login",Toast.LENGTH_SHORT).show();
                         x="Y";
                         return "succes";

                     }
                 }

            }
            if(x=="N"){
                Toast.makeText(Main2Activity.this,"Invalid Login",Toast.LENGTH_SHORT).show();
            }


            inputStreamReader.close();
            //FileInputStream fis=openFileInput(file);
            //int size=fis.available();
            // byte[] buffer=new byte[size];
            //  fis.read();
            //   fis.close();
            //    text=new String(buffer);

        }catch (Exception e){
            e.printStackTrace();;
            Toast.makeText(Main2Activity.this,"error reading",Toast.LENGTH_SHORT).show();
        }
        return text;
    }
    public  void onButtonClicked(View v){
        readFile(filename);
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
        switch (item.getItemId()){
            case R.id.action_menu1:
                startActivity(new Intent(this,Main2Activity.class));
                return true;
            case R.id.action_menu2:
                startActivity(new Intent(this,MainActivity.class));
                return true;
            case R.id.subitem1:
                startActivity(new Intent(this,Main6Activity.class));
                return true;
            case R.id.subitem2:
                startActivity(new Intent(this,Main5Activity.class));
                return true;
            case R.id.subitem3:
                startActivity(new Intent(this,Main7Activity.class));
                return true;
            case R.id.action_menu3:
                startActivity(new Intent(this,Main3Activity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


}
