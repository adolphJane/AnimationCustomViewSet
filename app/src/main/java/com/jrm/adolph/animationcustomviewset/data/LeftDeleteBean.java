package com.jrm.adolph.animationcustomviewset.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by adolp on 2017/7/19.
 */

public class LeftDeleteBean implements Parcelable {

    private int imageId;
    private String name;
    private String content;
    private String time;

    public LeftDeleteBean(){

    }

    public LeftDeleteBean(int imageId, String name, String content, String time) {
        this.imageId = imageId;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    protected LeftDeleteBean(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
        content = in.readString();
        time = in.readString();
    }

    public static final Creator<LeftDeleteBean> CREATOR = new Creator<LeftDeleteBean>() {
        @Override
        public LeftDeleteBean createFromParcel(Parcel in) {
            return new LeftDeleteBean(in);
        }

        @Override
        public LeftDeleteBean[] newArray(int size) {
            return new LeftDeleteBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(name);
        parcel.writeString(content);
        parcel.writeString(time);
    }
}
