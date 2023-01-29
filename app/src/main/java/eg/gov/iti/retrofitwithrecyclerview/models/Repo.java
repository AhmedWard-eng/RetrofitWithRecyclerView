package eg.gov.iti.retrofitwithrecyclerview.models;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.dp.AppDataBase;

public class Repo {
    AppDataBase dataBase;

    public Repo(Context context) {
        dataBase = AppDataBase.getInstance(context);
    }

    public LiveData<List<Product>> getProducts() {
        return dataBase.getProductsDAO().getFavProducts();
    }

    public void addProduct(Product product) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                dataBase.getProductsDAO().InsertProduct(product);
            }
        }.start();
    }

    public void deleteProduct(Product product) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                dataBase.getProductsDAO().deleteProduct(product);
            }
        }.start();
    }
}
