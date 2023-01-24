package controllers;
import entity.BukuEntity;
import models.BukuModel;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.Allobjctrl;

public class BukuController {
    public BukuModel bukuMod = new BukuModel();

    public BukuController(){
        
    }
    
    public ArrayList<BukuEntity> view(){
        return bukuMod.getDataBuku();
    }

    public void insert(String kodebuku, String judul, String pengarang, int tahun, int jumlah){
        BukuEntity buku = new BukuEntity();
        buku.setKode_buku(kodebuku);
        buku.setJudul_buku(judul);
        buku.setPengarang(pengarang);
        buku.setTahun_terbit(tahun);
        buku.setJumlah(jumlah);
        bukuMod.insert(buku);
    }
    
    public void update(int index, String kodebuku, String judul, String pengarang, int tahun, int jumlah){
        BukuEntity buku = new BukuEntity();
        buku.setKode_buku(kodebuku);
        buku.setJudul_buku(judul);
        buku.setPengarang(pengarang);
        buku.setTahun_terbit(tahun);
        buku.setJumlah(jumlah);
        bukuMod.update(index,buku);
    }
    
    public void delete(int index){
        bukuMod.delete(index);
    }
    
    public DefaultTableModel listbuku(){
    DefaultTableModel dtmlistbuku = new DefaultTableModel();
    Object[] kolom ={"Kode Buku", "Judul", "Pengarang", "Tahun Terbit", "Jumlah"};
    dtmlistbuku.setColumnIdentifiers(kolom);
    int size = Allobjctrl.buku.view().size();
    for (int i = 0; i < size; i++){
        Object [] buku = new Object[7];
        buku[0] = Allobjctrl.buku.view().get(i).getKodeBuku();
        buku[1] = Allobjctrl.buku.view().get(i).getJudul();
        buku[2] = Allobjctrl.buku.view().get(i).getPengarang();
        buku[3] = Allobjctrl.buku.view().get(i).getTahunTerbit();
        buku[4] = Allobjctrl.buku.view().get(i).getJumlah();
        dtmlistbuku.addRow(buku);
    }
    return dtmlistbuku;
}
    
    public int cekBuku(String idBuku){
    int keterangan = -1;
        if(bukuMod.getDataBuku().size() > 0){
            for(int i = 0; i < bukuMod.getDataBuku().size(); i++){
             if(idBuku.equals(bukuMod.getDataBuku().get(i).getKodeBuku())){
                 keterangan = i;
                 break;
             }else{
                 keterangan = -1;
             }
            }
        }
        return keterangan;
    }
    
    public BukuEntity showDaftarBuku(int index){
        return bukuMod.getDataBuku().get(index);
    }
}
