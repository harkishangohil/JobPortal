package com.example.jobseeker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparrow.seekerslibrary.JobseekerResponse;
import com.sparrow.seekerslibrary.education_data_class;
import com.sparrow.seekerslibrary.experiance_data_class;
import com.sparrow.seekerslibrary.personel_details_class;
import com.sparrow.seekerslibrary.proffesional_data_class;

import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

        @Multipart
        @POST("personal_one.php")
        Call<personel_details_class> Post_Personel_Detail(
                @Part("name") RequestBody  name,
                @Part("email") RequestBody  email,
                @Part("password") RequestBody  password,
                @Part("mobile") RequestBody  mobile,
                @Part("current_city") RequestBody  current_city,
                @Part("image2") MultipartBody.Part  image2,
                @Part("tot_exp_month") RequestBody  tot_exp_month,
                @Part("tot_exp_year") RequestBody tot_exp_year,
                @Part("jobs_type") RequestBody  jobs_type
                );

        @FormUrlEncoded
        @POST("education.phpp")
        Call<education_data_class> Post_Education_details(
                @Field("id") String id,
                @Field("mobile") String mobile,
                @Field("high_quali") String high_quali,
                @Field("course") String course,
                @Field("specialization") String specialization,
                @Field("university") String university,
                @Field("course_type") String course_type,
                @Field("pass_year") String pass_year
                );

        @FormUrlEncoded
        @POST("experience.php")
        Call<experiance_data_class> Post_Experiance_details(
                @Field("id") String id,
                @Field("mobile") String mobile,
                @Field("curr_designation") String curr_designation,
                @Field("curr_cmp") String curr_cmp,
                @Field("ann_slakh") String ann_slakh,
                @Field("ann_sthousand") String ann_sthousand,
                @Field("ws_year") String ws_year,
                @Field("ws_month") String ws_month,
                @Field("work_to_present") String work_to_present,
                @Field("dur_nperiod") String dur_nperiod,
                @Field("skill") String skill,
                @Field("cmp_industry") String cmp_industry,
                @Field("fun_area") String fun_area,
                @Field("role") String role
                );

        @Multipart
        @POST("proffesional.php")
        Call<proffesional_data_class> Post_Prodesional_details(
                @Part("id") RequestBody id,
                @Part("mobile") RequestBody mobile,
                @Part("desc_prof") RequestBody desc_prof,
                @Part("pre_work_loc") RequestBody pre_work_loc,
                @Part("desi_jtype") RequestBody desi_jtype,
                @Part("desi_emp_type") RequestBody desi_emp_type,
                @Part("gender") RequestBody gender,
                @Part("image") MultipartBody.Part image,
                @Part("address") RequestBody address,
                @Part("language") RequestBody language
                );

    }
    }
