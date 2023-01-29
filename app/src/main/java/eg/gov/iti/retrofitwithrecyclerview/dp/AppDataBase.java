package eg.gov.iti.retrofitwithrecyclerview.dp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import eg.gov.iti.retrofitwithrecyclerview.models.Product;

@Database(entities = {Product.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance = null;
    public abstract ProductsDAO getProductsDAO();
    public static synchronized AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"dbProducts").build();
        }
        return instance;
    }
}
