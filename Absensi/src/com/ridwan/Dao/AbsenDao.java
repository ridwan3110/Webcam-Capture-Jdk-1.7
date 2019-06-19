/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Dao;

import com.ridwan.DBC.DBC;
import com.ridwan.Interface.AbsenInterface;
import com.ridwan.Model.AbsenModel;
import com.ridwan.Model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muhammad Ridwan
 */
public class AbsenDao implements AbsenInterface{

    private Connection connection;
    private UserDAo userDAo = new UserDAo();

    public AbsenDao() {
    connection =DBC.getConnection();
    }
    
    
    
    @Override
    public boolean insertAbsen(AbsenModel am) {
      boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into absensi (Id, No_User,Jadwal_Masuk, Jadwal_Pulang, Tanggal) values (?,?,?,?,?)";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, am.getId());
            statement.setInt(2, am.getUser().getNo());
            statement.setTimestamp(3, am.getJammasuk());
            statement.setTimestamp(4, am.getJampulang());
            statement.setDate(5, new java.sql.Date(am.getTanggal().getTime()));
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(AbsenDao.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AbsenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;   
    }

    @Override
    public boolean updateAbsen(AbsenModel sm) {
    boolean valid = false;
        PreparedStatement statement = null;
    String sql = "update Absensi set Absen=?, Foto=? where No_User=?";
    
        try {
            statement = connection.prepareStatement(sql);
            statement.setTimestamp(1, sm.getAbsen());
            statement.setBytes(2, sm.getFoto());
            statement.setInt(3, sm.getUser().getNo());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAo.class.getName()).log(Level.SEVERE, null, ex);
        valid = false;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    return valid; 
    }

    @Override
    public List<AbsenModel> getUserModels() {
    List list = new ArrayList();
        ResultSet rs = null;
        PreparedStatement  statement = null;
        String sql = "select * from absensi";
        
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()){
               AbsenModel model = new AbsenModel();
                model.setId(rs.getInt("Id"));
               int byid = rs.getInt("No_User");
                UserModel usermodelById = userDAo.getusermodelById(byid);
                model.setUser(usermodelById);
                model.setJammasuk(rs.getTimestamp("Jam_Masuk"));
                model.setJampulang(rs.getTimestamp("Jam_Pulang"));
                model.setAbsen(rs.getTimestamp("Absen"));
                model.setFoto(rs.getBytes("Foto"));
                model.setTanggal(rs.getDate("Tanggal"));
                
               
             
                list.add(model);
            }return list;
        } catch (SQLException ex) {
            Logger.getLogger(AbsenDao.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AbsenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AbsenDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    
    }
    
}
