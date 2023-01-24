package views;

import controllers.BukuController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class BukuGUI {
    private static BukuController bukuCon = new BukuController();
    JFrame Buku = new JFrame();
    JLabel top, tambahbuku, labelkodebuku, labeljudul, labelpengarang, labeltahun, labeljumlah, labelKodebuku;
    JTextField textkodebuku, textjudul, textpengarang, texttahun, textjumlah, hapustext;
    JButton btnubahbuku, btnhapus, btnexit, btntambahbuku; 
    JTable tabelbuku = new JTable();
    JScrollPane scrolbuku = new JScrollPane(tabelbuku);
    int index;
     
    public BukuGUI(){
        Buku.setResizable(false);
        Buku.setSize(900,700);
        Buku.setLayout(null);
        Buku.getContentPane().setBackground(Color.PINK);
        top = new JLabel("PENDATAAN BUKU");
        top.setBounds(130,10,600,50);
        top.setFont(new Font("Times New Roman", Font.BOLD,30));
        Buku.add(top);
            
        scrolbuku.setBounds(300,180,600,270);
        tabelbuku.setModel(bukuCon.listbuku());
        Buku.add(scrolbuku);
        
        labelkodebuku = new JLabel("KODE BUKU");
        labelkodebuku.setBounds(30,150,100,30);
        Buku.add(labelkodebuku);
        
        textkodebuku = new JTextField();
        textkodebuku.setBounds(30,180,200,30);
        Buku.add(textkodebuku);
                
        labeljudul = new JLabel("JUDUL BUKU");
        labeljudul.setBounds(30,210,100,30);
        Buku.add(labeljudul);
        
        textjudul = new JTextField();
        textjudul.setBounds(30,240,200,30);
        Buku.add(textjudul);
        
        labelpengarang = new JLabel("PENGARANG");
        labelpengarang.setBounds(30,270,100,30);
        Buku.add(labelpengarang);
        
        textpengarang = new JTextField();
        textpengarang.setBounds(30,300,200,30);
        Buku.add(textpengarang);
        
        labeltahun = new JLabel("TAHUN TERBIT");
        labeltahun.setBounds(30,330,200,30);
        Buku.add(labeltahun);
        
        texttahun = new JTextField();
        texttahun.setBounds(30,360,200,30);
        Buku.add(texttahun);
        
        labeljumlah = new JLabel("JUMLAH");
        labeljumlah.setBounds(30,390,200,30);
        Buku.add(labeljumlah);
        
        textjumlah = new JTextField();
        textjumlah.setBounds(30,420,200,30);
        Buku.add(textjumlah);
        
        btntambahbuku = new JButton("Tambah Buku");
        btntambahbuku.setBounds(50,470,150,30);
        btntambahbuku.setBackground(Color.GREEN);
        Buku.add(btntambahbuku);
        
        btnubahbuku = new JButton("Update Buku");
        btnubahbuku.setBounds(50,510,150,30);
        Buku.add(btnubahbuku);
        
        btnhapus = new JButton("Hapus Buku");
        btnhapus.setBounds(50,550,150,30);
        btnhapus.setBackground(Color.ORANGE);
        Buku.add(btnhapus);              
               
        btnexit = new JButton("EXIT");
        btnexit.setBounds(725, 600, 100, 30);
        btnexit.setBackground(Color.red);
        Buku.add(btnexit);
        
        Buku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Buku.setVisible(true);
        Buku.setLocationRelativeTo(null);
        
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buku.dispose();
                GUILogin gui = new GUILogin();
            }
        });
        
        btntambahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String kodebuku = textkodebuku.getText();
                    String judul =  textjudul.getText();
                    String pengarang = textpengarang.getText();
                    int tahun = Integer.valueOf(texttahun.getText());
                    int jumlah = Integer.valueOf(textjumlah.getText());
                    Allobjctrl.buku.insert(kodebuku,judul,pengarang,tahun,jumlah);
                    JOptionPane.showMessageDialog(null,"Input Buku Berhasil","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(Allobjctrl.buku.listbuku());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Format penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );
        
        btnubahbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String kodebuku = textkodebuku.getText();
                    String judul =  textjudul.getText();
                    String pengarang = textpengarang.getText();
                    int tahun = Integer.valueOf(texttahun.getText());
                    int jumlah = Integer.valueOf(textjumlah.getText());
                    Allobjctrl.buku.update(index,kodebuku,judul,pengarang,tahun,jumlah);
                    JOptionPane.showMessageDialog(null,"Ubah Buku Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(Allobjctrl.buku.listbuku());
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } );
        
        tabelbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelbuku.getSelectedRow();
                index=i;
                textkodebuku.setText(Allobjctrl.buku.listbuku().getValueAt(i, 0).toString());
                textjudul.setText(Allobjctrl.buku.listbuku().getValueAt(i, 1).toString());
                textpengarang.setText(Allobjctrl.buku.listbuku().getValueAt(i, 2).toString());
                texttahun.setText(Allobjctrl.buku.listbuku().getValueAt(i, 3).toString());
                textjumlah.setText(Allobjctrl.buku.listbuku().getValueAt(i, 4).toString()); 
            }            
        });
        
        btnhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    
                    Allobjctrl.buku.delete(index);
                    JOptionPane.showMessageDialog(null,"Hapus Buku Sukses","Information", JOptionPane.INFORMATION_MESSAGE);
                    tabelbuku.setModel(Allobjctrl.buku.listbuku());
                    reset();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Fomat penulisan salah","Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    void reset(){
        textkodebuku.setText(null);//ISI
        textjudul.setText(null);
        textpengarang.setText(null);
        texttahun.setText(null);
        textjumlah.setText(null);
    }
}
