import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class prac9b extends JFrame {
    public static JComboBox j1;
    public static   JTextField t1,t2,t3,t4,t5;
    public static JLabel l1,l2,l3;
    public static JButton b1,b2;
    public static void main(String[] args) {
        JFrame p = new JFrame("STRINGS");
        String[] opr = {"trim","concatenate","reverse","substring"};

        l1 = new JLabel("ENTER A STRING : ");
        l1.setBounds(20,150,170,25);
        l1.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        l1.setVisible(false);

        l2 = new JLabel("OPERATION ");
        l2.setBounds(20,70,130,25);
        l2.setFont(new Font("SANS_SERIF",Font.BOLD,16));

        l3 = new JLabel("ENTER THE INDEX : ");
        l3.setBounds(20,190,190,25);
        l3.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        l3.setVisible(false);

        t1 = new JTextField();
        t1.setBounds(180,150,150,25);
        t1.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        t1.setVisible(false);

        t2 = new JTextField();
        t2.setBounds(350,150,150,25);
        t2.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        t2.setVisible(false);

        t3 = new JTextField();
        t3.setBounds(200,300,150,25);
        t3.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        t3.setVisible(false);

        t4 = new JTextField();
        t4.setBounds(200,190,60,25);
        t4.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        t4.setVisible(false);

        t5 = new JTextField();
        t5.setBounds(270,190,60,25);
        t5.setFont(new Font("SANS_SERIF",Font.BOLD,16));
        t5.setVisible(false);


        b1 = new JButton("PERFORM");
        b1.setBounds(140,240,100,25);
        b1.setVisible(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object select = j1.getSelectedItem();
                String c = "concatenate";
                String t = "trim";
                String s = "substring";
                String r = "reverse";
                if(select.equals(c)){
                 concatenate(t1.getText(),t2.getText());
                }
                if(select.equals(t)){
                 trim(t1.getText());
                }
                if(select.equals(s)){
                    if(t5.getText()==null){
                        String z = t4.getText();
                        int n = Integer.parseInt(z);
                        substr(t1.getText(),n);
                    }
                    else{
                        String x =t4.getText();
                        String y = t5.getText();
                        int m = Integer.parseInt(x);
                        int k = Integer.parseInt(y);
                        substr(t1.getText(),m,k);
                    }
                }
                if(select.equals(r)){
                    reverse(t1.getText());

                }
            }
        });

        b2 = new JButton("Select");
        b2.setBounds(250,70,70,15);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setVisible(true);
                t1.setVisible(true);
                b1.setVisible(true);
                t3.setVisible(true);
                Object selectedItem = j1.getSelectedItem();
                if (selectedItem != null)
                {
                    String selectedItemStr = selectedItem.toString();
                    opertate(selectedItemStr);
                }

                }

        });

        j1 = new JComboBox(opr);
        j1.setBounds(140,70,100,25);


        p.setLayout(null);
        p.setBounds(390,100,600,600);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);
        p.add(t5);
        p.add(b1);
        p.add(b2);
        p.add(j1);
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        p.setVisible(true);

    }
    public static void opertate(String str){
        String c = "concatenate";
        String s = "substring";
        if(str.equals(c)){
            t2.setVisible(true);
        }
        if(!str.equals(c)){
            t2.setVisible(false);
        }
        if(str.equals(s)){
            l3.setVisible(true);
            t4.setVisible(true);
            t5.setVisible(true);
        }
        if(!str.equals(s)){
            l3.setVisible(false);
            t4.setVisible(false);
            t5.setVisible(false);
        }
    }

    public static void reverse(String str){
        String rev = "";
        for(int i=str.length()-1;i>=0;i--){
            rev+= str.charAt(i);
        }
        t3.setText(rev);
    }
    public static void concatenate(String str1,String str2){
        String con = str1 + str2;
        t3.setText(con);
    }

    public static void trim(String str) {
        String s =str.replaceAll("\\s","");
        t3.setText(s);
    }
    public static void substr(String str,int index){
        String s = str.substring(index);
        t3.setText(s);
    }
    public static void substr(String str,int strt,int end){
        String s = str.substring(strt,end);
        t3.setText(s);
    }
}
