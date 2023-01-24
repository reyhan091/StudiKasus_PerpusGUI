package entity;

public class BukuEntity {    
    private String kode_buku, judul_buku, pengarang;
    private int tahun_terbit, jumlah;
    
    public BukuEntity(String kode_buku, String judul_buku, String pengarang, 
            int tahun_terbit, int jumlah){
        
        this.kode_buku = kode_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tahun_terbit = tahun_terbit;
        this.jumlah = jumlah;
    }

    public void setKode_buku(String kode_buku) {
        this.kode_buku = kode_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setTahun_terbit(int tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public BukuEntity(){
    
    }
    
    public String getKodeBuku(){
        return this.kode_buku;
    }
    
   public String getJudul(){
        return this.judul_buku;
    }
    
    public String getPengarang(){
        return this.pengarang;
    }
    
    public int getTahunTerbit(){
        return this.tahun_terbit;
    }
    
    public int getJumlah(){
        return this.jumlah;
    }
}
