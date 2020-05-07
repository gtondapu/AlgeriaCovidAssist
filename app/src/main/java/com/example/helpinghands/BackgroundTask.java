package com.example.helpinghands;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, String, String> {
    Context context;
    BackgroundTask(Context ctx) {
        this.context=ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String Organization_Name=strings[1];
        String Email_ID=strings[2];
        String Phone_Number=strings[3];
        String UserID=strings[4];
        String User_Password=strings[5];
        String Families=strings[6];
        String regURL="http://10.0.2.2/AndroidStudioProjects/Helpinghands/Helping_hands.php";
        if(type.equals("reg")) {
            try{
                URL url = new URL(regURL);
                try{
                    HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream= httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream, "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    String insert_data = URLEncoder.encode("Organization Name", "UTF-8") + "=" + URLEncoder.encode(Organization_Name, "UTF-8") +
                            "&" + URLEncoder.encode("Email ID", "UTF-8") + "=" + URLEncoder.encode(Email_ID, "UTF-8") +
                            "&" + URLEncoder.encode("Phone Number", "UTF-8") + "=" + URLEncoder.encode(Phone_Number, "UTF-8") +
                            "&" + URLEncoder.encode("EmailID", "UTF-8") + "=" + URLEncoder.encode(Email_ID, "UTF-8") +
                            "&" + URLEncoder.encode("UserPassword", "UTF-8") + "=" + URLEncoder.encode(User_Password, "UTF-8") +
                            "&" + URLEncoder.encode("No.of Families", "UTF-8") + "=" + URLEncoder.encode(Families, "UTF-8");
                    bufferedWriter.write(insert_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "ISO-8859-1");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result ="";
                    String line = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line=bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    result=stringBuilder.toString();
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG) .show();
        //super.onPostExecute(s);
    }
}
