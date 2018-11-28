package com.daza.edner.nyecompanyusers.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daza.edner.nyecompanyusers.R;
import com.daza.edner.nyecompanyusers.interfaces.OnUserClickListener;
import com.daza.edner.nyecompanyusers.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private ArrayList<User> users;
    private int layout;
    private OnUserClickListener onUserClickListener;
    private Context context;

    public UserAdapter(Context context, ArrayList<User> users, int layout, OnUserClickListener onUserClickListener) {
        this.context = context;
        this.users = users;
        this.layout = layout;
        this.onUserClickListener = onUserClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(this.layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(users.get(position), onUserClickListener);
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewUser;
        private TextView textViewUserName;
        private TextView textViewUserEmail;
        private TextView textViewUserPhone;
        private TextView textViewUserMobile;
        private TextView textViewUserPosition;
        private ImageView imageViewUserFoto;

        private ViewHolder (View v){
            super(v);
            this.imageViewUser = v.findViewById(R.id.ImageViewCardItem);
            this.textViewUserName = v.findViewById(R.id.TextViewCardItemName);
            this.textViewUserEmail = v.findViewById(R.id.TextViewCardItemEmail);
            this.textViewUserPhone = v.findViewById(R.id.TextViewCardItemPhone);
            this.textViewUserMobile = v.findViewById(R.id.TextViewCardItemMobile);
            this.textViewUserPosition = v.findViewById(R.id.TextViewCardItemPosition);
            this.imageViewUserFoto = v.findViewById(R.id.ImageViewCardItemFoto);
        }

        private void bind(final User user, final OnUserClickListener listener){
            this.textViewUserName.setText(user.getName());
            this.textViewUserEmail.setText(user.getEmail());
            this.textViewUserMobile.setText(user.getMobile());
            this.textViewUserPhone.setText(user.getPhone());
            this.textViewUserPosition.setText(user.getPosition());
            if(!user.getImage().isEmpty())
              Picasso.get().load(user.getImage()).fit().into(this.imageViewUserFoto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(user, getAdapterPosition());
                }
            });
        }
    }

}
