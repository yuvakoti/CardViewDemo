package koti.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Contact>list = new ArrayList<Contact>();
    int[] image_id ={R.drawable.jellyfish,R.drawable.koala,R.drawable.lighthouse,R.drawable.penguins,R.drawable.tulips};

    String[] name,email,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        mobile = getResources().getStringArray(R.array.person_mobile);
        int count =0;
        for (String Name: name)
        {
            Contact contact = new Contact(image_id[count],Name,email[count],mobile[count]);
            count++;
            list.add(contact);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        adapter= new ContactAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
