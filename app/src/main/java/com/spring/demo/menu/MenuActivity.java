package com.spring.demo.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.spring.demo.R;
import com.spring.demo.beans.BeanActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnCallWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    private void init() {
        btnCallWS = (Button)findViewById(R.id.btn_call_service);
        btnCallWS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, BeanActivity.class);
                startActivity(intent);
            }
        });
    }
}
