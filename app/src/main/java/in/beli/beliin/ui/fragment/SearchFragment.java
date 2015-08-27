package in.beli.beliin.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.beli.beliin.R;
import in.beli.beliin.ui.activity.SearchActivity;

public class SearchFragment extends BaseFragment {

    @Bind(R.id.action_bar) Toolbar toolbar;
    @Bind(R.id.list_item) RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((SearchActivity) getActivity()).setupToolbar(toolbar);

        recyclerView.setVisibility(View.GONE);
    }
}
