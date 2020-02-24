package com.example.guessing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et=findViewById(R.id.et_input);
        final ImageButton button=findViewById(R.id.btn_check);
        final TextView tv_name=findViewById(R.id.tv_name);
        final ImageView iv_up=findViewById(R.id.iv_up);
        final ImageView iv_down=findViewById(R.id.iv_down);

        final int num= (int)(1+Math.random()*9999);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                button.setBackgroundResource(R.drawable.check2);
                iv_down.setBackgroundResource(R.drawable.down);
                iv_up.setBackgroundResource(R.drawable.up);
                iv_down.setVisibility(View.INVISIBLE);
                iv_up.setVisibility(View.INVISIBLE);
            }
        });


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                int real=Integer.parseInt(et.getText().toString());
                if(et.getText()!=null) {
                    button.setEnabled(true);
                    if(real==num){
                        //Scenario 1: input values are different from random values
                        tv_name.setText("You got it!");
                        et.setEnabled(false);
                        button.setBackgroundResource(R.drawable.right);
                        button.setEnabled(false);

                    }
                    if(real>num){
                        //Scenario 2: the input value is greater than the random value
                        iv_down.setBackgroundResource(R.drawable.down1);
                        iv_down.setVisibility(View.VISIBLE);
                        iv_up.setVisibility(View.INVISIBLE);
                        tv_name.setText("Lorem ipsum");
                        button.setBackgroundResource(R.drawable.wrong);

                    }
                    if(real<num){
                        //Scenario 3: the input value is less than the random value
                        iv_up.setBackgroundResource(R.drawable.up1);
                        iv_up.setVisibility(View.VISIBLE);
                        iv_down.setVisibility(View.INVISIBLE);
                        tv_name.setText("Lorem ipsum");
                        button.setBackgroundResource(R.drawable.wrong);

                    }
                }
                else{
                    //A popover should be set up here for the prompt
                    button.setEnabled(false);
                }
            }
        });
    }
}
