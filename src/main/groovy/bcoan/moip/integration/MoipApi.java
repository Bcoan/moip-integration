package bcoan.moip.integration;

import bcoan.moip.domain.Order;
import bcoan.moip.domain.dto.OrderDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bruno on 14/01/16.
 */
public interface MoipApi {

    @POST("/v2/orders")
    Call<OrderDTO> createOrder(@Body OrderDTO order);
}
