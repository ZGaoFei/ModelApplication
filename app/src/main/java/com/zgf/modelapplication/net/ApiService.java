package com.zgf.modelapplication.net;


import com.zgf.modelapplication.model.CurrentCosmeticTrialModel;
import com.zgf.modelapplication.model.Tea;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 接口
 */
public interface ApiService {

    @GET(NetApiPath.url)
    Call<CurrentCosmeticTrialModel> getCurrentCosmeticTrial(
            @Query("accessToken") String accessToken,
            @Query("isMine") int isMine);// get方法，参数：accessToken：null，isMine：0

    @GET(NetApiPath.url)
    Observable<CurrentCosmeticTrialModel> getCurrentCosmeticTrialRx(
            @Query("accessToken") String accessToken,
            @Query("isMine") int isMine);

    @GET("api")
    Call<Tea> get(
            @Query("apikey") String apiKey,
            @Query("fromat") String format,
            @Query("method") String method
    );

    @GET("api")
    Observable<Tea> getRx(
            @Query("apikey") String apiKey,
            @Query("fromat") String format,
            @Query("method") String method
    );

    @GET("api")
    rx.Observable<Tea> getRx2(
            @Query("apikey") String apiKey,
            @Query("fromat") String format,
            @Query("method") String method
    );
}
