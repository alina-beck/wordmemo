package app.wordmemo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.wordmemo.R;

public class PracticeDoneFragment extends android.app.Fragment {

    public PracticeDoneFragment () {

    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
    }

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_practice_done, container, false);
    }

    @Override
    public void onDetach () {
        super.onDetach();
    }

}
