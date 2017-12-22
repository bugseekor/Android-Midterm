package com.example.spark1435.midterm;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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
        final View rootView = inflater.inflate(R.layout.fragment_second,
                container, false);
        Button button = (Button) rootView.findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                EditText nameEditText = (EditText) rootView.findViewById(R.id.nameEditText);
                EditText commentEditText = (EditText) rootView.findViewById(R.id.commentEditText);
                String name = nameEditText.getText().toString();
                String comment = commentEditText.getText().toString();
                String message = name + " - " + comment;
                Intent passdata_intent = new Intent(getActivity(), MainActivity.class);

                passdata_intent.putExtra("name", name);
                passdata_intent.putExtra("comment", comment);

                Toast.makeText(getActivity(), message,Toast.LENGTH_SHORT).show();

                getActivity().startActivity(passdata_intent);
            }
        });
        //return inflater.inflate(R.layout.fragment_second, container, false);
        return rootView;
    }


}
