package models;

import entity.StaffEntity;
import java.util.ArrayList;

public class StaffModel implements InterfaceModel{
    public ArrayList<StaffEntity> DataStaff;
    
    public StaffModel(){
        DataStaff = new ArrayList<>();
    }
    
    public ArrayList<StaffEntity> getDataStaff(){
        return DataStaff;
    }
    
    @Override
    public void view(){
    
    }
    
    @Override
    public void insert(Object x){
        DataStaff.add((StaffEntity) x);
    }
    
    @Override
    public void update(int index, Object x){
        DataStaff.set(index ,(StaffEntity) x);
    }
    
    @Override
    public void delete(int index){
        DataStaff.remove(index);
    }
    
    public StaffEntity showDataStaff(int index){
        return DataStaff.get(index);
    }

    public int cekStaff(String id, String password){
        int loop = 0;
        for(StaffEntity staffEntity : getDataStaff()){
            if(staffEntity.getNo_id().equals(id) && staffEntity.getPassword().equals(password)){
                break;
            }else{
                  loop++;
            }
        }
        return loop;
    };
}
