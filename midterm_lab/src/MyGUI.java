
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author shin
 */
class Pet {
// id, name, type, age, price

    private String id;
    private String name;
    private String type;
    private int age;
    private int price;
    private static Random rn = new Random();

    public Pet(String id, String name, String type, int age, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + type + "," + age + "," + price;
    }

    public static String genId() {

        int type_id = rn.nextInt(2);
        String str = "";
        if (type_id == 0) {
            char ch[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            int index = rn.nextInt(ch.length);
            str += ch[index];
            for (int i = 0; i < 3; i++) {
                str += rn.nextInt(10);
            }

        } else {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    char ch[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                    int index = rn.nextInt(ch.length);
                    str += ch[index];
                } else {
                    str += rn.nextInt(10);
                }
            }
        }
        System.out.println("type : " + type_id);
        return str;
    }

    public static String genName() {
        String str = "";
        char ch[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
//        3-10
        int loop = rn.nextInt(8) + 3;
        for (int i = 0; i < loop; i++) {
            int index = rn.nextInt(ch.length);
            str += ch[index];
        }
        System.out.println("size : " + str.length());
        return str;
    }

    public static String genType() {
        int type = rn.nextInt(2);
        if (type == 0) {
            return "Dog";
        } else {
            return "Cat";
        }
    }

    public static int genAge() {
        return rn.nextInt(10) + 1;
    }

    public static int genPrice() {
        return rn.nextInt(99000) + 1000;
    }

    public static Pet generatePet() {
        return new Pet(Pet.genId(), Pet.genName(), Pet.genType(), Pet.genAge(), Pet.genPrice());
    }
}

class MyList {

    private ArrayList<Pet> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void addFirst(Pet p) {
        list.addFirst(p);
    }

    public Pet deleteFirst() {
        Pet p = list.removeLast();
        return p;
    }

    public ArrayList<Pet> getList() {
        return list;
    }

}

public class MyGUI extends javax.swing.JFrame {

    Stack<Pet> stack1 = new Stack<Pet>();
    MyList list1 = new MyList();

    public void dataTable(MyList v) {

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);

        for (Pet x : v.getList()) {
            System.out.println(x);
        }

        Object row[] = new Object[5];
        for (int i = 0; i < v.getList().size(); i++) {
            row[0] = v.getList().get(i).getId();
            row[1] = v.getList().get(i).getName();
            row[2] = v.getList().get(i).getType();
            row[3] = v.getList().get(i).getAge();
            row[4] = v.getList().get(i).getPrice();

            model.addRow(row);
        }

    }

    public void dataTable(Stack<Pet> v) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        // Print out the stack elements
        for (Pet x : v) {
            System.out.println(x);
        }

        Object row[] = new Object[5];

        // Process stack elements
        for (Pet pet : v) {
            row[0] = pet.getId();
            row[1] = pet.getName();
            row[2] = pet.getType();
            row[3] = pet.getAge();
            row[4] = pet.getPrice();

            model.addRow(row);
        }
    }

    /**
     * Creates new form MyGUI
     */
    public MyGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Assign = new javax.swing.JButton();
        Generate = new javax.swing.JButton();
        Takeout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("0760123456 – Morty Smith : Midterm");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Age", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Age", "Price"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cat");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Dog");

        jTextField1.setEditable(false);
        jTextField1.setEnabled(false);

        Assign.setText("Assign");
        Assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssignActionPerformed(evt);
            }
        });

        Generate.setText("Generate");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        Takeout.setText("Takeout");
        Takeout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Generate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Assign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Takeout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Assign, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Takeout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        // TODO add your handling code here:
        Pet p = Pet.generatePet();
        jTextField1.setText(p.toString());
    }//GEN-LAST:event_GenerateActionPerformed

    private void AssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssignActionPerformed
        // TODO add your handling code here:
        String str[] = jTextField1.getText().split(",");
        Pet p = new Pet(str[0], str[1], str[2], Integer.parseInt(str[3]), Integer.parseInt(str[4]));
        if (p.getType().equals("Cat")) {
            list1.addFirst(p);
        } else {
            stack1.push(p);
        }
        dataTable(list1);
        dataTable(stack1);
    }//GEN-LAST:event_AssignActionPerformed

    private void TakeoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeoutActionPerformed
        // TODO add your handling code here:
        if(stack1.size() > list1.getList().size()){
         Pet p = stack1.pop();
            System.out.println("remove : "+p);
        }else{
            Pet p = list1.deleteFirst();
            System.out.println("remove : "+p);
        }
        dataTable(list1);
        dataTable(stack1);
    }//GEN-LAST:event_TakeoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Assign;
    private javax.swing.JButton Generate;
    private javax.swing.JButton Takeout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
