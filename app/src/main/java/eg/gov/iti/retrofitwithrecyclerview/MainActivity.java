package eg.gov.iti.retrofitwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import eg.gov.iti.retrofitwithrecyclerview.allProducts.controller.AllProductsActivity;
import eg.gov.iti.retrofitwithrecyclerview.favProducts.controller.FavProductActivity;

public class MainActivity extends AppCompatActivity {
    Button btnGetAllProd;
    Button btnGetFavProd;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetAllProd = findViewById(R.id.btnGetAllProd);
        btnGetFavProd = findViewById(R.id.btnGetFavProd);
        btnExit = findViewById(R.id.btnExit);

        btnGetAllProd.setOnClickListener(v -> {
            Intent intent = new Intent(this, AllProductsActivity.class);
            startActivity(intent);
        });
        btnExit.setOnClickListener(v -> {
            finish();
        });
        btnGetFavProd.setOnClickListener(v -> {
            Intent intent = new Intent(this,  FavProductActivity.class);
            startActivity(intent);
        });
    }
}