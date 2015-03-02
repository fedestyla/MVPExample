package com.monitisecreate.mvpexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.monitisecreate.mvpexample.presenter.ListPresenter;

import java.util.ArrayList;
import java.util.List;


public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> implements
        View.OnClickListener {

    private List<String> mListString = new ArrayList<>();
    private ListPresenter mListPresenter;

    public ListProductAdapter(ListPresenter listPresenter) {
        mListPresenter = listPresenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setPadding(24, 24, 24, 24);
        textView.setTextSize(20);
        textView.setClickable(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mListString.get(i));
        viewHolder.textView.setOnClickListener(this);
        viewHolder.textView.setTag(Integer.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }

    public void setList(List<String> list) {
        mListString = list;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        mListPresenter.onProductSelected(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
