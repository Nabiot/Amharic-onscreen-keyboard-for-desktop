
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nabiot
 */
public class Additional extends javax.swing.JDialog {

    JTextArea area;
    JButton additionalLetters[] = new JButton[10];
    JButton others[] = new JButton[44];
    String othersText[] = {"፡", "።", "፣", "፤", "፥", "፦", "፧", "፨",
        "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩",
        "\"", "\'", "/", "\\", "+", ",", "-", "_", ".", ":", ";", "?",
        "[", "]", "{", "}", "|", "®", "©", "£", "¥", "¡", "<", "=", ">", "¬"};

    int start = 0x1200;

    /**
     * Creates new form Additional
     */
    public Additional(java.awt.Frame parent, boolean modal, JTextArea textArea) {
        super(parent, modal);
        area = textArea;
        initComponents();
        fillAdditionalLetters();
        fillOthersPanel();

        int parentWidth = parent.getWidth();
        int parentX = parent.getX();
        int parentHeight = parent.getHeight();
        int parentY = parent.getY();

        setLocation((parentWidth / 2) - (getWidth() / 2) + parentX, (parentHeight) + parentY);
        pack();
    }

    public void fillAdditionalLetters() {
        additionalLettersPanel.removeAll();
        additionalLettersPanel.setLayout(new GridLayout(10, 7));
        for (int i = 0, j = 1; i < 10; j++) {

            if (!(j == 10 || j == 11 || j == 12 || j == 14 || j == 18 || j == 23 || j == 25 || j == 32 || j == 35 || j == 36)) {
                start += 8;
                continue;
            }
            additionalLetters[i] = new JButton();
            additionalLetters[i].setOpaque(false);
            additionalLetters[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            additionalLetters[i].setHorizontalAlignment(JButton.CENTER);
            additionalLetters[i].setText(Character.toString((char) start));
            additionalLetters[i].setActionCommand(additionalLetters[i].getText());
            additionalLetters[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    area.grabFocus();
                    String str = area.getText();
                    int place = area.getCaretPosition();
                    area.setText(str.substring(0, place) + e.getActionCommand() + str.substring(place, str.length()));
                }
            });
            additionalLettersPanel.add(additionalLetters[i]);
            spreadWord(start);
            i++;
            start += 8;

        }
    }

    public void fillOthersPanel() {
        JPanel p1 = new JPanel(new GridLayout(1, 8));
        JPanel p2 = new JPanel(new GridLayout(1, 10));
        JPanel p3 = new JPanel(new GridLayout(1, 12));
        JPanel p4 = new JPanel(new GridLayout(1, 14));
        othersPanel.removeAll();
        othersPanel.setLayout(new GridLayout(10, 7));
        for (int i = 0; i < others.length; i++) {
            others[i] = new JButton();
            others[i].setOpaque(false);
            others[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            others[i].setHorizontalAlignment(JButton.CENTER);
            others[i].setText(othersText[i]);
            others[i].setActionCommand(others[i].getText());
            others[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    area.grabFocus();
                    String str = area.getText();
                    int place = area.getCaretPosition();
                    area.setText(str.substring(0, place) + e.getActionCommand() + str.substring(place, str.length()));
                }
            });
        }
        for (int j = 0; j < 8; j++) {
            p1.add(others[j]);
        }

        for (int j = 8; j < 18; j++) {
            others[j].setFont(new Font("Cambria", Font.PLAIN, 15));
            p2.add(others[j]);
        }

        for (int j = 18; j < 30; j++) {
            p3.add(others[j]);
        }

        for (int j = 30; j < 44; j++) {
            p4.add(others[j]);
        }

        othersPanel.add(p1);
        othersPanel.add(p2);
        othersPanel.add(p3);
        othersPanel.add(p4);
        refresh();
    }

    public void spreadWord(int charCode) {
        JButton options[] = new JButton[7];
        for (int i = 0; i < 7; i++, charCode++) {
            options[i] = new JButton();
            options[i].setText(Character.toString((char) charCode));
            options[i].setOpaque(false);
            options[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            options[i].setHorizontalAlignment(JButton.CENTER);
            options[i].setActionCommand(options[i].getText());
            options[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    area.grabFocus();
                    String str = area.getText();
                    int place = area.getCaretPosition();
                    area.setText(str.substring(0, place) + e.getActionCommand() + str.substring(place, str.length()));
                }
            });
            additionalLettersPanel.add(options[i]);
        }
        additionalLettersPanel.repaint();
        refresh();
    }

    public void refresh() {
        setSize(getWidth() + 1, getHeight() + 1);
        setSize(getWidth() - 1, getHeight() - 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        close = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        additionalLettersPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        othersPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        close.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        close.setForeground(new java.awt.Color(255, 0, 0));
        close.setText("X");
        close.setOpaque(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(close))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.setFont(new java.awt.Font("Nyala", 0, 16)); // NOI18N
        jTabbedPane1.setOpaque(true);

        javax.swing.GroupLayout additionalLettersPanelLayout = new javax.swing.GroupLayout(additionalLettersPanel);
        additionalLettersPanel.setLayout(additionalLettersPanelLayout);
        additionalLettersPanelLayout.setHorizontalGroup(
            additionalLettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        additionalLettersPanelLayout.setVerticalGroup(
            additionalLettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(additionalLettersPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("ተጨማሪ ፊደላት", jPanel1);

        javax.swing.GroupLayout othersPanelLayout = new javax.swing.GroupLayout(othersPanel);
        othersPanel.setLayout(othersPanelLayout);
        othersPanelLayout.setHorizontalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        othersPanelLayout.setVerticalGroup(
            othersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 155, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(othersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(othersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("የተለያዩ", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
       dispose();
    }//GEN-LAST:event_closeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel additionalLettersPanel;
    private javax.swing.JButton close;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel othersPanel;
    // End of variables declaration//GEN-END:variables
}
