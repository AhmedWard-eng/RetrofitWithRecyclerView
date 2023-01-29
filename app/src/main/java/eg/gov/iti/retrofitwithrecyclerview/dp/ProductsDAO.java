package eg.gov.iti.retrofitwithrecyclerview.dp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.models.Product;

@Dao
public interface ProductsDAO {
    @Query("select * from products")
    LiveData<List<Product>> getFavProducts();

    @Delete
    void deleteProduct(Product product);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void InsertProduct(Product product);
}
