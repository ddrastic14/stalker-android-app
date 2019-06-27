package com.example.stalker.UserInterface;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stalker.R;
import com.example.stalker.adapters.ImageListRecyclerAdapter;

import java.util.ArrayList;

public class ImageListFragment extends Fragment implements ImageListRecyclerAdapter.ImageListRecyclerClickListener {

    private static final String TAG = "ImageListFragment";
    private static final int NUM_COLUMNS = 2;

    //widgets
    private RecyclerView mRecyclerView;


    //vars
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    private IProfile mIProfile;

    public ImageListFragment() {
        // Required empty public constructor
    }


    public static ImageListFragment newInstance() {
        return new ImageListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_list, container, false);
        mRecyclerView = view.findViewById(R.id.image_list_recyclerview);

        getImageResouces();
        initRecyclerview();

        return view;
    }

    private void getImageResouces(){
        mImageResources.add(R.drawable.darth_vader);
        mImageResources.add(R.drawable.iron_man);
        mImageResources.add(R.drawable.batman);
        mImageResources.add(R.drawable.yoda);
        mImageResources.add(R.drawable.captain_america);
        mImageResources.add(R.drawable.joker);

    }

    private void initRecyclerview(){
        ImageListRecyclerAdapter mAdapter = new ImageListRecyclerAdapter(getActivity(), mImageResources, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIProfile = (IProfile) getActivity();
    }

    @Override
    public void onImageSelected(int position) {
        mIProfile.onImageSelected(mImageResources.get(position));
    }
}
