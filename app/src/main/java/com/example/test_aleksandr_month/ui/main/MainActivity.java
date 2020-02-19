package com.example.test_aleksandr_month.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.ui.skills.SkillsFragment;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_main);
        skills = findViewById(R.id.button_skills);


        setText();
        openSkills();
//        launch();

    }

    private void setText() {
        textView.setText("This part is in English to \n show my English language proficiency");
    }

//    private void launch() {
//        if (App.getPreference().getFirstLaunch()) {
////            App.getPreference().setFirstLaunch();
//            OnBoardActivity.start(this);
//        } else {
//            MainActivity.start(this);
//        }
//        finish();
//    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    private void openSkills() {
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, new SkillsFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
