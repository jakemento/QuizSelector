package jws.quizselector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.reflect.Array;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    String false_text = "false";
    String true_text = "true";
    String correct_text = "Correct!";
    String wrong_text = "Wrong!";
    private int userScore = 0;

    @Bind(R.id.questionTextView) TextView mQuestionTextView;
    @Bind(R.id.false_button) Button mFalseButton;
    @Bind(R.id.true_button) Button mTrueButton;
    @Bind(R.id.nextButton) Button mNextButton;
    @Bind(R.id.backButton) Button mBackButton;
    @Bind(R.id.questionImage) ImageView mQuestionImageView;
    @Bind(R.id.returnButton) Button mReturnButton;
    @Bind(R.id.scoreTextView) TextView mScoreTextView;
    @Bind(R.id.moreInfoButton) Button mMoreInfoButton;


    private int[] drawables = new int[] {R.drawable.civilwar, R.drawable.worldwartwo, R.drawable.constitution, R.drawable.worldwarone};

    private String[] questionList = new String[] {"The Civil War was fought between the North and the South", "World War II ended in 1945", "The Constitution was Signed in 1745", "America joined world war I in 1917"};

    private Question[] mQuestionBank = new Question[] {
            new Question(questionList[0], true, drawables[0]),  new Question(questionList[1], true, drawables[1]), new Question(questionList[2], false, drawables[2]), new Question(questionList[3], true, drawables[3])
    };
    private int mCurrentIndex = 0;
    private int mImageIndex = mCurrentIndex;
    private boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
    private boolean answerIsFalse = mQuestionBank[mCurrentIndex].isAnswerFalse();
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFalseButton.setText(false_text);
        mTrueButton.setText(true_text);
        mBackButton.setText("<");
        mNextButton.setText(">");
        mBackButton.setVisibility(View.INVISIBLE);
        mQuestionImageView.setImageResource(drawables[mImageIndex]);
        mReturnButton.setVisibility(View.INVISIBLE);
        mScoreTextView.setText("Score: " + String.valueOf(userScore));
        mMoreInfoButton.setVisibility(View.INVISIBLE);
        mMoreInfoButton.setText("More Info");

        String question = mQuestionBank[mCurrentIndex].getTextResString();
        mQuestionTextView.setText(question);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                answerIsFalse = mQuestionBank[mCurrentIndex].isAnswerFalse();

                if (answerIsTrue) {
                    Toast.makeText(MainActivity.this, correct_text, Toast.LENGTH_LONG).show();

                    userScore+=1;
                }

                else {
                    Toast.makeText(MainActivity.this, wrong_text, Toast.LENGTH_LONG).show();
                    userScore-=1;
                    mMoreInfoButton.setVisibility(View.VISIBLE);
                }
                mScoreTextView.setText("Score: " + String.valueOf(userScore));
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                answerIsFalse = mQuestionBank[mCurrentIndex].isAnswerFalse();
//
                if (!answerIsFalse) {
                    Toast.makeText(MainActivity.this, wrong_text, Toast.LENGTH_LONG).show();
                    userScore -= 1;
                    mMoreInfoButton.setVisibility(View.VISIBLE);
                }

                if (answerIsFalse) {
                    Toast.makeText(MainActivity.this, correct_text, Toast.LENGTH_LONG).show();
                    userScore += 1;
                }

                mScoreTextView.setText("Score: " + String.valueOf(userScore));

            }
        });



        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoreInfoButton.setVisibility(View.INVISIBLE);

                if (mBackButton.getVisibility() == View.INVISIBLE){
                    mBackButton.setVisibility(View.VISIBLE);
                }
                mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
                String question = mQuestionBank[mCurrentIndex].getTextResString();
                mQuestionTextView.setText(question);

                if (mCurrentIndex == (mQuestionBank.length -1) % mQuestionBank.length ) {
                    mNextButton.setVisibility(View.INVISIBLE);
                    mReturnButton.setVisibility(View.VISIBLE);
                    mBackButton.setVisibility(View.VISIBLE);
                }
                if (mCurrentIndex == 0) {
                    mNextButton.setVisibility(View.VISIBLE);
                }

                mImageIndex = mCurrentIndex;
                mQuestionImageView.setImageResource(drawables[mImageIndex]);


            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoreInfoButton.setVisibility(View.INVISIBLE);
                mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;

                if (mCurrentIndex <= 0) {
                    mCurrentIndex = 0;
                    mBackButton.setVisibility(View.INVISIBLE);
                    mNextButton.setVisibility(View.VISIBLE);
                }
                String question = mQuestionBank[mCurrentIndex].getTextResString();
                mQuestionTextView.setText(question);
                mImageIndex = mCurrentIndex;
                mQuestionImageView.setImageResource(drawables[mImageIndex]);
            }
        });

        mReturnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        mMoreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                popupWindow.showAtLocation(mMoreInfoButton, Gravity.CENTER, 400, 400);
                 startActivity(new Intent(MainActivity.this, infoActivity.class));

            }
        });
    }
}
