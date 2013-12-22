package in.ac.dtu.engifest.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.cardsui.Card;
import com.afollestad.cardsui.CardAdapter;
import com.afollestad.cardsui.CardHeader;
import com.afollestad.cardsui.CardListView;

import in.ac.dtu.engifest.MainActivity;
import in.ac.dtu.engifest.R;

/**
 * Created by omerjerk on 19/12/13.
 */
public class NewsFragment extends Fragment {


    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsFragment newInstance(int sectionNumber) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        CardListView newsList = (CardListView)rootView.findViewById(android.R.id.list);
        CardAdapter adapter = new CardAdapter(getActivity())
                // This sets the color displayed for card titles and header actions by default
                .setAccentColorRes(android.R.color.holo_blue_dark);

        adapter.add(new CardHeader("Header 1"));
        adapter.add(new Card("One", "Example 1"));
        adapter.add(new Card("Two", "Example 2"));
        adapter.add(new Card("Three", "Example 3"));
        // Add a header with a subtitle and action, along with 3 more cards below it
        adapter.add(new CardHeader("Header 2", "Subtitle 2").setAction("Hello", new CardHeader.ActionListener() {
            @Override
            public void onClick(CardHeader header) {
                Toast.makeText(getActivity(), header.getActionTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
        adapter.add(new Card("Four", "Example 4"));
        adapter.add(new Card("Five", "Example 5"));
        adapter.add(new Card("Six", "Example 6"));

        newsList.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    private class NewsViewAdapter extends BaseAdapter {

        public NewsViewAdapter(){

        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public int getCount(){
            return 5;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.row_news_list, null);
            }

            TextView tv = (TextView) convertView.findViewById(R.id.title_news);
            tv.setText("Fuck Yeah!"); // ofc it will be changed later

            return convertView;

        }
    }
}
