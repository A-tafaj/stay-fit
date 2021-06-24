package fiek.unipr.stayfit.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodsModel implements Parcelable {
    private String name;
    private String url;
    private String tags;
    private Nutritions nutritions;

    protected FoodsModel(Parcel in) {
        name = in.readString();
        url = in.readString();
        tags = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    public static final Creator<FoodsModel> CREATOR = new Creator<FoodsModel>() {
        @Override
        public FoodsModel createFromParcel(Parcel in) {
            return new FoodsModel(in);
        }

        @Override
        public FoodsModel[] newArray(int size) {
            return new FoodsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(url);
        parcel.writeString(tags);
    }
}
