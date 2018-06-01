package id.inudev.caribatik.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PertokoanList {
    @SerializedName("data")
    private List<PertokoanData> pertokoanData;

    public List<PertokoanData> getPertokoanData() {
        return pertokoanData;
    }

    public void setPertokoanData(List<PertokoanData> pertokoanData) {
        this.pertokoanData = pertokoanData;
    }
}
