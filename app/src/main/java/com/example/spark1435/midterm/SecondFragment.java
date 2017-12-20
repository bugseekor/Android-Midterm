package com.example.spark1435.midterm;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_second,
                container, false);
        Button button = (Button) rootView.findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), MainActivity.class);
                Intent passdata_intent = new Intent(getActivity(), MainActivity.class);
                passdata_intent.putExtra("name", "n");
                passdata_intent.putExtra("comment", "c");
                getActivity().startActivity(passdata_intent);
            }
        });
        //return inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;
    }


}
