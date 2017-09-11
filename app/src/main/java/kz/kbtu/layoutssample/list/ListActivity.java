package kz.kbtu.layoutssample.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import kz.kbtu.layoutssample.R;

public class ListActivity extends AppCompatActivity {

    List<Contacts> contactsList = new ArrayList<>();
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        List<Contacts> contactsList = new ArrayList<>();
        for (int i=0; i<20; i++){
            Contacts contacts = new Contacts();
            contacts.setName("Name "+i);
            contacts.setPhone("8777 777 77 7"+i);
            contactsList.add(contacts);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        listAdapter = new ListAdapter(this, contactsList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
    }


    public void click(View v){
        for (int i=3; i<6; i++){
            Contacts contacts = new Contacts();
            contacts.setName("Name "+i);
            contacts.setPhone("Hello world Hello world Hello world Hello world Hello world Hello world Hello world Hello world");
            contactsList.add(contacts);
        }

        listAdapter.notifyItemInserted(3);
        contactsList.remove(0);
        listAdapter.notifyItemRemoved(0);
    }
}
