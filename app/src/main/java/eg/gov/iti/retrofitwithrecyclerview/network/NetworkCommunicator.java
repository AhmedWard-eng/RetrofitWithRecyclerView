package eg.gov.iti.retrofitwithrecyclerview.network;

import java.util.List;

import eg.gov.iti.retrofitwithrecyclerview.models.Product;

public interface NetworkCommunicator {
     void onSuccessResult(List<Product> products);
     void onFailedResult(String errMsg);
}
