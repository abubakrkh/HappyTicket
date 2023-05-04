package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ticketNumberIn;
    private TextView ticketNumberOut;
    private Button button;
    private String ticketNumber = "";

    Algorithm algorithm = new Algorithm();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticketNumberIn = findViewById(R.id.editText);
        ticketNumberOut = findViewById(R.id.textout);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ticketNumber = ticketNumberIn.getText().toString();

            if (algorithm.isHappyTicket(ticketNumber)) {
                ticketNumberOut.setText("Этот билет счастливый");
            } else {
                ticketNumberOut.setText(String.format("Данный билет не является счастливым, следующим счасливым билетом будет %d", algorithm.nextHappyTicket(ticketNumber)));
            }
        }
    };
}
