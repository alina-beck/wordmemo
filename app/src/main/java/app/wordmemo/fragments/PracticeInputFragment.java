package app.wordmemo.fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.wordmemo.R;
import app.wordmemo.databinding.FragmentPracticeInputBinding;
import app.wordmemo.models.Word;
import app.wordmemo.utils.BindableString;

public class PracticeInputFragment extends Fragment
        implements View.OnClickListener, TextView.OnEditorActionListener {
    private OnSubmitUserTranslationListener callback;
    private static final String ARG_PARAM1 = "param1";
    private FragmentPracticeInputBinding binding;
    private Word currentWord;
    private Context context;

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
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        callback = (OnSubmitUserTranslationListener) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity.getBaseContext();
        callback = (OnSubmitUserTranslationListener) activity;
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

        binding.setBoundCurrentWord(currentWord);
        binding.setBoundUserTranslation(new BindableString());

        View view = binding.getRoot();

        Button button = (Button) view.findViewById(R.id.button_submit_translation);
        button.setOnClickListener(this);

        EditText editText = (EditText) view.findViewById(R.id.input_user_translation);
        editText.setOnEditorActionListener(this);

        return view;
    }

    @Override
    public void onClick (View view) {
        // hide the keyboard
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(binding.getRoot().getWindowToken(), 0);

        checkUserTranslation();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean isHandled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            onClick(v);
            isHandled = true;
        }
        return isHandled;
    }

    public void checkUserTranslation () {
        String userTranslationLC = binding.getBoundUserTranslation().get();
        String correctTranslationLC = currentWord.getTranslation();

        boolean isTranslationCorrect = userTranslationLC.equalsIgnoreCase(correctTranslationLC);

        callback.onSubmitUserTranslation(isTranslationCorrect);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}
