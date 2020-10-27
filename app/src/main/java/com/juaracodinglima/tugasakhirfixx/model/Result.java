
package com.juaracodinglima.tugasakhirfixx.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable, Parcelable
{

    @SerializedName("name_produk")
    @Expose
    private String nameProduk;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("stok")
    @Expose
    private String stok;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("url_image")
    @Expose
    private String urlImage;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1091272826448307347L;

    protected Result(Parcel in) {
        this.nameProduk = ((String) in.readValue((String.class.getClassLoader())));
        this.harga = ((String) in.readValue((String.class.getClassLoader())));
        this.stok = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((String) in.readValue((String.class.getClassLoader())));
        this.urlImage = ((String) in.readValue((String.class.getClassLoader())));
        this.tanggal = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param harga
     * @param nameProduk
     * @param rating
     * @param stok
     * @param tanggal
     * @param url
     * @param urlImage
     */
    public Result(String nameProduk, String harga, String stok, String url, String rating, String urlImage, String tanggal) {
        super();
        this.nameProduk = nameProduk;
        this.harga = harga;
        this.stok = stok;
        this.url = url;
        this.rating = rating;
        this.urlImage = urlImage;
        this.tanggal = tanggal;
    }

    public String getNameProduk() {
        return nameProduk;
    }

    public void setNameProduk(String nameProduk) {
        this.nameProduk = nameProduk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nameProduk);
        dest.writeValue(harga);
        dest.writeValue(stok);
        dest.writeValue(url);
        dest.writeValue(rating);
        dest.writeValue(urlImage);
        dest.writeValue(tanggal);
    }

    public int describeContents() {
        return  0;
    }

}
