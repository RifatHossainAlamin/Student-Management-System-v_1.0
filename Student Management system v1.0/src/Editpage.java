import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editpage extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    Container box;
    Font f1;

    Editpage(){
        //font:
        f1=new Font("Arial",Font.BOLD,20);
        //buttons:
        b1=new JButton("Personal");
        b1.setBounds(90,10,120,30);
        b1.setFont(f1);
        b1.addActionListener(this);

        b2=new JButton("Address");
        b2.setBounds(90,50,120,30);
        b2.setFont(f1);
        b2.addActionListener(this);

        b3=new JButton("Delete");
        b3.setBounds(90,90,120,30);
        b3.setFont(f1);
        b3.addActionListener(this);

        //box:
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.RED);
        //add:
        box.add(b1);
        box.add(b2);
        box.add(b3);
        //frame:
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Editpage ep=new Editpage();
    }
    public static void showep(){
        Editpage ep=new Editpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)){
            Epersonal.showUpdate();
        }
        if(e.getSource().equals(b2)){
            UAddress.showUAddress();
        }
        if(e.getSource().equals(b3)){
            Deletepage.Deletestudent();
        }
    }
}
