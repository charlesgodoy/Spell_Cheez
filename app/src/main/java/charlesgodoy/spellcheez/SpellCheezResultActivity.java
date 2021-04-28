package charlesgodoy.spellcheez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SpellCheezResultActivity extends AppCompatActivity {

    private TextView tvScore, tvPerfect;
    private CardView cvPlayAgain, cvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_cheez_result);

        initViews();
        displayResult();
        cvPlayAgain.setOnClickListener(v -> {
            Intent returnIntent = new Intent();
            setResult(RESULT_OK, returnIntent);
            finish();
        });
        cvExit.setOnClickListener(v -> {
            startActivity(new Intent(SpellCheezResultActivity.this, MainMenu.class));
            finish();
        });
    }

    private void displayResult() {
        Intent intent = getIntent();

        int score = intent.getIntExtra("score", 0);
        boolean isPerfect = intent.getBooleanExtra("perfect", false);

        String finalScore = "Score: " + score;
        tvScore.setText(finalScore);

        if (isPerfect) {
            tvPerfect.setVisibility(View.VISIBLE);
        } else {
            tvPerfect.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        tvScore = findViewById(R.id.tv_score);
        tvPerfect = findViewById(R.id.tv_perfect_score);
        cvPlayAgain = findViewById(R.id.cv_play_again);
        cvExit = findViewById(R.id.cv_exit);
    }
}