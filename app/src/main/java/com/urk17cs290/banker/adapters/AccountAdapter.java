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
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item, parent, false);
        return new AccountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountHolder holder, int position) {
        Account currentAccount = accounts.get(position);
        holder.textViewAccountName.setText(currentAccount.getUser());
        holder.textViewAccountNumber.setText(currentAccount.getAccount_number());
        holder.textViewBalance.setText(String.valueOf(currentAccount.getBalance()));
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

    class AccountHolder extends RecyclerView.ViewHolder {
        private TextView textViewAccountName;
        private TextView textViewAccountNumber;
        private TextView textViewBalance;

        public AccountHolder(View itemView) {
            super(itemView);
            textViewAccountName = itemView.findViewById(R.id.text_view_account_name);
            textViewAccountNumber = itemView.findViewById(R.id.text_view_account_number);
            textViewBalance = itemView.findViewById(R.id.text_view_balance);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(accounts.get(position));
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Account account);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
