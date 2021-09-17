package com.Cyris.kbc2020.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Cyris.kbc2020.Levels.PlayLevelGame;
import com.Cyris.kbc2020.R;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.LevelViewModel> {
    Context context;
    SharedPreferences preferences;
    int val=1;
    boolean soundOnOff=true;
    String language ="";
    public LevelAdapter(Context ctx,boolean sound,String lang){
         context = ctx;
         preferences = context.getSharedPreferences(context.getString(R.string.level_reached_preferences),Context.MODE_PRIVATE);
         val = preferences.getInt(context.getString(R.string.level_reached_preferences),1);
         soundOnOff = sound;
         language = lang;
    }

    @NonNull
    @Override
    public LevelViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.button_only,parent,false);
        LevelAdapter.LevelViewModel model = new LevelAdapter.LevelViewModel(view);
        return model;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewModel holder, final int position) {
        holder.level_button.setText("Level "+(position+1));
        holder.setIsRecyclable(false);
        if(val>position+1){

            holder.level_button.setClickable(true);
            holder.level_button.setBackground(context.getDrawable(R.drawable.correct_answer_button));
            holder.level_button.setTextColor(context.getColor(R.color.black));
            holder.level_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayLevelGame.class);
                    intent.putExtra(context.getString(R.string.select_language),language);
                    Log.i("language",language);
                    intent.putExtra(context.getString(R.string.sound_on_off),soundOnOff);
                    intent.putExtra(context.getString(R.string.level_to_play),position+1);
                    context.startActivity(intent);
                }
            });
        }
        if(val==position+1){
            holder.level_button.setClickable(true);
            holder.level_button.setBackground(context.getDrawable(R.drawable.wrong_answer_button));
            holder.level_button.setTextColor(context.getColor(R.color.green));
            holder.level_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayLevelGame.class);
                    intent.putExtra(context.getString(R.string.select_language),language);
                    Log.i("language",language);
                    intent.putExtra(context.getString(R.string.sound_on_off),soundOnOff);
                    intent.putExtra(context.getString(R.string.level_to_play),position+1);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 43;
    }

    public class LevelViewModel extends RecyclerView.ViewHolder {
        Button level_button;
        public LevelViewModel(@NonNull View itemView) {
            super(itemView);
            level_button = itemView.findViewById(R.id.level_button_play);
        }
    }



}
