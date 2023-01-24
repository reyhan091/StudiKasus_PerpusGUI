package entity;

public abstract class DataStaffEntity {
    protected String no_id, nama, alamat;
    
    public DataStaffEntity(String no_id, String nama, String alamat){
        this.no_id = no_id;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    public DataStaffEntity(){
    
    }

    public void setNo_id(String no_id) {
        this.no_id = no_id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getNo_id(){
        return this.no_id;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public String getAlamat(){
        return this.alamat;
    }
}
