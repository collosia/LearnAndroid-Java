package com.example.learnapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    Context context;
    List<Contacts> contactsList;
    RecyclerView rvPrograms;
    Uri uri = Uri.parse("http://www.google.com");

    final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowId;
        TextView rowName;
        TextView rowEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowId = itemView.findViewById(R.id.item_id);
            rowName = itemView.findViewById(R.id.item_name);
            rowEmail = itemView.findViewById(R.id.item_email);
        }
    }

    public ContactsAdapter(Context context, List<Contacts> contactsList, RecyclerView rvPrograms){
        this.context = context;
        this.contactsList = contactsList;
        this.rvPrograms = rvPrograms;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, viewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int i) {
        Contacts contact = contactsList.get(i);
        viewHolder.rowId.setText(""+contact.getId());
        viewHolder.rowName.setText(contact.getName());
        viewHolder.rowEmail.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvPrograms.getChildLayoutPosition(v);
            String item = contactsList.get(itemPosition).getName();

            if(itemPosition == 0){
                uri = Uri.parse("https://www.udacity.com/course/android-basics-user-interface--ud834");

            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if (itemPosition == 1){
                uri = Uri.parse("https://www.udacity.com/course/android-basics-user-input--ud836");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 2){
                uri = Uri.parse("https://www.udacity.com/course/android-basics-multiscreen-apps--ud839");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 3){
                uri = Uri.parse("https://www.udacity.com/course/android-basics-networking--ud843");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 4){
                uri = Uri.parse("https://www.udacity.com/course/android-basics-data-storage--ud845");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 5){
                uri = Uri.parse("https://www.udacity.com/course/new-android-fundamentals--ud851 ");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 6){
                uri = Uri.parse("https://www.udacity.com/course/advanced-android-app-development--ud855");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 7){
                uri = Uri.parse("https://www.udacity.com/course/firebase-in-a-weekend-by-google-android--ud0352");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }

            if(itemPosition == 8){
                uri = Uri.parse("https://www.udacity.com/course/material-design-for-android-developers--ud862");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);
            }


        }


    }
}
