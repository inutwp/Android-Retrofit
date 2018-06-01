package id.inudev.caribatik.API;

import id.inudev.caribatik.Model.PertokoanList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
@GET("/api/datapertokoan")
    Call<PertokoanList> getPertokoan();
}
