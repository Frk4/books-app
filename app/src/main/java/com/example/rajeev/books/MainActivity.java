package com.example.rajeev.books;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BookAdapter bookAdapter;
    private final String description = "This book provides a thorough review of the Android platform "+
    "including supported hardware devices, the structure of the Android development project and implementation of core services (wireless communication, data storage and other low.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Code to make editText indicator transparent
        EditText editText =(EditText) findViewById(R.id.search_edit_text);
        editText.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);

        ListView listView = (ListView) findViewById(R.id.books_list);

        ArrayList<Book> list = new ArrayList<Book>();
        // Dummy data code
        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));


        bookAdapter = new BookAdapter(this, list);
        listView.setAdapter(bookAdapter);

    }
}
