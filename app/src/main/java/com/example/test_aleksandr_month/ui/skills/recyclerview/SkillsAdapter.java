package com.example.test_aleksandr_month.ui.skills.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_aleksandr_month.R;

import java.util.ArrayList;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsViewHolder> {

    private ArrayList<String> data;

    public SkillsAdapter() {
        data = new ArrayList<>();
    }

    private void addText (String text) {
        data.add(text);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_holder_skills, parent, false);
        return new SkillsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewHolder holder, int position) {
        String text = data.get(position);
        holder.onBind(text);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
