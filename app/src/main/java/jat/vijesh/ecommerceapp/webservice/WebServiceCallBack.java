package jat.vijesh.ecommerceapp.webservice;

public interface WebServiceCallBack {

    void onSuccess(String serverResponce,String apiName);
    void onFailure(Object object,String apiName);
}
