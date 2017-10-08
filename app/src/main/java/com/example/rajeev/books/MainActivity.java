package com.example.rajeev.books;

import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Book>> {
    public static final String API_KEY = "AIzaSyCtwsK5-xmfSwLIWQ7kDxc2sRVa99xzWZs";
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final int BOOK_LOADER_ID = 1;
    private final String sampleUrl = "https://www.googleapis.com/books/v1/volumes?q=android&filter=ebooks";
    private BookAdapter bookAdapter;
    private TextView emptyTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Code to make editText indicator transparent
        EditText editText =(EditText) findViewById(R.id.search_edit_text);
        editText.getBackground().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);

        ListView listView = (ListView) findViewById(R.id.books_list);
        emptyTextView = (TextView)findViewById(R.id.empty_state_textView);
        listView.setEmptyView(emptyTextView);
        final ImageView searchButton = (ImageView) findViewById(R.id.search_button);
        progressBar =(ProgressBar) findViewById(R.id.progress_indicator);
        emptyTextView.setText(R.string.empty_list_first_search);

        List<Book> list = new ArrayList<Book>();
        // Dummy data code
//        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
//        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
//        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
//        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));
//        list.add(new Book("zDibrpXTfxMC", "Android Forensics", "Andrew Hoog",description, 350.0));

        bookAdapter = new BookAdapter(this, list);
        listView.setAdapter(bookAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the behaviour of search buton click
                emptyTextView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                getLoaderManager().initLoader(BOOK_LOADER_ID, null, MainActivity.this);
            }
        });


    }

    /**
     * Method to generate dynamic urls based on search text
     * @param url takes url string
     * @return a url string
     */
    private String getSearchRequestUrl(String url ){
        // @// TODO: 07-10-2017
        return null;
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        Log.wtf(LOG_TAG,"Loader Initiated! with id:" + BOOK_LOADER_ID);
        return new BookLoader(this, sampleUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {
        progressBar.setVisibility(View.GONE);
        bookAdapter.clear();
        if(books!=null && !books.isEmpty()){
            bookAdapter.addAll(books);
        }
        emptyTextView.setText(R.string.empty_list_text);

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        bookAdapter.clear();
    }
}
