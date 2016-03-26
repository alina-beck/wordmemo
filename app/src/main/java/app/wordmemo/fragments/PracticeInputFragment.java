package app.wordmemo.fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.wordmemo.R;
import app.wordmemo.databinding.FragmentPracticeInputBinding;
import app.wordmemo.models.Word;
import app.wordmemo.utils.BindableString;

public class PracticeInputFragment extends Fragment implements View.OnClickListener {
    private OnSubmitUserTranslationListener callback;
    private static final String ARG_PARAM1 = "param1";
    private FragmentPracticeInputBinding binding;
    private Word currentWord;

    public interface OnSubmitUserTranslationListener {
        void onSubmitUserTranslation(boolean isTranslationCorrect);
    }

    public PracticeInputFragment() {
        // Required empty public constructor
    }

    public static PracticeInputFragment getInstance(Word currentWord) {
        PracticeInputFragment fragment = new PracticeInputFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, currentWord);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            return; // no arguments given, show blank screen.
        }

        currentWord = getArguments().getParcelable(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_practice_input, container, false);

        binding.setCurrentWord(currentWord);
        binding.setUserTranslation(new BindableString());

        View view = binding.getRoot();

        Button button = (Button) view.findViewById(R.id.submit_user_translation);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (OnSubmitUserTranslationListener) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (OnSubmitUserTranslationListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onClick (View view) {
        checkUserTranslation();
    }

    public void checkUserTranslation () {
        String userTranslationLC = binding.getUserTranslation().get();
        String correctTranslationLC = currentWord.getTranslation();

        boolean isTranslationCorrect = userTranslationLC.equalsIgnoreCase(correctTranslationLC);

        callback.onSubmitUserTranslation(isTranslationCorrect);

    }
}
