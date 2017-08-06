package com.reis.furrymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void onClick_login(View view) {
        Intent nextActivity = new Intent(this, MasterActivity.class);
        startActivity(nextActivity);
    }
}
