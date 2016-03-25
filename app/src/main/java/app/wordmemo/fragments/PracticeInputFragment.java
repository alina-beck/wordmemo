package app.wordmemo.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.wordmemo.R;
import app.wordmemo.databinding.FragmentPracticeInputBinding;
import app.wordmemo.models.Word;

public class PracticeInputFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private OnFragmentInteractionListener mListener;
    private Word currentWord;

    public PracticeInputFragment() {
        // Required empty public constructor
    }

    public static PracticeInputFragment newInstance (Word currentWord) {
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

        FragmentPracticeInputBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_practice_input, container, false);
        binding.setCurrentWord(currentWord);

        View view = binding.getRoot(); // TODO: do more with view (buttons...)

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
