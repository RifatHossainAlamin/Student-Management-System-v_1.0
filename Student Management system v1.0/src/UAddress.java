import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UAddress extends JFrame implements ActionListener {
    Container box;
    JLabel lh;
    JComboBox  cb,cb1;
    JTextField tf,id_tf;
    JButton b;
    Font f1;
    String columnNames[]={"Area","City","State"};
    UAddress(){
        //fonts:
        f1=new Font("Arial",Font.BOLD+Font.ITALIC,15);

        //button:
        b=new JButton("Update");
        b.setBounds(140,65,80,30);
        b.addActionListener(this);
        //combobox:
        cb=new JComboBox(columnNames);
        cb.setBounds(10,42,80,20);



        //textfield:
        tf=new JTextField();
        tf.setBounds(10,65,120,30);

        id_tf=new JTextField();
        id_tf.setBounds(140,10,80,30);


        //labels:
        lh=new JLabel(" Edit-person id:");
        lh.setBounds(10,10,125,30);
        lh.setFont(f1);
        lh.setOpaque(true);


        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.orange);

        //ad:
        box.add(lh);
        box.add(tf);
        box.add(id_tf);
        box.add(cb);
        box.add(b);
        //frame:
        setTitle("Edit Address");
        setSize(280,150);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        UAddress ua=new UAddress();
    }
    public static void showUAddress(){
        UAddress ua=new UAddress();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){
            int index=cb.getSelectedIndex();
            String change_id=id_tf.getText();
            String edit_info=tf.getText();
            updateaddressmethod(index,change_id,edit_info);
        }
    }

    public static void updateaddressmethod(int index,String changer_id,String edit_info){
        String collum_array[]={"s_area","s_city","s_state"};
        try {
            //pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
            String que="UPDATE address SET "+collum_array[index]+"= '"+edit_info+"' WHERE s_id='"+changer_id+"'";
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
