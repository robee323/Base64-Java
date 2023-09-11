/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lotawiec.robert.view;

/**
 * View class utilizing a graphical user interface.
 * Loads data from user and executes selected operation.
 * @author Robert Lotawiec
 * @version 1.2
 */
public class Base64ViewGUIDocumentation {
    
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
}
