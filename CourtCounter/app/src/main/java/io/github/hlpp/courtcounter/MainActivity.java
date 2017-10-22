package io.github.hlpp.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeForTeamA(View view) {
        scoreTeamA += 3;
        displayScoreTeamA();
    }

    public void addTwoForTeamA(View view) {
        scoreTeamA += 2;
        displayScoreTeamA();
    }

    public void addOneForTeamA(View view) {
        scoreTeamA += 1;
        displayScoreTeamA();
    }

    public void addThreeForTeamB(View view) {
        scoreTeamB += 3;
        displayScoreTeamB();
    }

    public void addTwoForTeamB(View view) {
        scoreTeamB += 2;
        displayScoreTeamB();
    }

    public void addOneForTeamB(View view) {
        scoreTeamB += 1;
        displayScoreTeamB();
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA();
        displayScoreTeamB();
    }

    private void displayScoreTeamA() {
        TextView textView = (TextView)findViewById(R.id.team_a_score);
        textView.setText("" + scoreTeamA);
    }

    private void displayScoreTeamB() {
        TextView textView = (TextView)findViewById(R.id.team_b_score);
        textView.setText("" + scoreTeamB);
    }
}
