package com.example.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean first = true;
    private CheckBox check_hello;
    private CheckBox check_hi;
    private RadioGroup radio_group;
    private TextView radio_select_text, checkbox_select_text, loop_progress_text;
    private ProgressBar loop_progress_bar;
    private Button start_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radio_select_text = findViewById(R.id.radio_select_text);
        checkbox_select_text = findViewById(R.id.checkbox_select_text);
        check_hello = findViewById(R.id.check_hello);
        check_hi = findViewById(R.id.check_hi);
        loop_progress_bar = findViewById(R.id.loop_progress_bar);
        loop_progress_text = findViewById(R.id.loop_progress_text);
        start_button = findViewById(R.id.start_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loop_progress_bar.setProgress(0);
                loop_progress_text.setText("0%");
                for(int i=0; i<100; i++){
                    loop_progress_bar.setProgress(i);
                    loop_progress_text.setText(i+"%");
//                    SystemClock.sleep(100);
                }
            }
        });

        check_hello.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(check_hello.isChecked())
                    checkbox_select_text.setText("Hello is checked");
                else
                    checkbox_select_text.setText("Hello is unchecked");
            }
        });

        check_hi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(check_hi.isChecked())
                    checkbox_select_text.setText("Hi is checked");
                else
                    checkbox_select_text.setText("Hi is unchecked");
            }
        });

        radio_group = findViewById(R.id.radio_group);
        int checkedId = radio_group.getCheckedRadioButtonId();

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radio_hello) {
                    radio_select_text.setText("Hello radio is checked");
                }
                if (i == R.id.radio_hi)
                    radio_select_text.setText("Hi radio is checked");
                if (i == R.id.radio_bye)
                    radio_select_text.setText("Bye radio is checked");
            }
        });
    }

    public void on_button_click(View view) {
        TextView text = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        if (first){
            text.setText("Bye Sir");
            button.setText("Clicked");
        }
        else{
            text.setText("Hello Sir");
            button.setText("Click again");
        }
        first = !first;
    }

    public void onTimeChanged(String time){
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView clock = findViewById(R.id.clock);
        clock.setText(time);
        System.out.println(time);
    }
}
