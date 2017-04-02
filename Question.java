package jws.quizselector;

import android.media.Image;

/**
 * Created by JS on 4/1/17.
 */

public class Question {

    private String mTextResString;
    private boolean mAnswerTrue;

    private int mQuestionImage;

    public Question(String textResString, boolean answerTrue, int questionImage) {
        mTextResString = textResString;
        mAnswerTrue = answerTrue;
        mQuestionImage = questionImage;
    }

    public String getTextResString() {
        return mTextResString;
    }

    public void setTextResString(String textResString) {
        mTextResString = textResString;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public boolean isAnswerFalse() {
        return !mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public void setQuestionImage(int questionImage) {
        mQuestionImage = questionImage;
    }
}
