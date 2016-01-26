package bcoan.moip.config;

import bcoan.moip.integration.MoipApi;
import okhttp3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import retrofit2.JacksonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Created by bruno on 14/01/16.
 */

@Configuration
public class RetrofitConfig {
    @Bean
    public MoipApi moipApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override public Request authenticate(Route route, Response response) throws IOException {
                        String credential = Credentials.basic("NYMXAKUZK5UUFMMNF8IJOYT5OCC2MYZR", "4HBDC12KT3K3IJE6ZJJ6M55NYPOBF3PAEVA9SHFI");
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sandbox.moip.com.br")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

       return retrofit.create(MoipApi.class);
    }
}
