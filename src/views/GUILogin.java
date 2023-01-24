package views;
import controllers.StaffController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUILogin {
    JFrame frame = new JFrame();
    JLabel top;
    JTextField textidlogin;
    JLabel idLogin, labelpass;
    JButton btnlogin, btnkeluar;
    JPasswordField passwordlogin;
    
    public GUILogin(){
        frame.setResizable(false);
        frame.setSize(681,364);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY);
        top = new JLabel("LOGIN ADMINISTRATOR");
        top.setBounds(138,10,592,48);
        top.setFont(new Font("Times New Roman", Font.BOLD,30));
        frame.add(top);

        idLogin = new JLabel("Input ID");
        idLogin.setBounds(230,94,100,30);
        frame.add(idLogin);
        
        textidlogin = new JTextField();
        textidlogin.setBounds(230,124,200,30);
        frame.add(textidlogin);
        
        labelpass = new JLabel("Input Password");
        labelpass.setBounds(230,165,100,30);
        frame.add(labelpass);
        
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(230,195,200,30);
        frame.add(passwordlogin);
        
        btnlogin = new JButton("Login");
        btnlogin.setBounds(280,255,100,40);
        btnlogin.setBackground(Color.GREEN);
        frame.add(btnlogin);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Allobjctrl.staff.dataStaff();
                    Allobjctrl.staff.cekStaff(textidlogin.getText(),passwordlogin.getText());
                    String nama = Allobjctrl.staff.petugasEntity().getNama();
                     JOptionPane.showMessageDialog(null, "Welcome " + nama + "'s Staff","information",JOptionPane.INFORMATION_MESSAGE);
                        BukuGUI buku = new BukuGUI();
                    frame.dispose();
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,"Wrong ID or Password","information",JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
             }
        });
    }
    
    void reset(){
        textidlogin.setText(null);//ISI
        passwordlogin.setText(null);
    } 
}
