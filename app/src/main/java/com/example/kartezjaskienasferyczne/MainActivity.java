package com.example.kartezjaskienasferyczne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    EditText ex,ey,ez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        ex=findViewById(R.id.ex);
        ey=findViewById(R.id.ey);
        ez=findViewById(R.id.ez);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x=0,y=0,z=0,r=0,HeLong=0,HeLat=0;
                tv.setText("");
                try{
                    x=Double.parseDouble(ex.getText().toString());
                    y=Double.parseDouble(ey.getText().toString());
                    z=Double.parseDouble(ez.getText().toString());

                    r=Math.sqrt(x*x+y*y+z*z);
                    HeLong=180/Math.PI*Math.atan2(x,y);
                    HeLat=180/Math.PI*Math.asin(z/r);
                    tv.setText("Współrzędne kartezjańskie (x,y,z)=("+x+","+y+","+z+")\r\n\r\n"+
                            "Współrzędne sferyczne\r\n"+
                            "Odległość obiektu [m, km, Au] r="+r+"\r\n"+
                            "Długość sferyczna wyrażona w stopniach\r\nHeLong="+HeLong+"\r\n"+
                            "Szerokość sferyczna wyrażona w stopniach\r\nHeLat="+HeLat);
                }catch (Exception blad){
                    Toast.makeText(MainActivity.this,blad.getMessage(),
                            Toast.LENGTH_LONG).show();
                }finally {
                    ex.setText("");
                    ey.setText("");
                    ez.setText("");
                }
            }
        });
    }
}