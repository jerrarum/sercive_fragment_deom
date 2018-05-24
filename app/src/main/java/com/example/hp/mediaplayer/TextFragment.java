package com.example.hp.mediaplayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {


    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //reference the textview in layout .
        Intent intent = getActivity().getIntent();


            String message = intent.getStringExtra("text");

            // print message in textView in xml layout.
        setTextView(message);


    }

    // this method set text in text view .
    public void setTextView(String text){
        // refernce the textview in layout .
        TextView textView = (TextView) getActivity().findViewById(R.id.tv_displayer);
        textView.setText(text);
    }
}
