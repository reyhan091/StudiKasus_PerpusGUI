package controllers;

import models.StaffModel;
import entity.StaffEntity;
import java.util.ArrayList;

public class StaffController {
    public StaffModel StaffMod = new StaffModel();
    int loginStaff = 0;
     
    public StaffController(){
    
    }
    
    public ArrayList<StaffEntity> view(){
        return StaffMod.getDataStaff();
    }
  
    public void insert(StaffEntity staff){
        StaffMod.insert(staff);
    }

    public void update(int index, StaffEntity staff){
        StaffMod.update(index, staff);
    }

    public void delete(int index){
        StaffMod.delete(index);
    }
    
    public void dataStaff(){
        String no_id [] = {"01", "02", "03", "04"};
        String nama [] = {"Reyhan", "Rizal", "Jarohim", "Yoga"};
        String alamat [] = {"Surabaya", "Sidoarjo", "Lamongan", "Bali"};
        String password [] = {"01", "02", "03", "04"};
       
        for(int i = 0; i < nama.length; i++){
        StaffMod.insert(new StaffEntity(no_id[i], nama[i], alamat[i], password[i]));
        }
    }
     
    public void cekStaff(String id, String password) {
        loginStaff = StaffMod.cekStaff(id,password);
    }
     
    public StaffEntity petugasEntity(){
        return StaffMod.showDataStaff(loginStaff);
    }
}

