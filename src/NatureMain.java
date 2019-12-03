import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class NatureMain {
    public static int myScore;
    public static void main(String[] args) {
        myScore = 0;
        File folder = new File("images/");
        File[] listOfFiles = folder.listFiles();
        String[] images = new String[listOfFiles.length-4];
        for (int i = 4; i < listOfFiles.length; i++) {
            String filename = listOfFiles[i].getName();
            images[i-4] = filename;
            System.out.println(filename);
        }
        displayImages(images);
    }

    public static void displayImages(String[] scenes) {
        JFrame f = new JFrame("Nature Revision");
        f.setSize(1000, 1000);
        f.setLocation(300, 200);
        final int[] i = {0};
        String filename = scenes[i[0]];
        JLabel imageLabel = new JLabel(new ImageIcon("images/" + filename));
        imageLabel.setBounds(10, 10, 400, 400);
        imageLabel.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(BorderLayout.CENTER, imageLabel);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

        final JButton b1 = new JButton("Fear and Awe");
        final JButton b2 = new JButton("Awe");
        final JButton b3 = new JButton("Meh");
        final JButton b4 = new JButton("Fear");

        p.add(new JLabel("What does this make you feel?  "));
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        JToolBar tb = new JToolBar("toolbar");
        tb.add(p);
        f.add(tb, BorderLayout.NORTH);
        final int[] score = {0};
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myScore += 2;
                if (i[0] < scenes.length - 1) {
                    String filename = "images/" + scenes[i[0] + 1];
                    i[0]++;
                    ImageIcon img = new ImageIcon(filename);
                    imageLabel.setIcon(img);
                } else {
                    p.setVisible(false);
                    String filename = "images/meh.png";
                    if(myScore > 0)
                        filename = "images/good.png";
                    else if (myScore < 0)
                        filename = "images/bad.png";
                    imageLabel.setIcon(new ImageIcon(filename));
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myScore += 1;
                if (i[0] < scenes.length - 1) {
                    String filename = "images/" + scenes[i[0] + 1];
                    i[0]++;
                    ImageIcon img = new ImageIcon(filename);
                    imageLabel.setIcon(img);
                } else {
                    p.setVisible(false);
                    String filename = "images/meh.png";
                    if(myScore > 0)
                        filename = "images/good.png";
                    else if (myScore < 0)
                        filename = "images/bad.png";
                    imageLabel.setIcon(new ImageIcon(filename));
                }
            }
        });
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i[0] < scenes.length - 1) {
                    String filename = "images/" + scenes[i[0] + 1];
                    i[0]++;
                    ImageIcon img = new ImageIcon(filename);
                    imageLabel.setIcon(img);
                } else {
                    p.setVisible(false);
                    String filename = "images/meh.png";
                    if(myScore > 0)
                        filename = "images/good.png";
                    else if (myScore < 0)
                        filename = "images/bad.png";
                    imageLabel.setIcon(new ImageIcon(filename));

                }
            }
        });
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myScore += -1;
                if (i[0] < scenes.length - 1) {
                    String filename = "images/" + scenes[i[0] + 1];
                    i[0]++;
                    ImageIcon img = new ImageIcon(filename);
                    imageLabel.setIcon(img);
                    System.out.println(filename);
                } else {
                    p.setVisible(false);
                    String filename = "images/meh.png";
                    if(myScore > 0)
                        filename = "images/good.png";
                    else if (myScore < 0)
                        filename = "images/bad.png";
                    imageLabel.setIcon(new ImageIcon(filename));

                }
            }
        });
        f.setVisible(true);
    }
}