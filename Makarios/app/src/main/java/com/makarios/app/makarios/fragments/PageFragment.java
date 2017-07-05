package com.makarios.app.makarios.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makarios.app.makarios.R;


public class PageFragment extends Fragment {
    private static final String ARG_PAGE = "PAGE";
    private int mPage;

    //singleton implementation

    public PageFragment() {
    }

    public static Fragment newInstance(int page) {
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE, page);
        Fragment fragment = new PageFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collections, container, false);
        TextView labelText = (TextView) rootView.findViewById(R.id.default_text);
        labelText.setText(R.string.default_text_main);
        return rootView;
    }
}
