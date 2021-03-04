package com.example.jobseeker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparrow.seekerslibrary.JobseekerResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class WebService {
    private static WebServiceInterface webApiInterface;


    public static WebServiceInterface getClient() {
        if (webApiInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okclient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .writeTimeout(100, TimeUnit.SECONDS)
                    .build();
            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://gohelvijay47932685.ipage.com/spr_lib/")
                    .client(okclient)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            webApiInterface = client.create(WebServiceInterface.class);
        }
        return webApiInterface;
    }

    public interface WebServiceInterface {

        @FormUrlEncoded
        @POST("jobseeker.php")
        Call<JobseekerResponse> SendJobSeekerData(
                @Field("fname") String fname,
                @Field("lname") String lname,
                @Field("image") String image,
                @Field("fathername") String fathername,
                @Field("gender") String gender,
                @Field("dob") String dob,
                @Field("caddress") String caddress,
                @Field("cstate") String cstate,
                @Field("ccity") String ccity,
                @Field("cpincode") String cpincode,
                @Field("paddress") String paddress,
                @Field("pastate") String pastate,
                @Field("pacity") String pacity,
                @Field("papincode") String papincode,
                @Field("mobile") String mobile,
                @Field("email") String email,
                @Field("tenb") String tenb,
                @Field("teni") String teni,
                @Field("tenc") String tenc,
                @Field("teny") String teny,
                @Field("twb") String twb,
                @Field("twi") String twi,
                @Field("twc") String twc,
                @Field("twy") String twy,
                @Field("grab") String grab,
                @Field("grai") String grai,
                @Field("grac") String grac,
                @Field("gray") String gray,
                @Field("otherb") String otherb,
                @Field("otheri") String otheri,
                @Field("otherc") String otherc,
                @Field("othery") String othery,
                @Field("workedother") String workedother,
                @Field("ex") String ex,
                @Field("month") String month,
                @Field("role") String role,
                @Field("organization") String organization,
                @Field("salary") String salary,
                @Field("skill1") String skill1,
                @Field("regi_date") String regi_date,
                @Field("country") String country,
                @Field("some_keyword") String some_keyword,
                @Field("cmp_name") String cmp_name
        );

    }
    }
