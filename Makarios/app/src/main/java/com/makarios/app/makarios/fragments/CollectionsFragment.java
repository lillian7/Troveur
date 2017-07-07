package com.makarios.app.makarios.fragments;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.makarios.app.makarios.R;
import com.makarios.app.makarios.TouchListener;
import com.makarios.app.makarios.adapters.CollectionsAdapter;
import com.makarios.app.makarios.database.DatabaseManager;
import com.makarios.app.makarios.models.MyCollections;

import java.util.ArrayList;
import java.util.List;


public class CollectionsFragment extends Fragment {
    private static final String ARG_PAGE = "PAGE";
    private int mPage;
    private RecyclerView recyclerView;
    private List<MyCollections> myCollectionsList = new ArrayList<>();
    private CollectionsAdapter collectiosAdapter;
    private RelativeLayout emptyListLayout;
    private SwipeRefreshLayout swipeRefreshLayout;

    public CollectionsFragment() {
    }

    public static Fragment newInstance(int page) {
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_PAGE, page);
        Fragment fragment = new CollectionsFragment();
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

        emptyListLayout = (RelativeLayout) rootView.findViewById(R.id.emptyListLayout);

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout) ;
        recyclerView = (RecyclerView) rootView.findViewById(R.id.collectionL_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        collectiosAdapter = new CollectionsAdapter(getContext(), myCollectionsList, getActivity());
        recyclerView.setAdapter(collectiosAdapter);
        recyclerView.addOnItemTouchListener(new TouchListener(getContext(), recyclerView, new TouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new GetCollectionsTask().execute();
            }
        });
        return rootView;
    }

    private class GetCollectionsTask extends AsyncTask<Void, Void, List<MyCollections>> {
        public GetCollectionsTask() {}

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<MyCollections> collections) {
            super.onPostExecute(collections);
            if(collections.size() == 0){
                recyclerView.setVisibility(View.INVISIBLE);
                emptyListLayout.setVisibility(View.VISIBLE);
            }else{
                recyclerView.setVisibility(View.VISIBLE);
                emptyListLayout.setVisibility(View.INVISIBLE);
            }
            myCollectionsList.addAll(collections);
            collectiosAdapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);
        }

        @Override
        protected List<MyCollections> doInBackground(Void... params) {
            return DatabaseManager.getInstance().getCollections();
        }

    }
}
