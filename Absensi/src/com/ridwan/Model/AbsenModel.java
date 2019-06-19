/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Muhammad Ridwan
 */
public class AbsenModel {
    private int id;
    private UserModel user;
    private Timestamp jammasuk;
    private Timestamp jampulang;
    private Timestamp Absen;
   private byte [] foto;
   private Date tanggal;

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Timestamp getJammasuk() {
        return jammasuk;
    }

    public void setJammasuk(Timestamp jammasuk) {
        this.jammasuk = jammasuk;
    }

    public Timestamp getJampulang() {
        return jampulang;
    }

    public void setJampulang(Timestamp jampulang) {
        this.jampulang = jampulang;
    }

    public Timestamp getAbsen() {
        return Absen;
    }

    public void setAbsen(Timestamp Absen) {
        this.Absen = Absen;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
   
   
   
}
