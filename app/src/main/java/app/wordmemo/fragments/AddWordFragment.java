package app.wordmemo.fragments;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import app.wordmemo.R;
import app.wordmemo.databinding.FragmentAddWordBinding;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;
import app.wordmemo.utils.BindableString;

public class AddWordFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private FragmentAddWordBinding binding;
    private OnSaveWord callback;

    public AddWordFragment() {

    }

    public interface OnSaveWord {
        void onSaveWord();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        callback = (OnSaveWord) context;
    }

    // deprecated method, included to support APIs before 23
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
        callback = (OnSaveWord) activity;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_word, container, false);

        binding.setBoundInputOriginal(new BindableString());
        binding.setBoundInputTranslation(new BindableString());

        View view = binding.getRoot();

        Button button = (Button) view.findViewById(R.id.button_save_word);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        WordDAO wd = WordDAO.getInstance(context);
        wd.open();

        String originalInput = binding.getBoundInputOriginal().get();
        String translationInput = binding.getBoundInputTranslation().get();

        Word word = new Word(originalInput, translationInput);

        if (wd.insertWord(word)) {
            Toast.makeText(context, "entry saved", Toast.LENGTH_LONG).show();
        }
        wd.close();

        callback.onSaveWord();

    }
}