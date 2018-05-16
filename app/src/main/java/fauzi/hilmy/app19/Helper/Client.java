package fauzi.hilmy.app19.Helper;

import fauzi.hilmy.app19.Response.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Client {
    @GET("read_data.php")
    Call<ResponseData> response_read_data() ;
}
