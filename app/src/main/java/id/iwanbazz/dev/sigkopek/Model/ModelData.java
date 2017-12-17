package id.iwanbazz.dev.sigkopek.Model;

import java.io.Serializable;

/**
 * Created by Anisah Denis on 9/2/2016.
 */
public class ModelData implements Serializable {
    private String no;
    private String nama;
    private String alamat;
    private String notelp;
    private String lat;
    private String lng;

    private String Jenis;



    public String getNo() {
        return no;
    }

    public String setNo(String no) {
        this.no = no;
        return no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }


    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }



}

