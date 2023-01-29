package eg.gov.iti.retrofitwithrecyclerview.network;

import eg.gov.iti.retrofitwithrecyclerview.models.Root;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {
    @GET("products")
    Call<Root> getProducts();
}
