import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operation extends JFrame implements ActionListener {
    Container box;
    JButton b1,b2,b3,b4;
    ImageIcon img,img1,img2,img3;
    Operation(){
        //img:
        img=new ImageIcon(getClass().getResource("2.png"));
        //add button:
        b1=new JButton(img);
        b1.setBounds(50,50,100,100);
        b1.addActionListener(this);

        //img:
        img1=new ImageIcon(getClass().getResource("3.jpg"));
        //add button:
        b2=new JButton(img1);
        b2.setBounds(200,50,100,100);
        b2.addActionListener(this);

        //img:
        img2=new ImageIcon(getClass().getResource("edit.jpg"));
        //add button:
        b3=new JButton(img2);
        b3.setBounds(350,50,100,100);
        b3.addActionListener(this);

        //img:
        img3=new ImageIcon(getClass().getResource("home.jpg"));
        //add button:
        b4=new JButton(img3);
        b4.setBounds(50,180,100,100);
        b4.addActionListener(this);



        //box;
        box=this.getContentPane();
        box.setLayout(null);
        box.setBackground(Color.black);

        //add:
        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(b4);

        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void opm() {
        Operation op=new Operation();
    }
    public static void main(String [] args){
        Operation op=new Operation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(b1)) {
            Formpage.addinfo();
            setVisible(false);
        }
        if(e.getSource().equals(b2)){
            Viewpage.view();
            setVisible(false);
        }
        if(e.getSource().equals(b3)){
            Editpage.showep();
        }
        if(e.getSource().equals(b4)){
            Fromtpage.fpm();
            setVisible(false);
        }
        }
    }

