import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class Viewpage extends JFrame implements ActionListener {
    Container box;
    JPanel p1;
    JFrame frame1;
    static JTable table,table1;

    JScrollPane scroll,scroll1;
    JButton b1,b2,b3,b4,b5;
    static String columnNames[]={"ID","NAME","FATHER'S","MOTHER'S","D O B","B G"};
    String columnNames1[]={"NAME","AREA","CITY","STATE"};
    Viewpage(){
        //button:
        b1=new JButton("Personal");
        b1.setBounds(20,350,100,30);
        b1.addActionListener(this);

        b2=new JButton("Address");
        b2.setBounds(140,350,100,30);
        b2.addActionListener(this);

        b3=new JButton("Search");
        b3.setBounds(260,350,100,30);
        b3.addActionListener(this);

        b4=new JButton("Back");
        b4.setBounds(380,350,100,30);
        b4.addActionListener(this);

        b5=new JButton("Save");
        b5.setBounds(20,400,100,30);
        b5.addActionListener(this);

        //table:
        table = new JTable();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        table1 = new JTable();
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        scroll1 = new JScrollPane(table1);
        scroll1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        p1=new JPanel();
        p1.setBounds(20,20,445,300);
        p1.add(scroll);

        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.GRAY);

        //add:
        box.add(p1);
        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(b4);
        box.add(b5);
        //frame:
        setSize(510,500);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void view() {
        Viewpage vp=new Viewpage();
    }

    public static void main(String[] args) {
        Viewpage vp=new Viewpage();
    }

    public void showTableData() {

        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        String id = "";
        String name = "";
        String fname = "";
        String mname = "";
        String date="";
        String blood="";
        try {
            //pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
            String que="select * from studentinfo";
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "22102000");
            PreparedStatement ps2 = con.prepareStatement(que);
            ResultSet rs1 = ps2.executeQuery();
            int i = 0;
            while (rs1.next()) {
                id = " "+rs1.getString("s_id");
                name = rs1.getString("s_name");
                fname = rs1.getString("s_fname");
                mname = rs1.getString("s_mname");
                date = rs1.getString("s_date");
                blood = rs1.getString("s_blood");
                //cou = rs1.getString("ucountry");
                model.addRow(new Object[]{id, name, fname, mname,date,blood});
                table.setModel(model);

                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    ////////

    public void showaddresdata() {

        //TableModel tm = new TableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames1);

        String name ="";
        String area = "";
        String city = "";
        String state = "";

        try {
            //pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
            String que="SELECT studentinfo.s_name,address.s_area,address.s_city,address.s_state FROM studentinfo INNER JOIN address ON studentinfo.s_id=address.s_id";
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "22102000");
            PreparedStatement ps2 = con.prepareStatement(que);
            ResultSet rs1 = ps2.executeQuery();
            int i = 0;
            while (rs1.next()) {
                name = "  "+rs1.getString("s_name");
                area = rs1.getString("s_area");
                city = rs1.getString("s_city");
                state = rs1.getString("s_state");

                //cou = rs1.getString("ucountry");
                model.addRow(new Object[]{ name,area,city,state});
                table.setModel(model);

                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //////////////////////////////
    public static void searchdata(int n,int m, String input) {
        if(m==0){
            String qlist[]={"s_id","s_name","s_fname","s_mname","s_date","s_blood"};
            //TableModel tm = new TableModel();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);

            String id = "";
            String name = "";
            String fname = "";
            String mname = "";
            String date="";
            String blood="";
            try {
                //pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
                String que="select * from studentinfo WHERE "+qlist[n]+"='"+input+"'";
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "22102000");
                PreparedStatement ps2 = con.prepareStatement(que);
                ResultSet rs1 = ps2.executeQuery();
                int i = 0;
                while (rs1.next()) {
                    id = " "+rs1.getString("s_id");
                    name = rs1.getString("s_name");
                    fname = rs1.getString("s_fname");
                    mname = rs1.getString("s_mname");
                    date = rs1.getString("s_date");
                    blood = rs1.getString("s_blood");
                    //cou = rs1.getString("ucountry");
                    model.addRow(new Object[]{id, name, fname, mname,date,blood});
                    table.setModel(model);

                    i++;
                }
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(m==1){
            String columnNames1[]={"ID","NAME","AREA","CITY","STATE"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames1);

            String id ="";
            String name ="";
            String area = "";
            String city = "";
            String state = "";

            try {
                //pst = con.prepareStatement("select * from emp where UNAME='" + from + "'");
                String que="SELECT studentinfo.s_id, studentinfo.s_name,address.s_area,address.s_city,address.s_state FROM studentinfo INNER JOIN address ON studentinfo.S_id='"+input+"'AND address.s_id='"+input+"'";
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "22102000");
                PreparedStatement ps2 = con.prepareStatement(que);
                ResultSet rs1 = ps2.executeQuery();
                int i = 0;
                while (rs1.next()) {
                    id = " "+rs1.getString("s_id");
                    name = " "+rs1.getString("s_name");
                    area = rs1.getString("s_area");
                    city = rs1.getString("s_city");
                    state = rs1.getString("s_state");

                    //cou = rs1.getString("ucountry");
                    model.addRow(new Object[]{ id,name,area,city,state});
                    table.setModel(model);

                    i++;
                }
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //////////////////////////////


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)){
            showTableData();
            setTitle("ALL PERSONAL INFORMATION");
        }
        if(e.getSource().equals(b2)){
            showaddresdata();
            setTitle("ALL ADDRESS");
        }
        if(e.getSource().equals(b3)){
            Search_1.spage();
        }
        if(e.getSource().equals(b4)){
            Operation.opm();
            setVisible(false);
        }
        if(e.getSource().equals(b5)){
            LocalDateTime myObj = LocalDateTime.now();
            String h=Integer.toString(myObj.getHour());
            String m=Integer.toString(myObj.getMinute());
            String s=Integer.toString(myObj.getSecond());
            try{
                //the file path
                File file = new File("H:\\"+h+"-"+m+"-"+s+".txt");
                //if the file not exist create one
                if(!file.exists()){
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                //loop for jtable rows
                for(int i = 0; i < table.getRowCount(); i++){
                    //loop for jtable column
                    for(int j = 0; j < table.getColumnCount(); j++){
                        bw.write(table.getModel().getValueAt(i, j)+" ");
                    }
                    //break line at the begin
                    //break line at the end
                    bw.write("\n_________\n");
                }
                //close BufferedWriter
                bw.close();
                //close FileWriter
                fw.close();
                JOptionPane.showMessageDialog(null, "Data Exported");

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
