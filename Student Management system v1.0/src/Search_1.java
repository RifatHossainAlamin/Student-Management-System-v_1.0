import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Search_1 extends JFrame implements ActionListener {
    Container box;
    static JComboBox cb,cb1;
    static JTextField tf;
    // JTable table3;
    JButton b;
    //JScrollPane scroll1;
    String columnNames[]={"ID","NAME","FATHER'S","MOTHER'S","D O B","B G"};
    String cop[]={"PERSONAL","ADDRESS"};
    Search_1(){
        //button:
        b=new JButton("Search");
        b.setBounds(100,35,80,30);
        b.addActionListener(this);
        //combobox:
        cb=new JComboBox(columnNames);
        cb.setBounds(10,10,80,20);

        cb1=new JComboBox(cop);
        cb1.setBounds(100,10,100,20);

        //textfield:
        tf=new JTextField();
        tf.setBounds(10,35,80,30);


        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.orange);
        //add:
        box.add(cb);
        box.add(cb1);
        box.add(tf);
        box.add(b);
        //fra,e:
        setSize(250,130);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Search_1 s1=new Search_1();
    }
    public static void spage(){
        Search_1 s1=new Search_1();
    }
    @Override
    public  void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){
            int n=cb.getSelectedIndex();
            int m=cb1.getSelectedIndex();
            String st=tf.getText();

            Viewpage.searchdata(n,m,st);
        }
    }
}
