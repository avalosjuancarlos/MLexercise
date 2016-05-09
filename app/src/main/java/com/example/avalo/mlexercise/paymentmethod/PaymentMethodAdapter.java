package com.example.avalo.mlexercise.paymentmethod;

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
import com.example.avalo.mlexercise.models.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodHolder> {

    private List<PaymentMethod> mPaymentMethods;
    private OnItemClickListener<PaymentMethod> mItemClickListener;
    private Context mContext;

    public PaymentMethodAdapter() {
        mPaymentMethods = new ArrayList<>();
    }

    public PaymentMethodAdapter(List<PaymentMethod> paymentMethods) {
        mPaymentMethods = paymentMethods;
    }

    @Override
    public PaymentMethodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_payment_method, parent, false);

        return new PaymentMethodHolder(root);
    }

    @Override
    public void onBindViewHolder(PaymentMethodHolder holder, int position) {
        PaymentMethod paymentMethod = mPaymentMethods.get(position);
        holder.bindPaymentMethod(paymentMethod);
    }

    @Override
    public int getItemCount() {
        return mPaymentMethods.size();
    }

    public void setItems(List<PaymentMethod> items) {
        mPaymentMethods = items;
        notifyDataSetChanged();
    }

    public void setItemClickListener(OnItemClickListener<PaymentMethod> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void clear() {
        mPaymentMethods.clear();
        notifyDataSetChanged();
    }

    public class PaymentMethodHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.thumbnail)
        ImageView mThumbnail;

        @BindView(R.id.name)
        TextView mName;

        PaymentMethod mPaymentMethod;

        public PaymentMethodHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindPaymentMethod(PaymentMethod paymentMethod) {
            mPaymentMethod = paymentMethod;

            mName.setText(paymentMethod.getName());
            String urlThumbnail = paymentMethod.getThumbnail();

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
                mItemClickListener.onItemClicked(getAdapterPosition(), mPaymentMethod);
        }
    }
}

