/*
 * Copyright (c) 2020. Created by Rajasingh Samuel.
 */

package com.urk17cs290.banker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.urk17cs290.banker.R;
import com.urk17cs290.banker.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountHolder> {
    private List<Account> accounts = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public AccountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item, parent, false);
        return new AccountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountHolder holder, int position) {
        Account currentAccount = accounts.get(position);
        holder.textViewAccountName.setText(currentAccount.getAccountName());
        holder.textViewAccountNumber.setText(String.valueOf(currentAccount.getAccountNumber()));
        holder.textViewBalance.setText(String.valueOf(currentAccount.getBalance()));
        holder.textViewMobile.setText(String.valueOf(currentAccount.getMobileNumber()));
        holder.textViewEmail.setText(currentAccount.getEmail());
        holder.textViewAccountType.setText(currentAccount.getAccountType());

    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    public Account getAccountAt(int position) {
        return accounts.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Account account);
    }

    class AccountHolder extends RecyclerView.ViewHolder {
        private TextView textViewAccountName;
        private TextView textViewAccountNumber;
        private TextView textViewBalance;
        private TextView textViewEmail;
        private TextView textViewMobile;
        private TextView textViewAccountType;

        public AccountHolder(View itemView) {
            super(itemView);
            textViewAccountName = itemView.findViewById(R.id.text_view_account_name);
            textViewAccountNumber = itemView.findViewById(R.id.text_view_account_number);
            textViewBalance = itemView.findViewById(R.id.text_view_balance);
            textViewAccountType = itemView.findViewById(R.id.text_view_account_type);
            textViewEmail = itemView.findViewById(R.id.text_view_account_email);
            textViewMobile = itemView.findViewById(R.id.text_view_account_mobile);

            itemView.setOnClickListener(
                    v -> {
                        int position = getAdapterPosition();
                        if (listener != null && position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(accounts.get(position));
                        }
                    });
        }
    }
}
