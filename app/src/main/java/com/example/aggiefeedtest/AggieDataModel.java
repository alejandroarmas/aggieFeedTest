package com.example.aggiefeedtest;

import android.os.Parcel;
import android.os.Parcelable;

public class AggieDataModel implements Parcelable {

    private String title, displayName, objectType, published;

    public AggieDataModel(String title, String displayName, String objectType, String published) {
        this.title = title;
        this.displayName = displayName;
        this.objectType = objectType;
        this.published = published;
    }

    public AggieDataModel(Parcel in ) {
        readFromParcel( in );
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Object createFromParcel(Parcel in ) {
            return new AggieDataModel( in );
        }

        public AggieDataModel[] newArray(int size) {
            return new AggieDataModel[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(displayName);
        dest.writeString(objectType);
        dest.writeString(published);
    }

    private void readFromParcel(Parcel in ) {

        title = in.readString();
        displayName = in.readString();
        objectType = in.readString();
        published = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return  "Title: " + title + '\n' +
                "Display Name: " + displayName + '\n';
    }

    /* all your getter and setter methods */



}
