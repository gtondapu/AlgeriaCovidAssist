package com.esri.arcgisruntime.findplaces;

import android.content.Context;
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

import java.io.FileOutputStream;

public class Main4Activity extends AppCompatActivity {
    String filename="newfile.txt";
    Button _btn_Register, _btn_Login;
    EditText _txt_Org_name, _txt_emailID, _txt_Phone_number, _txt_UserID, _txt_User_password, _txt_Families;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _btn_Login = (Button) findViewById((R.id.btn_Login));
        _btn_Register = (Button) findViewById(R.id.btn_Register);
        _txt_Org_name = (EditText) findViewById(R.id.txt_Org_name);
        _txt_emailID = (EditText) findViewById(R.id.txt_emailID);
        _txt_Phone_number = (EditText) findViewById(R.id.txt_Phone_number);
        _txt_UserID = (EditText) findViewById(R.id.txt_UserID);
        _txt_User_password = (EditText) findViewById(R.id.txt_User_password);
        _txt_Families = (EditText) findViewById(R.id.txt_Families);
        _btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Organization_Name = _txt_Org_name.getText().toString();
                String Email_ID = _txt_emailID.getText().toString();
                String Phone_Number = _txt_Phone_number.getText().toString();
                String UserID = _txt_UserID.getText().toString();
                String User_Password = _txt_User_password.getText().toString();
                String Families = _txt_Families.getText().toString();
                String code="######";
                String ExCode="@@@@@@";
                String UserData=ExCode+code+Email_ID+code+Phone_Number+code+UserID+code+User_Password
                        +code+Families+code;
savefile(filename,UserData);
            }
        });
    }
    public  void savefile(String file,String text){
        //  File fil = new File(getFilesDir(), filename);


        try (FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND)) {
            fos.write(text.getBytes());

            //  FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
            //   fos.write(text.getBytes());
            //  fos.close();
            Toast.makeText(Main4Activity.this, "Saved" , Toast.LENGTH_SHORT).show();
        }


        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(Main4Activity.this,"Eror saving",Toast.LENGTH_SHORT).show();
        }
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
