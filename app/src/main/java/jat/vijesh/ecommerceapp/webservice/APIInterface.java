package jat.vijesh.ecommerceapp.webservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

    @POST(UrlManager.GET_MAYNTRA_ITEMS)
    Call<ResponseBody> getMayntraItems(/*@Query("start") String start,@Query("rows") String row*/);
    // //men-casualshoes?start=10&rows=69
}
