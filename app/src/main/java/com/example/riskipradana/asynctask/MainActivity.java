package com.example.riskipradana.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String DEMO_ASYNC = "DemoAsync";
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tv_status);

        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute("Halo ini demo Asynctask");
    }

    private class DemoAsync extends AsyncTask<String, Void, String>{

        //UI Thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("Status : onPreExecute");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(DEMO_ASYNC, "status : doInBackground");
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                Log.d(DEMO_ASYNC, e.getMessage());
            }
            return strings[0];
        }
        //UI Thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvStatus.setText("status : onPostExecute : "+s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
