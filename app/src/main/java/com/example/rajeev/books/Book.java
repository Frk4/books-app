package com.example.rajeev.books;

import android.graphics.Bitmap;

/**
 * Created by Rahul on 06-10-2017.
 * This custom class contains all the data related to book.
 */

class Book {
    private String mId;
    private String mTitle;
    private String mAuthor;
    private Bitmap mThumbnail;
    private String mDescription;
    private double mPrice;

    public Book(String mId, String mTitle, String mAuthor, Bitmap mThumbnail,String mDescription, double mPrice) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mThumbnail = mThumbnail;
        this.mDescription = mDescription;
        this.mPrice = mPrice;
    }

    public Book(String mId, String mTitle, String mAuthor,String mDescription, double mPrice) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mDescription = mDescription;
        this.mPrice = mPrice;
    }

    public String getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public Bitmap getmThumbnail() {
        return mThumbnail;
    }

    public String getmDescription() {
        return mDescription;
    }

    public double getmPrice() {
        return mPrice;
    }
}
