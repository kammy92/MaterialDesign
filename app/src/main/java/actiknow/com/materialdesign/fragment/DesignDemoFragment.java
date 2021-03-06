package actiknow.com.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import actiknow.com.materialdesign.R;
import actiknow.com.materialdesign.adapter.DesignDemoRecyclerAdapter;

public class DesignDemoFragment extends Fragment {
    private static final String TAB_POSITION = "tab_position";

    public DesignDemoFragment () {

    }

    public static DesignDemoFragment newInstance (int tabPosition) {
        DesignDemoFragment fragment = new DesignDemoFragment ();
        Bundle args = new Bundle ();
        args.putInt (TAB_POSITION, tabPosition);
        fragment.setArguments (args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments ();
        int tabPosition = args.getInt (TAB_POSITION);

        ArrayList<String> items = new ArrayList<String> ();
        for (int i = 0; i < 50; i++) {
            items.add ("Tab #" + tabPosition + " item #" + i);
        }

        View v = inflater.inflate (R.layout.fragment_list_view, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById (R.id.recyclerview);
        recyclerView.setLayoutManager (new LinearLayoutManager (getActivity ()));
        recyclerView.setAdapter (new DesignDemoRecyclerAdapter (items));
/*
        recyclerView.addOnItemTouchListener (
                new RecyclerItemClickListener (getActivity (), new RecyclerItemClickListener.OnItemClickListener () {
                    @Override
                    public void onItemClick (View view, int position) {
                        Log.d ("Hello", "Item clicked : " + position);
                        // do whatever
                    }
                })
        );
*/
        return v;
    }
}