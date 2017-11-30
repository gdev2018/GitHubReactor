package org.gdev2018.githubreactor.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.gdev2018.githubreactor.data.model.Repository;

/**
 * Created by Miroslaw Stanek on 11.06.2016.
 * 2017-11-30 Updated by gdev2018
 */
public abstract class RepositoryViewHolder extends RecyclerView.ViewHolder {
    public RepositoryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Repository repository);
}
