package com.example.myappuos.network;

import static com.example.myappuos.utils.Config.BASE_URL;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient implements Interceptor
{
    private static Retrofit retrofit = null;
    private static Session sessionVacation;
    private static OkHttpClient okHttpClient;
    String credentials;
    public APIClient(String Username, String Password)
    {
        this.credentials = Credentials.basic(Username, Password);
    }
    public static Retrofit getClient(final Context mContext) {
        sessionVacation = new Session(mContext);
        File httpCacheDirectory = new File(mContext.getCacheDir(), "responses");
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        //  Cache cache = new Cache(mContext.getCacheDir(), cacheSize);
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (sessionVacation.getCustomerLogin())
        {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.MINUTES)
                    .addInterceptor(new Interceptor()
                    {
                        @Override
                        public Response intercept(Chain chain) throws IOException
                        {
                            Request.Builder ongoing = chain.request().newBuilder();
                            ongoing.addHeader("Authorization", sessionVacation.getAccessTokenHoliday());
                            return chain.proceed(ongoing.build());
                        }
                    })
                    .addInterceptor(interceptor)
                    .addInterceptor(new APIClient("UNITYOFSOUTHGUJARAT","VYARA"))
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .cache(cache)
                    .build();
        }
        else
            {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .addInterceptor(new APIClient("UNITYOFSOUTHGUJARAT","VYARA"))
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .cache(cache)

                    .build();
        }


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException
    {

        Request request = chain.request();

        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);    }
}
