import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Deletepage extends JFrame implements ActionListener {
    Container box;
    JLabel lh;
    JComboBox  cb,cb1;
    JTextField tf,id_tf;
    JButton b;
    Font f1;
    String columnNames[]={"Personal","Address","All"};
    Deletepage(){
        //fonts:
        f1=new Font("Arial",Font.BOLD+Font.ITALIC,15);

        //button:
        b=new JButton("Delete");
        b.setBounds(140,35,80,30);
        b.addActionListener(this);
        //combobox:
//        cb=new JComboBox(columnNames);
//        cb.setBounds(10,10,80,20);



        //textfield:
        tf=new JTextField();
        tf.setBounds(10,35,120,30);

//        id_tf=new JTextField();
//        id_tf.setBounds(140,10,80,30);


        //labels:
//        lh=new JLabel(" Delete id:");
//        lh.setBounds(10,10,125,30);
//        lh.setFont(f1);
//        lh.setOpaque(true);


        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.black);

        //ad:
//        box.add(lh);
        box.add(tf);
//        box.add(id_tf);
//        box.add(cb);
        box.add(b);
        //frame:
        setTitle("Delete Page");
        setSize(280,150);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Deletepage ua=new Deletepage();
    }
    public static void Deletestudent(){
        Deletepage ua=new Deletepage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){

            String change_id=tf.getText();

            Deletemethod(change_id);
        }
    }

    public static void Deletemethod(String changer_id){
        String table_name[]={"studentinfo","address"};
       for(int i=table_name.length-1;i>=0;i--){
           try {
               String que="DELETE FROM "+table_name[i]+" WHERE s_id='"+changer_id+"'";
               Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "22102000");
               PreparedStatement ps2 = con.prepareStatement(que);
               ResultSet rs1 = ps2.executeQuery();
               if(rs1.next()){
                   System.out.println("update successfull");
               }else System.out.println("fail");

           }catch (Exception g){
               System.out.println(g);
           }
       }




    }
}
