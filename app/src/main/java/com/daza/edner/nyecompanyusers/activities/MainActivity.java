package com.daza.edner.nyecompanyusers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.daza.edner.nyecompanyusers.R;
import com.daza.edner.nyecompanyusers.adapters.UserAdapter;
import com.daza.edner.nyecompanyusers.interfaces.OnUserClickListener;
import com.daza.edner.nyecompanyusers.interfaces.UserInterface;
import com.daza.edner.nyecompanyusers.models.User;
import com.daza.edner.nyecompanyusers.util.API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        recyclerView = findViewById(R.id.RecyclerViewMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManager = new LinearLayoutManager(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.56:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Override
    protected void onResume() {
        super.onResume();
        UserInterface service = API.getApi().create(UserInterface.class);

        Call<ArrayList<User>> callUsers = service.getUsers();

        callUsers.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                //Toast.makeText(MainActivity.this, "BIEN", Toast.LENGTH_SHORT).show();
                //List<User> users = response.body();
                fillList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                this.onResume();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fillList(ArrayList<User> users) {
        adapter = new UserAdapter(this, users, R.layout.card_view_items, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<User> getAllUsers() {
        return new ArrayList<User>(){{
            Long l = Long.valueOf(1);
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
            add(new User(l, "Roger Wallters", "rg@gmail.com", "23666", "3652254325", "direct", ""));
        }};
    }

    @Override
    public void onItemClick(User user, int position) {
        Toast.makeText(this, ""+ user.getName() + "  -   " + position, Toast.LENGTH_SHORT).show();
    }
}
