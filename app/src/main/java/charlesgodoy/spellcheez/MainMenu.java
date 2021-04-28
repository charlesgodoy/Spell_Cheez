package charlesgodoy.spellcheez;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;

import charlesgodoy.spellcheez.util.Constants;
import charlesgodoy.spellcheez.util.SharedPref;

public class MainMenu extends AppCompatActivity {

    private Group scoreGroup;
    private TextView tvScore;
    private CardView cvStartGame;

    private Context mContext;
    private SharedPref prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        mContext = this;
        prefs = new SharedPref(mContext);
        initViews();

        int score = prefs.getInt(Constants.KEY_SCORE);

        if (score > 0) {
            scoreGroup.setVisibility(View.VISIBLE);
            tvScore.setText("Score: " + score);
        } else {
            scoreGroup.setVisibility(View.GONE);
            tvScore.setText("");
        }

        cvStartGame.setOnClickListener(v -> {
            startActivity(new Intent(mContext, MainActivity.class));
            finish();
        });
    }

    private void initViews() {
        scoreGroup = findViewById(R.id.group_score);
        tvScore = findViewById(R.id.tv_score);
        cvStartGame = findViewById(R.id.cv_start_game);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}