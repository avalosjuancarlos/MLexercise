package com.example.avalo.mlexercise.cardissuers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.avalo.mlexercise.OnItemClickListener;
import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.models.CardIssuer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardIssuersAdapter extends RecyclerView.Adapter<CardIssuersAdapter.CardIssuerHolder> {

    private List<CardIssuer> mCardIssuers;
    private OnItemClickListener<CardIssuer> mItemClickListener;
    private Context mContext;

    public CardIssuersAdapter() {
        mCardIssuers = new ArrayList<>();
    }

    public CardIssuersAdapter(List<CardIssuer> cardIssuers) {
        mCardIssuers = cardIssuers;
    }

    @Override
    public CardIssuerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_issuers, parent, false);

        return new CardIssuerHolder(root);
    }

    @Override
    public void onBindViewHolder(CardIssuerHolder holder, int position) {
        CardIssuer cardIssuer = mCardIssuers.get(position);
        holder.bindCardIssuer(cardIssuer);
    }

    @Override
    public int getItemCount() {
        return mCardIssuers.size();
    }

    public void setItems(List<CardIssuer> items) {
        mCardIssuers = items;
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener<CardIssuer> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void clear() {
        mCardIssuers.clear();
        notifyDataSetChanged();
    }

    public class CardIssuerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.thumbnail)
        ImageView mThumbnail;

        @BindView(R.id.name)
        TextView mName;

        CardIssuer mCardIssuer;

        public CardIssuerHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindCardIssuer(CardIssuer cardIssuer) {
            mCardIssuer = cardIssuer;

            mName.setText(cardIssuer.getName());
            String urlThumbnail = cardIssuer.getThumbnail();

            if (!TextUtils.isEmpty(urlThumbnail)) {
                Glide.with(mContext)
                        .load(urlThumbnail)
                        .placeholder(R.mipmap.ic_launcher)
                        .dontAnimate()
                        .into(mThumbnail);
            } else {
                Glide.with(mContext)
                        .load(R.mipmap.ic_launcher)
                        .into(mThumbnail);
            }
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null)
                mItemClickListener.onItemClicked(getAdapterPosition(), mCardIssuer);
        }
    }
}
