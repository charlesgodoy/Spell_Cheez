package charlesgodoy.spellcheez;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
        setQuestionAndChoices();
        setChoicesActions();
    }

    private void setQuestionAndChoices() {
        //Set Question and choices
        QuestionModel question = list.get(currentQuestionPosition);
        iv_question.setImageResource(question.getImage());
        iv_question.setTag(question.getCorrectAnswer());

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
        if (currentQuestionPosition == (list.size() - 1)) {
            if (answer.equals(correctAnswer)) {
                showMessage("Correct Answer");
                mScore += mPoint;
                updateScore();
            } else {
                showMessage("Wrong Answer");
            }

            //Store the final score in shared preference
            prefs.setInt(Constants.KEY_SCORE, mScore);

            int perfectScore = mPoint * list.size();
            boolean isPerfect = mScore == perfectScore;
            goToResultActivity(isPerfect);
        } else {
            if (answer.equals(correctAnswer)) {
                showMessage("Correct Answer");
                mScore += mPoint;
                updateScore();
            } else {
                showMessage("Wrong Answer");
            }
            currentQuestionPosition++;
            new Handler(Looper.getMainLooper()).postDelayed(this::startSpellCheez, 2000);
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
        Snackbar.make(cl_root, message, Snackbar.LENGTH_SHORT).show();
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