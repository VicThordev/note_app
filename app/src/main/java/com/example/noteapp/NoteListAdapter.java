package com.example.noteapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NoteListAdapter extends ListAdapter<Note, WritingAdapter> {
    private ArrayList<Note> mNote;
    private Context mContext;

    protected NoteListAdapter(@NonNull DiffUtil.ItemCallback<Note> diffCallback) {
        super(diffCallback);
    }

    protected NoteListAdapter(@NonNull AsyncDifferConfig<Note> config) {
        super(config);
    }


    @NonNull
    @Override
    public WritingAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WritingAdapter.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WritingAdapter holder, int position) {
        Note note = getItem(position);
        holder.bindTo(note);
    }

    static class WordDiff extends DiffUtil.ItemCallback<Note> {

        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull
                Note newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getInfo().equals(newItem.getInfo());
        }
    }
}