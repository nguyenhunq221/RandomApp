package com.example.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button Btn_Random;
    EditText edittxt1,edittxt2;
    TextView txtRandom;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Btn_Random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation(imageView1,R.anim.rotate);

                String chuoi1=edittxt1.getText().toString();
                String chuoi2=edittxt2.getText().toString();
                if(chuoi1.length()==0 || chuoi2.length()==0){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập đủ số !",Toast.LENGTH_LONG).show();
                }

                else {
                    //ep kieu tu chuoi sang so
                    int min =Integer.parseInt(chuoi1);
                    int max=Integer.parseInt(chuoi2);
                    if(min>max){
                        Toast.makeText(MainActivity.this,"Vui lòng nhập số trên nhỏ hơn",Toast.LENGTH_LONG).show();
                    }
                    else {
                    Random random =new Random();
                    int number = random.nextInt(max-min+1)+min;
                    txtRandom.setText(String.valueOf(number));
                }}
            }
        });
    }
    private void AnhXa(){
        Btn_Random=(Button) findViewById(R.id.btn_random);
        edittxt1=(EditText)findViewById(R.id.edittxt1);
        edittxt2=(EditText) findViewById(R.id.edittxt2);
        imageView1=(ImageView) findViewById(R.id.imageview1);
        txtRandom=(TextView) findViewById(R.id.text_Random);
    }
    public void startAnimation(View view, int animId){
        Animation animation= AnimationUtils.loadAnimation(this, animId);
        view.startAnimation(animation);
    }
}