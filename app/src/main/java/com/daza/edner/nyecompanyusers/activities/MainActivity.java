package com.daza.edner.nyecompanyusers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.daza.edner.nyecompanyusers.R;
import com.daza.edner.nyecompanyusers.adapters.UserAdapter;
import com.daza.edner.nyecompanyusers.interfaces.OnUserClickListener;
import com.daza.edner.nyecompanyusers.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnUserClickListener {

    private ArrayList<User> arrayListUsers;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayListUsers = getAllUsers();
        recyclerView = findViewById(R.id.RecyclerViewMain);
        layoutManager = new LinearLayoutManager(this);
        adapter = new UserAdapter(this, arrayListUsers, R.layout.card_view_items, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<User> getAllUsers() {
        return new ArrayList<User>(){{
            add(new User(1, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(2, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(3, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(4, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(5, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(6, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(7, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(8, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
            add(new User(9, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", R.drawable.users));
        }};
    }

    @Override
    public void onItemClick(User user, int position) {
        Toast.makeText(this, ""+ user.getName() + "  -   " + position, Toast.LENGTH_SHORT).show();
    }
}
