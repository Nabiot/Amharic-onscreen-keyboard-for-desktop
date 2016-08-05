
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.*;

/**
 * Amharic Keyboard Application.
 *
 * @author Assosa University
 */
public class MainFrame extends javax.swing.JFrame {

    String ethiopicNumbers[] = {"፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱", "፲", "፳", "፴", "፵", "፶", "፷", "፸", "፹", "፺", "፻", "፼"};
    String punctuationText[] = {"፡", "።", "፣", "፤", "፥", "፦", "፧", "፨"};

    JButton ethiopic[] = new JButton[20];
    JButton letters[] = new JButton[33];
    JButton punctuation[] = new JButton[8];
    JButton special[] = new JButton[3];

    boolean onOff = true, num = false;
    int shift = 0;
    int start = 0x1200;
    OptionListener opListener = new OptionListener();
    WriteListener wrListener = new WriteListener();
    
        int parentWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
       
        int parentHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        fillLetters();
        fillNumPanel1();
        fillSpecialPanel();
        pack();
        setLocation((parentWidth / 2) - (getWidth() / 2) , (parentHeight / 2) - (getHeight() / 2));
    }

    public void fillLetters() {
        lettersPanel.removeAll();
        lettersPanel.setLayout(new GridLayout(3, 11));
        for (int i = 0, j = 1; i <= 32; j++) {
            if (j == 10 || j == 11 || j == 12 || j == 14 || j == 18 || j == 23 || j == 25 || j == 32 || j == 35 || j == 36) {
                start += 8;
                continue;
            }
            letters[i] = new JButton();
            letters[i].setOpaque(false);
            letters[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            letters[i].setHorizontalAlignment(JButton.CENTER);
            letters[i].setText(Character.toString((char) start));
            letters[i].setActionCommand(letters[i].getText());
            letters[i].addActionListener(opListener);
            lettersPanel.add(letters[i]);
            i++;
            start += 8;
        }

        optionPanel.removeAll();
        optionPanel.setLayout(new GridLayout(1, 8));
        optionPanel.repaint();
        for (int i = 0; i < punctuation.length; i++) {
            punctuation[i] = new JButton();
            punctuation[i].setText(punctuationText[i]);
            punctuation[i].setOpaque(false);
            punctuation[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            punctuation[i].setHorizontalAlignment(JButton.CENTER);
            optionPanel.add(punctuation[i]);
        }
        refresh();
    }

    public void fillNumPanel1() {
        numPanel1.removeAll();
        numPanel1.setLayout(new GridLayout(5, 4));
        for (int i = 0; i < ethiopicNumbers.length; i++) {
            ethiopic[i] = new JButton();
            ethiopic[i].setOpaque(false);
            ethiopic[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            ethiopic[i].setHorizontalAlignment(JButton.CENTER);
            ethiopic[i].setText(ethiopicNumbers[i]);
            ethiopic[i].setActionCommand(ethiopic[i].getText());
            ethiopic[i].addActionListener(wrListener);
            numPanel1.add(ethiopic[i]);
        }
        refresh();
    }

    public void fillSpecialPanel() {

        JToggleButton shift = new JToggleButton();
        shift.setText("⇧");
        shift.setOpaque(false);
        shift.setHorizontalAlignment(JButton.CENTER);
        shift.setFont(new Font("Cambria", Font.PLAIN, 13));

        specialPanel.removeAll();
        GridBagConstraints g = new GridBagConstraints();
        specialPanel.setLayout(new GridBagLayout());
        String text[] = {"⇥", "⟵", "↩"};
        for (int i = 0; i < 3; i++) {
            special[i] = new JButton();
            special[i].setFont(new Font("Cambria", Font.PLAIN, 13));
            special[i].setOpaque(false);
            special[i].setHorizontalAlignment(JButton.CENTER);
            special[i].setText(text[i]);
        }
        g.ipady = 2;
        g.gridy = 1;
        g.gridx = 1;
        specialPanel.add(special[0], g);
        g.gridy = 2;
        g.gridx = 1;
        specialPanel.add(special[1], g);
        g.gridy = 3;
        g.gridx = 1;
        specialPanel.add(special[2], g);
        g.gridy = 4;
        g.gridx = 1;
        specialPanel.add(shift, g);

        special[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area.grabFocus();
                String str = area.getText();
                int place = area.getCaretPosition();
                area.setText(str.substring(0, place) + "\t" + str.substring(place, str.length()));
            }
        });

        special[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area.grabFocus();
                String str = area.getText();
                int place = area.getCaretPosition();
                area.setText(str.substring(0, place-1) + str.substring(place, str.length()));
            }
        });

        special[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 area.grabFocus();
                String str = area.getText();
                int place = area.getCaretPosition();
                 area.setText(str.substring(0, place) + "\n" + str.substring(place, str.length()));
            }
        });
        shift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shiftActionPerformed(e);
            }
        });
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

        MainPanel = new javax.swing.JPanel();
        lettersPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        numPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        space = new javax.swing.JButton();
        lock = new javax.swing.JButton();
        add = new javax.swing.JButton();
        specialPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        additional = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yeneta Amharic Screen Keyboard");

        javax.swing.GroupLayout lettersPanelLayout = new javax.swing.GroupLayout(lettersPanel);
        lettersPanel.setLayout(lettersPanelLayout);
        lettersPanelLayout.setHorizontalGroup(
            lettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lettersPanelLayout.setVerticalGroup(
            lettersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout numPanel1Layout = new javax.swing.GroupLayout(numPanel1);
        numPanel1.setLayout(numPanel1Layout);
        numPanel1Layout.setHorizontalGroup(
            numPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        numPanel1Layout.setVerticalGroup(
            numPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        space.setText(" ");
        space.setOpaque(false);
        space.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaceActionPerformed(evt);
            }
        });

        lock.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lock.setText("\u23CF");
        lock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockActionPerformed(evt);
            }
        });

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addimage.png"))); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(space, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(space, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lock, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout specialPanelLayout = new javax.swing.GroupLayout(specialPanel);
        specialPanel.setLayout(specialPanelLayout);
        specialPanelLayout.setHorizontalGroup(
            specialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        specialPanelLayout.setVerticalGroup(
            specialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lettersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(specialPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(numPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lettersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(specialPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        area.setColumns(20);
        area.setFont(new java.awt.Font("Nyala", 0, 16)); // NOI18N
        area.setRows(5);
        area.setTabSize(6);
        jScrollPane1.setViewportView(area);

        jMenu1.setText("አማራጭ");
        jMenu1.setFont(new java.awt.Font("Nyala", 0, 12)); // NOI18N

        exit.setFont(new java.awt.Font("Nyala", 0, 12)); // NOI18N
        exit.setText("መውጫ");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        additional.setText("ስለ ሶፍትዌሩ");
        additional.setFont(new java.awt.Font("Nyala", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Nyala", 0, 12)); // NOI18N
        jMenuItem1.setText("ስለ ሠሪዎቹ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        additional.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Nyala", 0, 12)); // NOI18N
        jMenuItem2.setText("ተጨማሪ");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        additional.add(jMenuItem2);

        jMenuBar1.add(additional);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockActionPerformed

        String text[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        optionPanel.removeAll();
        int last;
        if (!onOff) {
            num = false;
            last = 8;
            optionPanel.setLayout(new GridLayout(1, 8));
        } else {
            num = true;
            last = 10;
            optionPanel.setLayout(new GridLayout(1, 10));
        }
        optionPanel.repaint();
        JButton options[] = new JButton[10];
        for (int i = 0; i < last; i++) {
            options[i] = new JButton();
            if (!onOff) {
                options[i].setText(punctuationText[i]);
            } else {
                options[i].setText(text[i]);
            }
            options[i].setOpaque(false);
            options[i].setNextFocusableComponent(rootPane);
            options[i].setFont(new Font("Nyala", Font.PLAIN, 17));
            options[i].setHorizontalAlignment(JButton.CENTER);
            options[i].setActionCommand(options[i].getText());
            options[i].addActionListener(wrListener);
            optionPanel.add(options[i]);
        }
        optionPanel.repaint();
        refresh();
        onOff = !onOff;
        area.grabFocus();
    }//GEN-LAST:event_lockActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Additional additional = new Additional(this, false, area);
        additional.setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void spaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaceActionPerformed
        area.setText(area.getText() + " ");
        area.grabFocus();
        start=0x1200;
        fillLetters();
    }//GEN-LAST:event_spaceActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(start);
    }//GEN-LAST:event_exitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        About a=new About(this, true);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         About2 a=new About2(this, true);
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void shiftActionPerformed(ActionEvent e) {
        String text1[] = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
        String text2[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        if (num) {
            optionPanel.removeAll();
            optionPanel.setLayout(new GridLayout(1, 10));
            optionPanel.repaint();
            JButton options[] = new JButton[10];
            for (int i = 0; i < 10; i++) {
                options[i] = new JButton();
                options[i].setText(text1[i]);
                options[i].setOpaque(false);
                options[i].setNextFocusableComponent(rootPane);
                options[i].setActionCommand(options[i].getText());
                options[i].setFont(new Font("Nyala", Font.PLAIN, 17));
                options[i].setHorizontalAlignment(JButton.CENTER);
                options[i].addActionListener(wrListener);
                optionPanel.add(options[i]);
            }
            optionPanel.repaint();
            refresh();
            num = false;
            shift = 1;
        } else if (num == false && shift == 1) {

            optionPanel.removeAll();
            optionPanel.setLayout(new GridLayout(1, 10));
            optionPanel.repaint();
            JButton options[] = new JButton[10];
            for (int i = 0; i < 10; i++) {
                options[i] = new JButton();
                options[i].setNextFocusableComponent(rootPane);
                options[i].setText(text2[i]);
                options[i].setOpaque(false);
                options[i].setFont(new Font("Nyala", Font.PLAIN, 17));
                options[i].setActionCommand(options[i].getText());
                options[i].setHorizontalAlignment(JButton.CENTER);
                options[i].addActionListener(wrListener);
                optionPanel.add(options[i]);
            }
            optionPanel.repaint();
            refresh();
            num = true;
            shift = 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            Properties p = new Properties();
            p.put("windowDecoration", "off");
            p.put("logoString", "");
            GraphiteLookAndFeel.setCurrentTheme(p);
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    class WriteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            area.grabFocus();
            String str = area.getText();
            int place = area.getCaretPosition();
            area.setText(str.substring(0, place) + e.getActionCommand() + str.substring(place, str.length()));
        }
    }

    class OptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = e.getActionCommand();
            char c = text.charAt(0);
            int unicode = (int) c;
            optionPanel.removeAll();
            optionPanel.setLayout(new GridLayout(1, 8));
            optionPanel.repaint();
            JButton options[] = new JButton[8];
            for (int i = 0; i < 8; i++, unicode++) {
                options[i] = new JButton();
                options[i].setText(Character.toString((char) unicode));
                options[i].setOpaque(false);
                options[i].setActionCommand(options[i].getText());
                options[i].setFont(new Font("Nyala", Font.PLAIN, 17));
                options[i].setHorizontalAlignment(JButton.CENTER);
                options[i].addActionListener(wrListener);
                optionPanel.add(options[i]);

            }
            optionPanel.repaint();
            refresh();
            area.grabFocus();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton add;
    private javax.swing.JMenu additional;
    private javax.swing.JTextArea area;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lettersPanel;
    private javax.swing.JButton lock;
    private javax.swing.JPanel numPanel1;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton space;
    private javax.swing.JPanel specialPanel;
    // End of variables declaration//GEN-END:variables
}
