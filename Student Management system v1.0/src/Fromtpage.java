import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fromtpage extends JFrame implements ActionListener {
    JLabel l1,l2;
    Container box;
    Font f,fb;
    ImageIcon img;
    JButton b;
    Fromtpage(){
        //image:
        img=new ImageIcon(getClass().getResource("1.jpg"));
        //font:
        f=new Font("Arial",Font.BOLD,24);
        fb=new Font("Arial",Font.ITALIC,20);
        //title:
        l1=new JLabel(" Welcome to students Library");
        l1.setBounds(60,30,350,50);
        l1.setFont(f);
        l1.setOpaque(true);
        l1.setBackground(Color.yellow);

        //image:
        l2=new JLabel(img);
        l2.setBounds(80,90,300,300);
        l2.setOpaque(true);
        l2.setBackground(Color.green);

        //button:
        b=new JButton("START");
        b.setBounds(150,400,120,40);
        b.setFont(fb);
        b.setForeground(Color.black);
        b.setBackground(Color.white);
        b.addActionListener(this);

        //box;
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.black);

        box.add(l1);
        box.add(l2);
        box.add(b);

        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Fromtpage fp=new Fromtpage();
    }

    public static void fpm(){
        Fromtpage fp=new Fromtpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b)){
            Operation.opm();
            setVisible(false);
        }
    }
}
