package com.example.rajeev.books;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Book class
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> book){
        super(context, 0, book);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        Book book = getItem(position);

        if(listItemView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listItemView = inflater.inflate(R.layout.book_list_item, parent, false);
        }
        TextView titleView = (TextView) listItemView.findViewById(R.id.book_title);
        TextView authorView = (TextView) listItemView.findViewById(R.id.author_name);
        TextView priceView = (TextView) listItemView.findViewById(R.id.book_price);
        TextView descrpView = (TextView) listItemView.findViewById(R.id.book_description);

        titleView.setText(book.getmTitle());
        authorView.setText(book.getmAuthor());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        priceView.setText("₹ "+decimalFormat.format(book.getmPrice()));
        descrpView.setText(book.getmDescription());

        return listItemView;
    }
}
