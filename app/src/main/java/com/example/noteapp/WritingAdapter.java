package com.example.noteapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class WritingAdapter extends RecyclerView.ViewHolder {
    private ArrayList<Note> mNote;
    private Context mContext;
    private onItemClickListener listener;
    Note note;
    Intent data;

    private TextView mInfo;
    private TextView mCategory;
    private TextView mDate;

    private WritingAdapter(View view) {
        super(view);
        mInfo=view.findViewById(R.id.info);
        mCategory=view.findViewById(R.id.category);
        mDate=view.findViewById(R.id.date);
    }

    static WritingAdapter create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new WritingAdapter(view);
    }

    /**public WritingAdapter(@NonNull View itemView, ArrayList<Note> mNote, Context mContext) {
        super(itemView);
        this.mNote = mNote;
        this.mContext = mContext;
    }*/

    void bindTo(Note note) {
        mInfo.setText(note.getInfo());
        note.setInfo(mInfo.toString());
        mCategory.setText(note.getCategory());
        note.setCategory(mCategory.toString());
        mDate.setText(note.getDate());
        note.setDate(mDate.getText().toString());
    }

    void bind(@NonNull WritingAdapter holder, int position) {
        Note note = mNote.get(position);
        String info = mNote.get(position).getInfo();
        String category = mNote.get(position).getCategory();
        String date = mNote.get(position).getDate();
        holder.mInfo.setText(info);
        holder.mCategory.setText(category);
        holder.mDate.setText(date);
        //holder.bindTo(note);
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        private TextView mInfo;
        private TextView mCategory;
        private TextView mDate;

        public TextView getmInfo() {
            return mInfo;
        }

        public TextView getmCategory() {
            return mCategory;
        }

        public TextView getmDate() {
            return mDate;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mInfo=itemView.findViewById(R.id.info);
            mCategory=itemView.findViewById(R.id.category);
            mDate=itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (listener != null && position !=
                        RecyclerView.NO_POSITION) {
                    listener.onItemClick(mNote.get(position));
                    String title = data.getStringExtra(WritingActivity.EXTRA_TITLE);
                    String category = data.getStringExtra(WritingActivity.EXTRA_CATEGORY);
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
                    String date = dateFormat.format(calendar.getTime());
                    note = new Note(title, category, date);
                    mNote.add(note);
                }
            });
        }



        @Override
        public void onClick(View view) {
            Note note = mNote.get(getAdapterPosition());
            Intent data = new Intent(mContext, WritingActivity.class);
            mContext.startActivity(data);
        }

    }


    public interface onItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
}


