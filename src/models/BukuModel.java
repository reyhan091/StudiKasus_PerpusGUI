package models;

import entity.BukuEntity;
import java.util.ArrayList;

public class BukuModel implements InterfaceModel{
    private ArrayList<BukuEntity> DataBuku;
    public ArrayList<BukuEntity> getDataBuku;
    
    public BukuModel(){
        DataBuku = new ArrayList<>();
    }
    
    public ArrayList<BukuEntity> getDataBuku(){
        return DataBuku;
    }
    
    @Override
    public void view(){
    
    }
    
    @Override
    public void insert(Object x){
        DataBuku.add((BukuEntity) x);
    }
    
    @Override
    public void update(int index, Object x){
        DataBuku.set(index ,(BukuEntity) x);
    }
    
    @Override
    public void delete(int index){
        DataBuku.remove(index);
    }

    public void get_where(int index){
        DataBuku.get(index);
    }    
} 
