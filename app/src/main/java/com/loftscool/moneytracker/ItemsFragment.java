package com.loftscool.moneytracker;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loftscool.moneytracker.api.Api;

import java.util.List;

import static com.loftscool.moneytracker.Item.TYPE_UNKNOWN;

public class ItemsFragment extends android.support.v4.app.Fragment{


    private ItemsAdapter adapter;
    private Api api;

    public static final String KEY_TYPE = "TYPE";

    private String type = TYPE_UNKNOWN;

    public static ItemsFragment createItemsFragment(String type) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.KEY_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getArguments().getString(KEY_TYPE, TYPE_UNKNOWN);

        if (type.equals(TYPE_UNKNOWN)) {
            throw new IllegalStateException("Unknown Fragment Type");
        }

        adapter = new ItemsAdapter();
        api = ((App) getActivity().getApplication()).getApi();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items,container,false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);


        loadItems();


        }
        private void loadItems() {

        new LoadItemsTask(new Handler(Looper.getMainLooper())
        {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ITEMS_LOADED:
                        adapter.setItems((List<Item>) msg.obj);
                        break;

                    case ITEMS_ERROR:
                        showError((String) msg.obj);
                        break;
                }
            }
        }).start();

    }

    private static final int ITEMS_LOADED = 0;
    private static final int ITEMS_ERROR = 1;

    private class LoadItemsTask implements Runnable {

        private Thread thread;
        private Handler handler;

        public LoadItemsTask(Handler handler) {
            thread = new Thread(this);
            this.handler = handler;
        }
        public void start() {
            thread.start();
        }

        @Override
        public void run() {
            try {
                List<Item> items = api.items(type).execute().body();
                handler.obtainMessage(ITEMS_LOADED,items).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
                handler.obtainMessage(ITEMS_ERROR, e.getMessage()).sendToTarget();
            }
        }
    }

    private void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }

    }

