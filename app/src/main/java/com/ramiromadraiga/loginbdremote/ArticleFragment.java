package com.ramiromadraiga.loginbdremote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by VASS on 30-05-2017.
 */

public class ArticleFragment extends Fragment {
    public static final String ARG_ARTICLES_NUMBER = "articles_number";

    public ArticleFragment() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_article, container, false);
        int i = getArguments().getInt(ARG_ARTICLES_NUMBER);
        String article = getResources().getStringArray(R.array.Tags)[i];

        getActivity().setTitle(article);
        TextView headline = (TextView) rootView.findViewById(R.id.headline);
        headline.append(" " + article);

        return rootView;
    }
}
