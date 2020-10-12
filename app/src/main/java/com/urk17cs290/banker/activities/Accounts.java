package com.urk17cs290.banker.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.urk17cs290.banker.R;
import com.urk17cs290.banker.adapters.AccountAdapter;
import com.urk17cs290.banker.viewmodels.AccountViewModel;

public class Accounts extends AppCompatActivity {

    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        RecyclerView recyclerView = findViewById(R.id.accounts_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        final AccountAdapter adapter = new AccountAdapter();
        recyclerView.setAdapter(adapter);

        accountViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(AccountViewModel.class);

        //accountViewModel = new  ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AccountViewModel.class);
        accountViewModel.getAllAccounts().observe(this, adapter::setAccounts);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                accountViewModel.delete(adapter.getAccountAt(viewHolder.getAdapterPosition()));
                Toast.makeText(Accounts.this, "Account deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }
}
