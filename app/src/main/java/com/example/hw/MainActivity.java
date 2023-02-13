package com.example.hw;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String[] ones = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private EditText mInputEditText;
    private TextView mResultTextView;
    private Button mConvertButton;

    public static String convert(int num) {
        if (num == 0) {
            return "zero";
        }
        String result = "";
        if (num >= 1000000000) {
            result += convert(num / 1000000000) + " billion ";
            num %= 1000000000;
        }
        if (num >= 1000000) {
            result += convert(num / 1000000) + " million ";
            num %= 1000000;
        }
        if (num >= 1000) {
            result += convert(num / 1000) + " thousand ";
            num %= 1000;
        }
        if (num >= 100) {
            result += convert(num / 100) + " hundred ";
            num %= 100;
        }
        if (num >= 20) {
            result += tens[num / 10] + " ";
            num %= 10;
        }
        result += ones[num];
        return result.trim();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputEditText = findViewById(R.id.input_edit_text);
        mResultTextView = findViewById(R.id.result_text_view);
        mConvertButton = findViewById(R.id.convert_button);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(mInputEditText.getText().toString());
                mResultTextView.setText(convert(num));
            }
        });
    }
}