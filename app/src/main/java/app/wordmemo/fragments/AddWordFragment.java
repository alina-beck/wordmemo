package app.wordmemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.wordmemo.R;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;

public class AddWordFragment extends Fragment implements View.OnClickListener {

    private Context context;

    public AddWordFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_word, container, false);

        Button b = (Button) v.findViewById(R.id.save_word_button);
        b.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        WordDAO wd = WordDAO.getInstance(context);
        wd.open();

        EditText etOriginal = (EditText) getView().findViewById(R.id.enter_original);
        EditText etTranslation = (EditText) getView().findViewById(R.id.enter_translation);

        Word word = new Word(etOriginal.getText().toString(), etTranslation.getText().toString());

        if (wd.insertWord(word)) {
            Toast.makeText(context, "entry saved", Toast.LENGTH_LONG).show();
        }
        wd.close();

    }
}