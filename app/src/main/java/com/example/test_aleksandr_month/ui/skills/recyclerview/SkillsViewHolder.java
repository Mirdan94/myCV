package com.example.test_aleksandr_month.ui.skills.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_aleksandr_month.R;

public class SkillsViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public SkillsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.skills_textView);
    }

    public void onBind (String text) {
        textView.setText(text);
    }
}
