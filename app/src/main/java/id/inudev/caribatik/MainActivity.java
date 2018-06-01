package id.inudev.caribatik;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import id.inudev.caribatik.API.ApiClient;
import id.inudev.caribatik.API.ApiInterface;
import id.inudev.caribatik.Adapter.ListPertokoanAdapter;
import id.inudev.caribatik.Holder.ListPertokoanHolder;
import id.inudev.caribatik.Model.PertokoanData;
import id.inudev.caribatik.Model.PertokoanList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView mRecyclerView = findViewById(R.id.recycleview_list_pertokoan);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PertokoanList> pertokoanListCall = mApiInterface.getPertokoan();
        pertokoanListCall.enqueue(new Callback<PertokoanList>() {
            @Override
            public void onResponse(@NonNull Call<PertokoanList> call, @NonNull Response<PertokoanList> response) {
                try {
                    List<PertokoanData> pertokoanData = Objects.requireNonNull(response.body()).getPertokoanData();
                    adapter = new ListPertokoanAdapter(pertokoanData) {
                        @Override
                        protected void bindHolder(ListPertokoanHolder holder, PertokoanData mData) {
                        holder.bind(mData);
                        }
                    };
                    mRecyclerView.setAdapter(adapter);
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PertokoanList> call, @NonNull Throwable t) {

            }
        });
    }
}
