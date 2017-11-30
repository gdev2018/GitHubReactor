package org.gdev2018.githubreactor.ui.adapter.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.auto.factory.AutoFactory;

import org.gdev2018.githubreactor.R;
import org.gdev2018.githubreactor.data.model.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Miroslaw Stanek on 11.06.2016.
 * 2017-11-30 Updated by gdev2018
 */
@AutoFactory(implementing = RepositoriesListViewHolderFactory.class)
public class RepositoryViewHolderBig extends RepositoryViewHolder {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvStars)
    TextView tvStars;
    @BindView(R.id.tvForks)
    TextView tvForks;

    public RepositoryViewHolderBig(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_big, parent, false));
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(Repository repository) {
        tvName.setText(repository.name);
        tvStars.setText("Stars: " + repository.stargazers_count);
        tvForks.setText("Forks: " + repository.forks_count);
    }
}
