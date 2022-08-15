package charlesgodoy.spellcheez;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import charlesgodoy.spellcheez.helper.QuestionHelper;
import charlesgodoy.spellcheez.model.QuestionModel;
import charlesgodoy.spellcheez.util.Constants;
import charlesgodoy.spellcheez.util.SharedPref;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private ConstraintLayout cl_root;
    private ImageView iv_question;
    private TextView tvOne, tvTwo, tvThree, tvFour;
    private TextView tvScore;
    private CardView cvOne, cvTwo, cvThree, cvFour;
    private List<QuestionModel> list = new ArrayList<>();

    private int currentQuestionPosition = 0;

    private int mScore = 0;
    private int mPoint = 1;

    private SharedPref prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        prefs = new SharedPref(mContext);
        initList();
        initViews();

        startSpellCheez();
    }

    private void initList() {
        list.clear();
        list = QuestionHelper.getQuestionsList();
    }

    private void startSpellCheez() {
        resetButtonColors();
        setQuestionAndChoices();
        setChoicesActions();
    }

    private void resetButtonColors() {
        cvOne.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tvOne.setBackgroundColor(getResources().getColor(R.color.purple_500));

        cvTwo.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tvTwo.setBackgroundColor(getResources().getColor(R.color.purple_500));

        cvThree.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tvThree.setBackgroundColor(getResources().getColor(R.color.purple_500));

        cvFour.setBackgroundColor(getResources().getColor(R.color.purple_500));
        tvFour.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    private void setQuestionAndChoices() {
        //Set Question and choices
        QuestionModel question = list.get(currentQuestionPosition);
        iv_question.setImageResource(question.getImage());
        iv_question.setTag(question.getCorrectAnswer());
        Log.d("caz", "setQuestionAndChoices: setTag = " + iv_question.getTag());

        tvOne.setText(question.getChoiceOne());
        tvTwo.setText(question.getChoiceTwo());
        tvThree.setText(question.getChoiceThree());
        tvFour.setText(question.getChoiceFour());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setChoicesActions() {
        cvOne.setOnClickListener(v -> {
            String answer = tvOne.getText().toString();
            String correctAnswer = iv_question.getTag().toString();
            validateAnswer(answer, correctAnswer);
        });
        cvTwo.setOnClickListener(v -> {
            String answer = tvTwo.getText().toString();
            String correctAnswer = iv_question.getTag().toString();
            validateAnswer(answer, correctAnswer);
        });
        cvThree.setOnClickListener(v -> {
            String answer = tvThree.getText().toString();
            String correctAnswer = iv_question.getTag().toString();
            validateAnswer(answer, correctAnswer);
        });
        cvFour.setOnClickListener(v -> {
            String answer = tvFour.getText().toString();
            String correctAnswer = iv_question.getTag().toString();
            validateAnswer(answer, correctAnswer);
        });
    }

    private void validateAnswer(String answer, String correctAnswer) {

        Log.d("caz", "validateAnswer method has been called");
        Log.d("caz", "user chose: " + answer);
        Log.d("caz", "correct answer is: " + correctAnswer);

        Log.d("caz", "currentQuestionPosition = " + currentQuestionPosition);
        Log.d("caz", "list.size() - 1 = " + (list.size() - 1));

        if (currentQuestionPosition == (list.size() - 1)) {

            Log.d("caz", "checking current question position to see if it equals list.size() -1");

            if (answer.equals(correctAnswer)) {

                Log.d("caz", "comparing user answer to correct answer");

                showMessage("Correct Answer");
                mScore += mPoint;
                highlightCorrect(correctAnswer);
                updateScore();
            } else {

                Log.d("caz", "user DID NOT choose correct answer");
                highlightCorrect(correctAnswer);
                highlightError(answer);
                showMessage("Wrong Answer");
            }

            //Store the final score in shared preference
            prefs.setInt(Constants.KEY_SCORE, mScore);

            int perfectScore = mPoint * list.size();
            boolean isPerfect = mScore == perfectScore;
            goToResultActivity(isPerfect);
        } else {

            Log.d("caz", "ENTERING ELSE - checking current question position to see if it equals list.size() -1");

            if (answer.equals(correctAnswer)) {

                Log.d("caz", "ELSE IF - user selected right answer ");

                showMessage("Correct Answer");
                mScore += mPoint;
                highlightCorrect(correctAnswer);
                updateScore();
            } else {

                Log.d("caz", "ELSE - user selected wrong answer ");
                highlightCorrect(correctAnswer);
                highlightError(answer);
                showMessage("Wrong Answer");
            }
            currentQuestionPosition++;
            new Handler(Looper.getMainLooper()).postDelayed(this::startSpellCheez, 1500);
        }
    }

    private void highlightError(String answer) {
        Log.d("caz", "entering highlightError method");
        if (tvOne.getText().toString() == answer) {
            cvOne.setBackgroundColor(getResources().getColor(R.color.red));
            tvOne.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (tvTwo.getText().toString() == answer) {
            cvTwo.setBackgroundColor(getResources().getColor(R.color.red));
            tvTwo.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (tvThree.getText().toString() == answer) {
            cvThree.setBackgroundColor(getResources().getColor(R.color.red));
            tvThree.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if (tvFour.getText().toString() == answer) {
            cvFour.setBackgroundColor(getResources().getColor(R.color.red));
            tvFour.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }

    private void highlightCorrect(String correctAnswer) {
        Log.d("caz", "entering highlightCorrect method");
        if (tvOne.getText().toString() == correctAnswer) {
            cvOne.setBackgroundColor(getResources().getColor(R.color.green));
            tvOne.setBackgroundColor(getResources().getColor(R.color.green));
        }
        if (tvTwo.getText().toString() == correctAnswer) {
            cvTwo.setBackgroundColor(getResources().getColor(R.color.green));
            tvTwo.setBackgroundColor(getResources().getColor(R.color.green));
        }
        if (tvThree.getText().toString() == correctAnswer) {
            cvThree.setBackgroundColor(getResources().getColor(R.color.green));
            tvThree.setBackgroundColor(getResources().getColor(R.color.green));
        }
        if (tvFour.getText().toString() == correctAnswer) {
            cvFour.setBackgroundColor(getResources().getColor(R.color.green));
            tvFour.setBackgroundColor(getResources().getColor(R.color.green));
        }

    }

    private void goToResultActivity(boolean isPerfect) {
        Intent i = new Intent(mContext, SpellCheezResultActivity.class);
        i.putExtra("score", mScore);
        i.putExtra("perfect", isPerfect);
        startActivityForResult(i, 1);
    }

    private void updateScore() {
        String score = "Score: " + mScore;
        tvScore.setText(score);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            playAgain();
        }
    }

    private void playAgain() {
        initList();
        currentQuestionPosition = 0;
        mScore = 0;
        updateScore();
        startSpellCheez();
    }

    private void showMessage(String message) {
        Snackbar.make(cl_root, message, Snackbar.LENGTH_INDEFINITE).setDuration(1500).show();
    }

    private void initViews() {
        cl_root = findViewById(R.id.cl_root);
        iv_question = findViewById(R.id.imageView);

        tvScore = findViewById(R.id.tv_score);

        cvOne = findViewById(R.id.card_view_one);
        cvTwo = findViewById(R.id.card_view_two);
        cvThree = findViewById(R.id.card_view_three);
        cvFour = findViewById(R.id.card_view_four);

        tvOne = findViewById(R.id.text_view_one);
        tvTwo = findViewById(R.id.text_view_two);
        tvThree = findViewById(R.id.text_view_three);
        tvFour = findViewById(R.id.text_view_four);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}