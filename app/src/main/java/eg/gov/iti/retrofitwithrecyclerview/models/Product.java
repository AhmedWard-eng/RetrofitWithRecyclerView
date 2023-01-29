package eg.gov.iti.retrofitwithrecyclerview.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey
    @NonNull
    public int id;
    public String title;
    public String description;
    public int price;
    public double discountPercentage;
    public double rating;
    public int stock;

    public String brand;
    public String category;
    public String thumbnail;
}
