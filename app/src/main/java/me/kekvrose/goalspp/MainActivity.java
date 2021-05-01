package me.kekvrose.goalspp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    int g1=0,g2=0;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.goalt1);
        Button bt2 = findViewById(R.id.goalt2);
        Button br = findViewById(R.id.goalreset);
        t1 = findViewById(R.id.textgc1);
        t2 = findViewById(R.id.textgc2);


        setTexter();

        bt1.setOnClickListener(t-> {
            g1 += 1;
            setTexter();

        });
        bt2.setOnClickListener(t-> {
            g2 += 1;
            setTexter();
        });

        br.setOnClickListener(t->{
            g1=0;g2=0;
            setTexter();
        });
        FloatingActionButton bg = findViewById(R.id.floatingActionButton);

        bg.setOnClickListener(t->{
            Vibrator v = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(VibrationEffect.createOneShot(100,255));
            if(g1==g2){
                Toast.makeText(getApplicationContext(),R.string.td,Toast.LENGTH_SHORT).show();
            }else if (g1>g2){
                Toast.makeText(getApplicationContext(),R.string.t1w,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),R.string.t2w,Toast.LENGTH_LONG).show();
            }

            //just reset it, but it will keep showing
            g1=0;g2=0;
        });

    }
    private void setTexter(){
        t1.setText(String.format(getString(R.string.gc1),g1));
        t2.setText(String.format(getString(R.string.gc2),g2));
    }
}