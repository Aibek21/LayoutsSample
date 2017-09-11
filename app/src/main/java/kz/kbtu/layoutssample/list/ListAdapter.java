package kz.kbtu.layoutssample.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kz.kbtu.layoutssample.R;

/**
 * Created by aibekkuralbaev on 11.09.17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context mContext;
    List<Contacts> mContactsList;

    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public ListAdapter(Context context, List<Contacts> contactsList) {
        mContext = context;
        mContactsList = contactsList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewHolder", "Create");
        View view;
        if (viewType == FIRST) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            return new MyViewHolder(view);
        }

        view = LayoutInflater.from(mContext).inflate(R.layout.new_list_item, parent, false);

        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("ViewHolder", "Bind");

        if (getItemViewType(position) == FIRST) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            Contacts contact = mContactsList.get(position);
            viewHolder.setPosition(position);
            viewHolder.mName.setText(contact.getName());
            viewHolder.mPhone.setText(contact.getPhone());
        }
    }

    @Override
    public int getItemCount() {
        return mContactsList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1 )
            return SECOND;

        return FIRST;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mName;
        TextView mPhone;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPhone = (TextView) itemView.findViewById(R.id.phone);

            itemView.setOnClickListener(this);
        }


        public void setPosition(int position){
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, ContactDetailsActivity.class);
            intent.putExtra("contact", mContactsList.get(position));
            mContext.startActivity(intent);
        }
    }


    class SecondViewHolder extends RecyclerView.ViewHolder {


        public SecondViewHolder(View itemView) {
            super(itemView);
        }
    }

}
