package me.takimitsuha.rollingnumber;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Taki on 2017/1/25.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RollingNumberView tvTotalIncome = (RollingNumberView) findViewById(R.id.tv_total_income);
        tvTotalIncome.setText("12888888888.00", TextView.BufferType.NORMAL, new Handler());
    }
}
