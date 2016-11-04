package actiknow.com.materialdesign.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import actiknow.com.materialdesign.R;
import actiknow.com.materialdesign.activity.SecondActivity;


public class DesignDemoRecyclerAdapter extends RecyclerView.Adapter<DesignDemoRecyclerAdapter.ViewHolder> {

    private List<String> mItems;
    public DesignDemoRecyclerAdapter (List<String> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from (viewGroup.getContext ()).inflate (R.layout.list_row, viewGroup, false);
        v.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Context context = view.getContext ();
                context.startActivity (new Intent (context, SecondActivity.class));
            }
        });

        return new ViewHolder (v);
    }

    @Override
    public void onBindViewHolder (ViewHolder viewHolder, int i) {
        String item = mItems.get (i);
        viewHolder.mTextView.setText (item);
    }
    @Override
    public int getItemCount () {
        return mItems.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;
        ViewHolder (View v) {
            super (v);
            mTextView = (TextView) v.findViewById (R.id.list_item);
        }
    }
}