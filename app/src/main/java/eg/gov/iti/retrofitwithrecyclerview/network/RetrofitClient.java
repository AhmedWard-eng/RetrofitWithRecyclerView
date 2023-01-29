package eg.gov.iti.retrofitwithrecyclerview.network;

import android.util.Log;

import androidx.annotation.NonNull;

import eg.gov.iti.retrofitwithrecyclerview.models.Root;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://dummyjson.com/";
    private static final String TAG = "RetrofitClient";
    private ProductAPI productAPI;
    private static RetrofitClient retrofitClient;


    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        productAPI = retrofit.create(ProductAPI.class);
    }



    public void getProducts(NetworkCommunicator communicator) {
        Callback<Root> callback = new Callback<Root>() {
            @Override
            public void onResponse(@NonNull Call<Root> call, @NonNull Response<Root> response) {
                if (response.isSuccessful() && response.body() != null) {
                    communicator.onSuccessResult(response.body().products);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Root> call, @NonNull Throwable t) {
                communicator.onFailedResult(t.getMessage());
                Log.e(TAG, "onFailure: " + t);
            }
        };
        productAPI.getProducts().enqueue(callback);
    }
}
