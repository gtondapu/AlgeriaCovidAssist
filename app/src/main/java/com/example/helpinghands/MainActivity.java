package com.example.helpinghands;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.ConnectivityManagerCompat;

import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button _btn_Register, _btn_Login;
    EditText _txt_Org_name, _txt_emailID, _txt_Phone_number, _txt_UserID, _txt_User_password, _txt_Families;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                String type = "reg";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(type, Organization_Name, Email_ID, Phone_Number, UserID, User_Password, Families);

            }
        });

    }
}
