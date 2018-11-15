package Projectalg;

import java.io.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Interface extends Jframe implements ActionListener {

    public static Interface obj;
    int cont1, cont2;
    JButton Search, clean,save,sort,order;
    Container cont;
    JLabel et1, pers, num, lin;
    Color blue;
    JTextField route;
    String rut, word;
    JTextArea area;
    JScrollPane sc;
    File archive = null;
    FileReader fr = null;
    BufferedReader br = null;
    JMenuBar menu;
    JMenu arch;
    JMenuItem version;
    JMenuItem leave;

    public Interface() {

        setSize(850, 720);
        setTitle("Aplication");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        blue = new Color(200, 251, 206);

        cont.setBackground(blue);
        menu = new JMenuBar();
        menu.setBackground(Color.white);
        arch = new JMenu("Archive");
        version = new JMenuItem("Versión");
        leave = new JMenuItem("leave ");

        et1 = new JLabel("<html>write the path with the name of the text you want to read.<html>");
        et1.setBounds(30, 20, 230, 60);
        et1.setFont(new java.awt.Font("Arial", 0, 14));
        cont.add(et1);

        route = new JTextField();
        route.setBounds(30, 70, 280, 30);
        route.setFont(new java.awt.Font("Arial", 0, 14));
        cont.add(route);

        Search = new JButton("read text");
        Search.setBounds(110, 160, 200, 30);
        Search.setFont(new java.awt.Font("Arial", 0, 14));
        Search.addActionListener(this);
        cont.add(Search);

        pers = new JLabel("Number of words");
        pers.setBounds(110, 160, 200, 30);
        pers.setFont(new java.awt.Font("Arial", 0, 14));
        cont.add(pers);

        num = new JLabel("number of numbers");
        num.setBounds(30, 190, 200, 30);
        num.setFont(new java.awt.Font("Arial", 0, 14));
        cont.add(num);

        area = new JTextArea("");
        sc = new JScrollPane(area);
        sc.setBounds(30, 230, 280, 200);
        sc.setFont(new java.awt.Font("Arial", 0, 14));
        cont.add(sc);

    }

    public void ReadTxt() throws FileNotFoundException, IOException {
        StreamTokenizer st = new StreamTokenizer(new FileReader("" + rut));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            if (st.ttype == StreamTokenizer.TT_WORD) {
                cont1++;
            } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                cont2++;
            }
        }
        pers.setText("Number of words: " + cont1);
        num.setText("number of numbers: " + cont2);

    }
    class Order extends JPanel
    {  	//JTextArea reg=new JTextArea();
    	JButton ascendente=new JButton("ascending");
    	JButton descendente=new JButton("descendant");
    	//JScrollPane sc=new JScrollPane(reg);
    	Order()
    	{	add(ascendente);
    		add(descendente);
    		ascendente.addActionListener(
    		
               {{;
                        
                        }
    public void WriteTxt() throws FileNotFoundException, IOException {
        area.setText("");
        try {
            archive = new File("C:\\Users\\soporte\\Documents\\NetBeansProjects\\Project" + rut);
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                area.setText(area.getText() + linea + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }

    public void actionPerformed(ActionEvent event) {
        if (Search == event.getSource()) {
            rut = route.getText();
            route.setText("");
            if (rut.length() != 0) {
                try {
                    readTxt();
                    WriteTxt();
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "the text is empty, try again");
                area.setText("");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        obj = new Interface();
        obj.setVisible(true);
        obj.setResizable(false);
    }

    private void setResizable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setTitle(String aplicación) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLayout(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
