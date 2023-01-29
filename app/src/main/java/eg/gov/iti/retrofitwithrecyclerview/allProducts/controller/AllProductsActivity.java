package eg.gov.iti.retrofitwithrecyclerview.allProducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.allProducts.view.ClickListener;
import eg.gov.iti.retrofitwithrecyclerview.allProducts.view.RecyclerAdapter;
import eg.gov.iti.retrofitwithrecyclerview.models.Repo;
import eg.gov.iti.retrofitwithrecyclerview.R;
import eg.gov.iti.retrofitwithrecyclerview.models.Product;
import eg.gov.iti.retrofitwithrecyclerview.network.NetworkCommunicator;
import eg.gov.iti.retrofitwithrecyclerview.network.RetrofitClient;

public class AllProductsActivity extends AppCompatActivity implements NetworkCommunicator, ClickListener {

    RecyclerView recyclerView;
    List<Product> products;
    RecyclerAdapter adapter;
    ImageView imageViewPageNotFound;
    Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        repo = new Repo(this);
        recyclerView = findViewById(R.id.recyclerViewAllProducts);
        imageViewPageNotFound = findViewById(R.id.imgPageNotFound);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        retrofitClient.getProducts(this);
        products = new ArrayList<>();
        adapter = new RecyclerAdapter(this,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onSuccessResult(List<Product> products) {
        imageViewPageNotFound.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setArrayList(products);

    }

    @Override
    public void onFailedResult(String errMsg) {
        imageViewPageNotFound.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onClickListener(Product product) {
        repo.addProduct(product);
    }
}