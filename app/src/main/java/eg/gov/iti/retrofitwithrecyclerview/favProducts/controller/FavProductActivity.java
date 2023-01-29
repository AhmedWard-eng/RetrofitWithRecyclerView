package eg.gov.iti.retrofitwithrecyclerview.favProducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.R;
import eg.gov.iti.retrofitwithrecyclerview.allProducts.view.ClickListener;
import eg.gov.iti.retrofitwithrecyclerview.favProducts.view.RecyclerFavAdapter;
import eg.gov.iti.retrofitwithrecyclerview.models.Product;
import eg.gov.iti.retrofitwithrecyclerview.models.Repo;


public class FavProductActivity extends AppCompatActivity implements ClickListener {

    RecyclerView recyclerView;
    List<Product> products;
    RecyclerFavAdapter adapter;
    Repo repo;
    private static final String TAG = "FavouriteProdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_product);

        recyclerView = findViewById(R.id.favRecyclerView);
        repo = new Repo(this);
        Log.e(TAG, "onCreate: " + recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        products = new ArrayList<>();
        adapter = new RecyclerFavAdapter(this, this);
        recyclerView.setAdapter(adapter);
        repo.getProducts().observe(this, products -> adapter.setArrayList(products));
    }


    @Override
    public void onClickListener(Product product) {
        repo.deleteProduct(product);
    }
}