package jat.vijesh.ecommerceapp.webservice;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceManager {


    public static void get(Context context, String pageName, WebServiceCallBack webServiceCallBack) {


        APIInterface apiInterface = APIClient.getClient(UrlManager.MAIN_URL).create(APIInterface.class);

        Call<ResponseBody> call = null;

        switch (pageName) {

            case UrlManager.GET_MAYNTRA_ITEMS:
                call = apiInterface.getMayntraItems();
                break;

        }
        if (call != null) {
            apiCall(context, webServiceCallBack, call, pageName);
        }
    }

    public static void post(Context context, String pageName, WebServiceCallBack webServiceCallBack) {

        APIInterface apiInterface = APIClient.getClient(UrlManager.MAIN_URL).create(APIInterface.class);

        Call<ResponseBody> call = null;

        switch (pageName) {
            case UrlManager.GET_MAYNTRA_ITEMS:
                call = apiInterface.getMayntraItems();
                break;
        }

        if (call != null) {
            apiCall(context, webServiceCallBack, call, pageName);
        }

    }

    private static void apiCall(Context context, final WebServiceCallBack webServiceCallBack, Call<ResponseBody> call, final String apiName) {
        Log.d("webservice", "POST:\nUrl " + call.request().url() + "\nType: " + call.request().method() + "\nBody: " + new Gson().toJson(call.request().body()));

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> callStatus, Response<ResponseBody> response) {
                Log.d("webservice", "\nRaw Response:" + response.raw().toString());


                if (response.isSuccessful() && response.body() != null) {

                    String strResponce = "";
                    try {
                        strResponce = response.body().string();

                    } catch (IOException e) {
                        e.printStackTrace();
                        webServiceCallBack.onFailure(strResponce, apiName);
                    }

                    if (strResponce != null && !strResponce.isEmpty())
                        webServiceCallBack.onSuccess(strResponce, apiName);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("webservice", "\nFailure Response: " + t.getMessage());
                webServiceCallBack.onFailure(t, apiName);

            }
        });
    }


}
