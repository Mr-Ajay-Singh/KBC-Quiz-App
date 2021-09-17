package com.Cyris.kbc2020.HighScoreTop;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Cyris.kbc2020.AdapterClass.Level100Adapter;
import com.Cyris.kbc2020.R;
import com.Cyris.kbc2020.topscore.FirebaseVariable;
import com.Cyris.kbc2020.topscore.TopEntity;
import com.Cyris.kbc2020.topscore.TopScoreAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Level100#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Level100 extends Fragment {

    FirebaseDatabase database;
    DatabaseReference databaseReference,dr1,dr2;
    private RecyclerView recyclerView;
    List<String> topList;
    Level100Adapter adapter;
    LinearLayout progressLoadingLayout;
    LinearLayout networkConnection,noRecord;
    final SimpleDateFormat timeStampFormat = new SimpleDateFormat("MMyyyy");
    Date todayDate = new Date();
    final String cur = timeStampFormat.format(todayDate);

    public Level100() {
        // Required empty public constructor
    }


    public static Level100 newInstance(String param1, String param2) {
        Level100 fragment = new Level100();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        topList = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_daily_top, container, false);
        networkConnection = view.findViewById(R.id.no_internet_connection);
        noRecord = view.findViewById(R.id.no_item);
        progressLoadingLayout = view.findViewById(R.id.progress_loading_layout);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Level100");
        dr1 = database.getReference("TopScore");
        dr2 = database.getReference("TopScoreUpdate");
        recyclerView = view.findViewById(R.id.recyclerview_in_daily_top);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Level100Adapter(getContext(),topList,noRecord);
        recyclerView.setAdapter(adapter);
        return view;
    }

    Date date;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStart() {
        super.onStart();

        //databaseReference.removeValue();
          dr1.removeValue();
          dr2.removeValue();


        if(!isNetworkAvailable())
            networkConnection.setVisibility(View.VISIBLE);
        databaseReference.child(cur).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("entityCheck", String.valueOf(dataSnapshot.getChildrenCount()));
               for (DataSnapshot snapshot:dataSnapshot.getChildren()) {

                    String name = snapshot.getValue().toString();
                    try {
                        Log.i("name",name);
                            topList.add(name);
                    } catch (Exception e)
                    {
                        Log.i("entityCheck", e+" error");
                    }

                }
                progressLoadingLayout.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private boolean isNetworkAvailable() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}