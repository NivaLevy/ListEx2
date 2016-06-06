package com.example.niva.listex2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<GroceriesObject> listItem, finalList;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finalList = new ArrayList<>();
        listView = (ListView) findViewById (R.id.listView) ; // Create the ArrayList that will allow us to fill the listView
        listItem = createList();

        adapter = new CustomAdapter(getApplicationContext(), R.layout.display_item, finalList);
        listView.setAdapter(adapter) ;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final GroceriesObject object = (GroceriesObject) listView.getItemAtPosition(position); // we create a dialog
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this); // a title we attribute to our dialog

                adb.setTitle("Select Item"); // inserting a message to our dialog, and here we show the under item clicked
                adb.setMessage("Remove: " + object.getTitle() + "?"); // we indicate that we want the ok button on our dialog
                adb.setCancelable(true);

                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finalList.remove(object);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


                AlertDialog alertDialog = adb.create();

                alertDialog.show();
            }
        });


        Spinner spinner = (Spinner)findViewById(R.id.spn);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String item = parentView.getItemAtPosition(position).toString();
                if (position == 0)
                    return;
                for (GroceriesObject object : finalList) {
                    if (object.getTitle().equals(item)) {
                        object.setAmount(object.getAmount() + 1);
                        adapter.notifyDataSetChanged();
                        return;
                    }
                }
                finalList.add(listItem.get(position - 1));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }


    ArrayList<GroceriesObject> createList() {
        ArrayList<GroceriesObject> listItem = new ArrayList<GroceriesObject> ( ) ;

        GroceriesObject object = null;

        object = new GroceriesObject("Apples", 1,(R.drawable.appleicon));
        listItem.add(object);

        object = new GroceriesObject("Aubergine", 1,(R.drawable.aubergineicon));
        listItem.add(object);

        object = new GroceriesObject("Bananas", 1,(R.drawable.bananasicon));
        listItem.add(object);

        object = new GroceriesObject("Strawberries",1,(R.drawable.strawberryicon));
        listItem.add(object);

        object = new GroceriesObject("Coconut", 1,(R.drawable.coconuticon));
        listItem.add(object);

        object = new GroceriesObject("Watermelon",1,(R.drawable.watermelonicon));
        listItem.add(object);

        object = new GroceriesObject("Cheese", 1,(R.drawable.cheeseicon));
        listItem.add(object);

        object = new GroceriesObject("Pepper", 1,(R.drawable.capsicumicon));
        listItem.add(object);

        object = new GroceriesObject("Orange", 1,(R.drawable.orangeicon));
        listItem.add(object);

        object = new GroceriesObject("Milk", 1,(R.drawable.milkicon));
        listItem.add(object);

        return listItem;
    }

}
