/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.Interface;

import com.ridwan.Model.AbsenModel;
import java.util.List;

/**
 *
 * @author Muhammad Ridwan
 */
public interface AbsenInterface {
       boolean insertAbsen(AbsenModel am);
    boolean updateAbsen(AbsenModel sm);
     List<AbsenModel> getUserModels();
}
