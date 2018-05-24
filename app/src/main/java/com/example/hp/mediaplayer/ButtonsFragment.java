package com.example.hp.mediaplayer;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonsFragment extends Fragment {

    private Intent intent ;
    private Button firstButton ;
    private Button scondButton ;
    private Button thirdButton ;
    private String message ;
    public ButtonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }

    // this method put text in intent and starting intent .
    private void startIntent(String text){
        //create intent project .
        intent = new Intent(getActivity(),ForthActivity.class);
        intent.putExtra("text",text);
        startActivity(intent);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        // create references to buttons in xml layout .
        firstButton = (Button) getActivity().findViewById(R.id.bt_first);
        scondButton = (Button) getActivity().findViewById(R.id.bt_scond);
        thirdButton = (Button) getActivity().findViewById(R.id.bt_third);

        // if the user click first button .
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = " you clicked the first text";

                posteMessage(message);

            }
        });

        //if the user click scond button .
        scondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = "you clicked scond button here ";
                posteMessage(message);


            }
        });

        //if the user click third button .
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = "you clicked the third button ";

              posteMessage(message);
            }
        });
    }

    // this method checke  for device if in portrait mode .
    private boolean isPortraitMode(){
        return getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ;
    }

    // this method return true if device in landscaple mode .
    private boolean isLandScapeMode(){
        return ! isPortraitMode() ;
    }

    // this method take fragment  id and return fragment that have the id  .
    private Fragment getFragment(int fragmentId){

        return   getActivity().getSupportFragmentManager().findFragmentById(R.id.text_fragment_land);
    }

    // this method senf message to textFragment chosing prefect way .
    private void posteMessage(String message){
        if(isPortraitMode()){
            // starting intent
            startIntent(message);
        }else{
            TextFragment fragment = (TextFragment) getFragment(R.id.text_fragment_land);

            // set the textView in layout to message text .
            fragment.setTextView(message);
        }

    }
}
