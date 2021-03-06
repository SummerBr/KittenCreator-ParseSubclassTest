package com.example.guest.parsetest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.parsetest.R;
import com.example.guest.parsetest.models.Kitten;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 12/8/15.
 */

public class KittenAdapter extends RecyclerView.Adapter<KittenAdapter.KittenViewHolder> {

    private List<Kitten> mKittens;
    private Context mContext;

    public KittenAdapter(Context context, List<Kitten> kittens) {
        mContext = context;
        mKittens = kittens;
    }

    @Override
    public KittenViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kitten_list_item, viewGroup, false);
        KittenViewHolder viewHolder = new KittenViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KittenViewHolder kittenViewHodler, int i) {
        kittenViewHodler.bindKitten(mKittens.get(i));
    }

    @Override
    public int getItemCount() {
        return mKittens.size();
    }

    public class KittenViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.birthdayTextView) TextView mBirthdayTextView;
        @Bind(R.id.ownerTextView) TextView mOwnerTextView;

        public KittenViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindKitten(Kitten kitten) {
            mNameTextView.setText(kitten.getName());
            mBirthdayTextView.setText(kitten.getBirthday());
            mOwnerTextView.setText(kitten.getOwner());
        }
    }
}
