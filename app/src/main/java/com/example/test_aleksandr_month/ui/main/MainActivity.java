package com.example.test_aleksandr_month.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test_aleksandr_month.App;
import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.ui.onboard.BoardFragment;
import com.example.test_aleksandr_month.ui.onboard.OnBoardActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_main);
        setText();
//        launch();

    }

    private void setText(){
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
}
