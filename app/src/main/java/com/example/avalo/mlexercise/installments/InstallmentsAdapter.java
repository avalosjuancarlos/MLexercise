package com.example.avalo.mlexercise.installments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.avalo.mlexercise.OnItemClickListener;
import com.example.avalo.mlexercise.R;
import com.example.avalo.mlexercise.models.PayerCost;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstallmentsAdapter extends RecyclerView.Adapter<InstallmentsAdapter.PayerCostHolder> {

    private List<PayerCost> mPayerCosts;
    private OnItemClickListener<PayerCost> mItemClickListener;
    private Context mContext;

    public InstallmentsAdapter() {
        mPayerCosts = new ArrayList<>();
    }

    public InstallmentsAdapter(List<PayerCost> payerCosts) {
        mPayerCosts = payerCosts;
    }

    @Override
    public PayerCostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_installments, parent, false);

        return new PayerCostHolder(root);
    }

    @Override
    public void onBindViewHolder(PayerCostHolder holder, int position) {
        PayerCost payerCost = mPayerCosts.get(position);
        holder.bindPaymentCost(payerCost);
    }

    @Override
    public int getItemCount() {
        return mPayerCosts.size();
    }

    public void setItems(List<PayerCost> items) {
        mPayerCosts = items;
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener<PayerCost> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void clear() {
        mPayerCosts.clear();
        notifyDataSetChanged();
    }

    public class PayerCostHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.recommended_message)
        TextView mRecommendMessage;

        PayerCost mPaymentCost;

        public PayerCostHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindPaymentCost(PayerCost payerCost) {
            mPaymentCost = payerCost;

            mRecommendMessage.setText(payerCost.getRecommendedMessage());
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null)
                mItemClickListener.onItemClicked(getAdapterPosition(), mPaymentCost);
        }
    }
}
