package jws.quizselector;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
String text_question = "is portland weird?";
    String false_text = "false";
    String true_text = "true";
    String correct_text = "Correct!";
    String wrong_text = "Wrong!";
    @Bind(R.id.questionTextView) TextView mQuestionTextView;
    @Bind(R.id.false_button) Button mFalseButton;
    @Bind(R.id.true_button) Button mTrueButton;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mQuestionTextView.setText(text_question);
        mFalseButton.setText(false_text);
        mTrueButton.setText(true_text);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, correct_text, Toast.LENGTH_LONG).show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, wrong_text, Toast.LENGTH_LONG).show();
            }
        });

    }
}
