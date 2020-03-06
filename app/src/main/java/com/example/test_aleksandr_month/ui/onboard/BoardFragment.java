package com.example.test_aleksandr_month.ui.onboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.test_aleksandr_month.R;
import com.example.test_aleksandr_month.ui.main.MainActivity;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class BoardFragment extends Fragment {

    private TextView board_text;
    private TextView board_title;
    private LottieAnimationView lottie1;
    private LottieAnimationView lottie2;
    private LottieAnimationView lottie3;
    private Typeface typeface;
    private Button board_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        super.onViewCreated(view, savedInstanceState);
        board_text = view.findViewById(R.id.board_text);
        board_title = view.findViewById(R.id.board_title);
        lottie1 = view.findViewById(R.id.anim1);
        lottie2 = view.findViewById(R.id.anim2);
        lottie3 = view.findViewById(R.id.anim3);
        board_button = view.findViewById(R.id.board_button);

        viewPagerScroll();
        startButton();

        return view;
    }

    private void viewPagerScroll() {
        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                lottie1.playAnimation();
                lottie2.setVisibility(View.INVISIBLE);
                lottie3.setVisibility(View.INVISIBLE);
                board_button.setVisibility(View.INVISIBLE);
                board_title.setText("Добро пожаловать, \nработодатель!");
                board_text.setText("В данном приложении вы узнаете об \n истории моей рабочей деятельности (CV)");
                break;
            case 1:
                lottie2.playAnimation();
                lottie3.setVisibility(View.INVISIBLE);
                lottie1.setVisibility(View.INVISIBLE);
                board_button.setVisibility(View.INVISIBLE);
                board_title.setText("Прошу не судить строго");
                board_text.setText("Скажу сразу, что сейчас я только \nначинаю свой путь в программировании.");
                break;
            case 2:
                lottie1.setVisibility(View.INVISIBLE);
                lottie2.setVisibility(View.INVISIBLE);
                lottie3.playAnimation();
                board_title.setText("Но все зависит от Вас!");
                board_text.setText("Я настроен очень позитивно " +
                        "\nна испытания и трудности," +
                        "\n и если вы готовы вложиться" +
                        "\n в нового сотрудника...");
                break;
        }
    }

    private void startButton() {
        board_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity parentActivity = getActivity();
                startActivity(new Intent(parentActivity, MainActivity.class));
                getActivity().overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                getActivity().finish();
            }
        });
    }
}
