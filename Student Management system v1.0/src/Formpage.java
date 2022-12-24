import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Formpage extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l5a,l5c,l5s,l6,l7;
    JTextField tf1,tf2,tf3,tf4,tf5a,tf5c,tf5s,tf6,tf7;
    Container box;
    Font f1;
    JButton b1,b2,b3;
    Formpage(){
        //fonts:
        f1=new Font("Arial",Font.BOLD,20);
        //id label:
        l1=new JLabel("Student-id:");
        l1.setBounds(20,50,110,30);
        l1.setBackground(Color.white);
        l1.setOpaque(true);
        l1.setFont(f1);

        //id tf:
        tf1=new JTextField();
        tf1.setBounds(150,50,110,30);
        tf1.setFont(f1);

        //name label:
        //name label:
        l2=new JLabel("Name       :");
        l2.setBounds(20,100,110,30);
        l2.setBackground(Color.white);
        l2.setOpaque(true);
        l2.setFont(f1);

        //name tf:
        tf2=new JTextField();
        tf2.setBounds(150,100,110,30);
        tf2.setFont(f1);

        //fname label:
        l3=new JLabel("Father's name:");
        l3.setBounds(20,150,150,30);
        l3.setBackground(Color.white);
        l3.setOpaque(true);
        l3.setFont(f1);

        //fname tf:
        tf3=new JTextField();
        tf3.setBounds(190,150,110,30);
        tf3.setFont(f1);

        //mname label:
        l4=new JLabel("Mather's name:");
        l4.setBounds(20,200,150,30);
        l4.setBackground(Color.white);
        l4.setOpaque(true);
        l4.setFont(f1);

        //fname tf:
        tf4=new JTextField();
        tf4.setBounds(190,200,110,30);
        tf4.setFont(f1);

        //address label:
        l5=new JLabel("Address :");
        l5.setBounds(20,250,110,30);
        l5.setBackground(Color.white);
        l5.setOpaque(true);
        l5.setFont(f1);

        //l5a:
        l5a=new JLabel("Area :");
        l5a.setBounds(140,250,60,30);
        l5a.setBackground(Color.white);
        l5a.setOpaque(true);
        l5a.setFont(f1);

        //tfa:
        tf5a=new JTextField();
        tf5a.setBounds(200,250,100,30);
        tf5a.setBackground(Color.white);
        tf5a.setOpaque(true);
        tf5a.setFont(f1);

        //city:
        l5c=new JLabel("City :");
        l5c.setBounds(300,250,60,30);
        l5c.setBackground(Color.white);
        l5c.setOpaque(true);
        l5c.setFont(f1);

        //City field:
        tf5c=new JTextField();
        tf5c.setBounds(360,250,100,30);
        tf5c.setBackground(Color.white);
        tf5c.setOpaque(true);
        tf5c.setFont(f1);

        //state:
        l5s=new JLabel("State:");
        l5s.setBounds(460,250,60,30);
        l5s.setBackground(Color.white);
        l5s.setOpaque(true);
        l5s.setFont(f1);

        //state field:
        tf5s=new JTextField();
        tf5s.setBounds(520,250,100,30);
        tf5s.setBackground(Color.white);
        tf5s.setOpaque(true);
        tf5s.setFont(f1);

        ///////

        //date of birth label:
        l6=new JLabel("Date Of Birth:");
        l6.setBounds(20,300,130,30);
        l6.setBackground(Color.white);
        l6.setOpaque(true);
        l6.setFont(f1);

        //date of birth:
        tf6=new JTextField();
        tf6.setBounds(170,300,110,30);
        tf6.setFont(f1);

        //blood group label:
        l7=new JLabel("Blood Group:");
        l7.setBounds(20,350,130,30);
        l7.setBackground(Color.white);
        l7.setOpaque(true);
        l7.setFont(f1);


        // blood group::
        tf7=new JTextField();
        tf7.setBounds(170,350,110,30);
        tf7.setFont(f1);

        //submit button:
        b1=new JButton("Submit");
        b1.setBounds(50,400,100,30);
        b1.setFont(f1);
        b1.addActionListener(this);

        b2=new JButton("Clear");
        b2.setBounds(180,400,100,30);
        b2.setFont(f1);
        b2.addActionListener(this);

        b3=new JButton("Back");
        b3.setBounds(310,400,100,30);
        b3.setFont(f1);
        b3.addActionListener(this);

        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.black);

        //add:
        box.add(l1);
        box.add(tf1);
        box.add(l2);
        box.add(tf2);
        box.add(l3);
        box.add(tf3);
        box.add(l4);
        box.add(tf4);
        box.add(l5);
        box.add(l5a);
        box.add(tf5a);
        box.add(l5c);
        box.add(tf5c);
        box.add(l5s);
        box.add(tf5s);
        ///
        box.add(l6);
        box.add(tf6);
        box.add(l7);
        box.add(tf7);
        box.add(b1);
        box.add(b2);
        box.add(b3);
        //frame:
        setSize(800,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void addinfo(){Formpage fp=new Formpage();}
    public static void main(String[] args) {
        Formpage fpm=new Formpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String a,b,c,d,f,h,i,j,k;
        if(e.getSource().equals(b1)){
            String sa,sb,sc,sd,sf,sh,ai,aj,ak;
                sa=tf1.getText();
                sb=tf2.getText();
                sc=tf3.getText();
                sd=tf4.getText();
                sf=tf6.getText();
                sh=tf7.getText();
                ai=tf5a.getText();
                aj=tf5c.getText();
                ak=tf5s.getText();

//                try{
//                    String query="INSERT INTO studentinfo(s_id,s_name,s_fname,s_mname,s_date,s_blood) VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+f+"','"+h+"')";
//                    Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","22102000");
//                    PreparedStatement ps1=con.prepareStatement(query);
//                    ResultSet rs1=ps1.executeQuery();
//                    con.close();
//                }catch (Exception g){
//                    System.out.println(g);
//                }system[exception

                insertdata(sa,sb,sc,sd,sf,sh);
                insertaddress(ai,aj,ak,sa);
            }
        if(e.getSource().equals(b2)){
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5a.setText("");
            tf5c.setText("");
            tf5s.setText("");
            tf6.setText("");
            tf7.setText("");
        }
        if(e.getSource().equals(b3)){
            Operation.opm();
            setVisible(false);
        }
    }

    public static void insertdata(String a,String b,String c,String d, String f,String h){
        try{
            String query="INSERT INTO studentinfo(s_id,s_name,s_fname,s_mname,s_date,s_blood) VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+f+"','"+h+"')";
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","22102000");
            PreparedStatement ps1=con.prepareStatement(query);
            ResultSet rs1=ps1.executeQuery();
            con.close();
        }catch (Exception g){
            System.out.println(g);
        }
    }

    public static void insertaddress(String a,String b,String c,String d){
        try{
            String query="INSERT INTO address(s_area,s_city,s_state,s_id) VALUES('"+a+"','"+b+"','"+c+"','"+d+"')";
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","22102000");
            PreparedStatement ps1=con.prepareStatement(query);
            ResultSet rs1=ps1.executeQuery();
            con.close();
        }catch (Exception g){
            System.out.println(g);
        }
    }
}
