package com.example.hotcoffee;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class CoffeeModel implements Parcelable {
    private int id;
    private String title;
    private String description;
    private List<String> ingredients;
    private String image;

    protected CoffeeModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        ingredients = in.createStringArrayList();
        image = in.readString();
    }

    public static final Creator<CoffeeModel> CREATOR = new Creator<CoffeeModel>() {
        @Override
        public CoffeeModel createFromParcel(Parcel in) {
            return new CoffeeModel(in);
        }

        @Override
        public CoffeeModel[] newArray(int size) {
            return new CoffeeModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeStringList(ingredients);
        dest.writeString(image);
    }
}
