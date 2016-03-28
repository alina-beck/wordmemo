package app.wordmemo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.wordmemo.R;
import app.wordmemo.databinding.FragmentPracticeResultBinding;
import app.wordmemo.models.Word;

public class PracticeResultFragment extends Fragment implements View.OnClickListener{
    private ShowNextDueWord callback;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Word currentWord;
    private boolean isCorrect;

    public interface ShowNextDueWord {
        void showNextDueWord();
    }

    public PracticeResultFragment() {
        // required empty constructor
    }

    public static PracticeResultFragment getInstance (Word currentWord, boolean isCorrect) {
        PracticeResultFragment fragment = new PracticeResultFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, currentWord);
        args.putBoolean(ARG_PARAM2, isCorrect);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach(context);
        callback = (ShowNextDueWord) context;
    }

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);
        callback = (ShowNextDueWord) activity;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            return; // something went wrong
        }

        currentWord = getArguments().getParcelable(ARG_PARAM1);
        isCorrect = getArguments().getBoolean(ARG_PARAM2);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

        FragmentPracticeResultBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_practice_result, container, false);

        binding.setBoundCurrentWord(currentWord);

        View view = binding.getRoot();

        int resultColor;

        if (isCorrect) {
            resultColor = ContextCompat.getColor(getActivity().getBaseContext(), R.color.greenPrimary);
        }
        else {
            resultColor = ContextCompat.getColor(getActivity().getBaseContext(), R.color.redPrimary);
        }

        view.setBackgroundColor(resultColor);

        Button button = (Button) view.findViewById(R.id.button_continue_practice);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick (View view) {
        callback.showNextDueWord();
    }

    @Override
    public void onDetach () {
        super.onDetach();
        callback = null;
    }

}
