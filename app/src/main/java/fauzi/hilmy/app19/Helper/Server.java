package fauzi.hilmy.app19.Helper;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {
    public static final String WebUrl = "http://192.168.20.9/culture/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(WebUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Client getInstance() {
        return setInit().create(Client.class);
    }
}
