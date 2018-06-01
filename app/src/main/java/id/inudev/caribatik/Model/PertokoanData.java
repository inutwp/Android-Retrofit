package id.inudev.caribatik.Model;

import com.google.gson.annotations.SerializedName;

public class PertokoanData {

    @SerializedName("id")
    public Integer id;
    @SerializedName("ntoko")
    public String ntoko;
    @SerializedName("street")
    public String street;
    @SerializedName("pictoko")
    public String pictoko;
    @SerializedName("telp")
    public String telp;
    @SerializedName("jambuka")
    public String jambuka;
    @SerializedName("jamtutup")
    public  String jamtutup;
    @SerializedName("operasional")
    public String operasional;
    @SerializedName("lat")
    public Double lat;
    @SerializedName("lng")
    public Double lng;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtoko() {
        return ntoko;
    }

    public void setNtoko(String ntoko) {
        this.ntoko = ntoko;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPictoko() {
        return pictoko;
    }

    public void setPictoko(String pictoko) {
        this.pictoko = pictoko;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getJambuka() {
        return jambuka;
    }

    public void setJambuka(String jambuka) {
        this.jambuka = jambuka;
    }

    public String getJamtutup() {
        return jamtutup;
    }

    public void setJamtutup(String jamtutup) {
        this.jamtutup = jamtutup;
    }

    public String getOperasional() {
        return operasional;
    }

    public void setOperasional(String operasional) {
        this.operasional = operasional;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
