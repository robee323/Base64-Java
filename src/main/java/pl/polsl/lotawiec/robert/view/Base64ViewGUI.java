/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pl.polsl.lotawiec.robert.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pl.polsl.lotawiec.robert.enums.OperationsTypes;
import pl.polsl.lotawiec.robert.model.Base64Model;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;

/**
 * View class utilizing a graphical user interface.
 * Loads data from user and executes selected operation.
 * @author Robert Lotawiec
 * @version 1.2
 */
public class Base64ViewGUI extends javax.swing.JFrame {
    
     /** A regex that the input string has to match to be encoded from ASCII to BASE64*/
    private static final String PATTERN_BASE64 = "^([A-Za-z0-9+_]{4})*([A-Za-z0-9+_]{3}=|[A-Za-z0-9+_]{2}==)?$";
    
    /** A regex that the input string has to match to be dencoded from BASE64 to ASCII*/
    private static final String PATTERN_ASCII = "^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*";
    
    /** Variable for information about chosen mode*/
    private boolean decryptMode = false;
    
    /** OperationsHistoryTableModel object storing all data from executions*/
    //private TableDataDraft historyData;
    
    /** Base64Model object used to execute operation on given by user data*/
    private Base64Model model = new Base64Model();;
  
    /** Field for view of application. */
    private Base64ViewConsole view = new Base64ViewConsole();
    
    /** Initialization of OperationTypes object used in historyTable*/
    private OperationsTypes performedOperation = null;

    /**
     * Creates new Base64GUI form
     */
    public Base64ViewGUI() {
        model = new Base64Model();
        initComponents();
    }

    /**
     * Method initializing components.
     * Auto-generated.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        encryptDecryptPanel = new javax.swing.JPanel();
        executeButton = new javax.swing.JButton();
        inputModeLabel = new javax.swing.JLabel();
        inputTextLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputText = new javax.swing.JTextArea();
        inputTextMode = new javax.swing.JTextField();
        inputString = new javax.swing.JTextField();
        historyPanel = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        optionBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        changeTabItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        executeButton.setText("Perform");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        inputModeLabel.setText("Input mode (d fo decryption or e for encryption):");

        inputTextLabel.setText("Input text to operate on:");

        outputLabel.setText("Output");

        outputText.setEditable(false);
        outputText.setColumns(20);
        outputText.setRows(5);
        jScrollPane1.setViewportView(outputText);

        inputString.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        // Code adding the component to the parent container - not shown here

        javax.swing.GroupLayout encryptDecryptPanelLayout = new javax.swing.GroupLayout(encryptDecryptPanel);
        encryptDecryptPanel.setLayout(encryptDecryptPanelLayout);
        encryptDecryptPanelLayout.setHorizontalGroup(
            encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptDecryptPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(encryptDecryptPanelLayout.createSequentialGroup()
                        .addComponent(outputLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encryptDecryptPanelLayout.createSequentialGroup()
                        .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputModeLabel)
                            .addComponent(inputTextMode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTextLabel)
                            .addGroup(encryptDecryptPanelLayout.createSequentialGroup()
                                .addComponent(inputString, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(executeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        encryptDecryptPanelLayout.setVerticalGroup(
            encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encryptDecryptPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputModeLabel)
                    .addComponent(inputTextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(encryptDecryptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(executeButton)
                        .addComponent(inputString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(encryptDecryptPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(inputTextMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(outputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPane.addTab("Encryption/Decryption", encryptDecryptPanel);

        clearButton.setText("Clear the table");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Mode", "Input message", "Output message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(historyTable);

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton))
        );

        tabbedPane.addTab("Performed operations", historyPanel);

        fileMenu.setText("File");

        changeTabItem.setText("Show history of operations");
        changeTabItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTabItemActionPerformed(evt);
            }
        });
        fileMenu.add(changeTabItem);

        optionBar.add(fileMenu);

        setJMenuBar(optionBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Checks if decrypt, encrypt or an invalid mode has been selected
    * Defaults to encrypt.
    * 
    * @param mode Inserted by user mode (direction of execution the program) 
    * @return true for decryption and false for encryption mode.
    */
    private boolean checkIfDecryptModeGUI(String mode) {
              
           try
            {
               view.modeValidation(mode);
            }
            catch (IllegalCharacterException error)
            {
                createNonModalDialog(error.getMessage());
            }
            if("d".equals(mode))
            {
            return decryptMode=true;  
            }
            else return decryptMode=false;
        
    }
    
    /**
     * Changes tabbedPane to display data table after button is clicked.
     * Visible in menu bar.
     * @param evt ActionEvent parameter.
     */
    private void changeTabItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTabItemActionPerformed
        // TODO add your handling code here:
        tabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_changeTabItemActionPerformed

    /**
     * Loads data from input and executes operations.
     * Main method of logic in GUI. 
     * @param evt ActionEvent parameter.
     */
    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        // TODO add your handling code here:
        //reading from text field mode of program's execution
        String mode;
        mode = inputTextMode.getText();
        //reading from text field input string for program's execution
        String input;
        input = inputString.getText();
        //Initialization of output string
        String output = "";
        
        boolean validated = true;
        try{
            view.modeValidation(mode);
        }
        catch(IllegalCharacterException e){ //data is incorrect
            //popup window here
            createNonModalDialog(e.getMessage());
            //after first read user will type data using console
            //validated = false;
            return;
        }
        validated = true;
        //string validation depending on the mode of program
        if(checkIfDecryptModeGUI(mode))
        {   
            //decrypt mode
            try 
            {
                model.validateString(input, PATTERN_BASE64);
            } 
            catch (IllegalCharacterException error) 
            {
                createNonModalDialog(error.getMessage());
                //validated = false;
                return;
            }
            validated = true;        
           
                       
        }
        else
        {
            //encrypt mode
            try 
            {
                model.validateString(input, PATTERN_ASCII);
            } 
            catch (IllegalCharacterException error) 
            {
                createNonModalDialog(error.getMessage());
                //validated = false;
                return;
                
            }
            validated = true;
        }
        
        if(validated){
           /* 
            Object[] options = {"encode data", "decode data"};
            String decisionString = (String)JOptionPane.showInputDialog(this, "Choose the operation: ","Customised dialog", JOptionPane.PLAIN_MESSAGE, null, options, "encode data");
            */
            switch (mode) {
                case "e":
                output = model.encode(input);
                //printData(decisionString, output);
                printData("Encoded Data", output);
                JOptionPane.showMessageDialog(this, "Operation completed successfully!\n\rThe encrypted data is in the Message field");
                performedOperation = OperationsTypes.ENCRYPTION;
                break;
                case "d":
                output = model.decode(input);
                //printData(decisionString, output);
                JOptionPane.showMessageDialog(this, "Operation completed successfully!\n\rThe decrypted data is in the Message field");
                printData("Decoded Data", output);
                performedOperation = OperationsTypes.DECRYPTION;
                break;
                default:
                createNonModalDialog("Invalid Mode"); 
                break;
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        model.addRow(new Object[]{new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()), performedOperation, input, output});
    }//GEN-LAST:event_executeButtonActionPerformed

    /**
     * Clears the contents of the table tab when button is clicked..
     * @param evt ActionEvent parameter.
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * Creates a non-modal dialog to inform the user or request some input.
     * @param message Message to pass in the dialog.
     */
    private void createNonModalDialog(String message){
        //create window
        final JDialog dialog = new JDialog(this,
                                           "Error message!");
        //text label                   
        JLabel label = new JLabel("<html><p align=center>"
            + message + ".<br>");
        label.setHorizontalAlignment(JLabel.CENTER);
        Font font = label.getFont();
        label.setFont(label.getFont().deriveFont(font.PLAIN,
                                                 14.0f));
        //close window button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });

        // panel for close window button
        JPanel closePanel = new JPanel();
        closePanel.setLayout(new BoxLayout(closePanel,
                                           BoxLayout.LINE_AXIS));
        closePanel.add(Box.createHorizontalGlue());
        closePanel.add(closeButton);
        closePanel.setBorder(BorderFactory.
            createEmptyBorder(0,0,5,5));

        //panel with a label and the panel above
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(closePanel, BorderLayout.PAGE_END);
        contentPane.setOpaque(true);
        dialog.setContentPane(contentPane);

        //show all
        dialog.setSize(new Dimension(300, 150));
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    /**
     * Prints out data from finihsed operation.
     * @param decision String variable telling what type of operation has been performed.
     * @param messages Vararg strings with messages to output.
     */
    public void printData(String decision, String... messages){
        outputText.setText("");
        switch (decision) {
            case "d":
                outputText.append("Decoded data: " + messages[0] + "\n");
                break;
            case "e":
                outputText.append("Encoded data: " + messages[0] + "\n");
                break;
            default:
            for(int i=0; i<messages.length; i++){
                if(i == 0){
                    outputText.append("Encoded data: " + messages[i] + "\n");
                }
                else if(i == 1){
                    outputText.append("Decoded data: " + messages[i] + "\n");
                }
                else   
                    break;
            }    break;
        }
        
    }
    
    /**
     * Method called from controller to initialize GUI creation.
     * @param args String arguments passed in controller.
     */
    public static void setView(String args[]) {
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
            java.util.logging.Logger.getLogger(Base64ViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base64ViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base64ViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base64ViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base64ViewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
   /** MenuItem used to change tab to historyPanel */
    private javax.swing.JMenuItem changeTabItem;
    /** Main menu located on top of main screen */
    private javax.swing.JMenu fileMenu;
    /** Label indicating place for input string */
    private javax.swing.JLabel inputTextLabel;
    /** TextField for input string variable */
    private javax.swing.JTextField inputString;
    /** Scroll panel */
    private javax.swing.JScrollPane jScrollPane1;
    /** Scroll panel */
    private javax.swing.JScrollPane jScrollPane2;
    /** Label indicating place for mode */
    private javax.swing.JLabel inputModeLabel;
    /** TextField for mode variable */
    private javax.swing.JTextField inputTextMode;
    /** Button that prompts data loading and algorithm execution */
    private javax.swing.JButton executeButton;
    /** Panel showing input and output data of current iteration */
    private javax.swing.JPanel encryptDecryptPanel;
    /** MenuBar showing one menu tab for changing panel tab */
    private javax.swing.JMenuBar optionBar;
    /** Table showing data from all operations made during runtime */
    private javax.swing.JTable historyTable;
    /** Label indicating output of the program */
    private javax.swing.JLabel outputLabel;
    /** TextArea for output of the program */
    private javax.swing.JTextArea outputText;
    /** Button used to clear the data loaded in the table */
    private javax.swing.JButton clearButton;
    /** Main tabbed pane */
    private javax.swing.JTabbedPane tabbedPane;
    /** Panel used to show the table and its elements */
    private javax.swing.JPanel historyPanel;
    // End of variables declaration//GEN-END:variables
}
