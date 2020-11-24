package com.mycompany.new_lab02;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *Main window of the interface
 * @author szymon
 */
public class main_window extends javax.swing.JFrame {

    /**
     * Creates new form main_window
     */
    
    Parser parser;
    Connection connection;
    boolean first_launch;
    Language_Loader ll;
    
    ArrayList<Movie_Data> results;
    
    public main_window() throws UnsupportedEncodingException {
        connection = new Connection("68ec271051msh29bb8b23c243484p1d0efejsn7efe463444ac");
        first_launch = true;
        parser = null;
        results = null;
        initComponents();
        setLocationRelativeTo(null);
        reset_window("ENG");
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textfield_title = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        combobox_result = new javax.swing.JComboBox<>();
        label_results = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea_details = new javax.swing.JTextArea();
        combobox_langpicker = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMBD Title Searcher");

        textfield_title.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        textfield_title.setText("Type title here...");
        textfield_title.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfield_titleFocusGained(evt);
            }
        });

        button_search.setText("Search");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        combobox_result.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combobox_result.setMaximumSize(new java.awt.Dimension(61, 23));
        combobox_result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_resultActionPerformed(evt);
            }
        });

        label_results.setText("Results");

        textarea_details.setColumns(20);
        textarea_details.setRows(5);
        jScrollPane1.setViewportView(textarea_details);

        combobox_langpicker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "French", "Polish" }));
        combobox_langpicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_langpickerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_results)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_search, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_result, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combobox_langpicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_search, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_results)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combobox_result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_langpicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Handler event - getting window focus
     * @param evt 
     */
    private void textfield_titleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfield_titleFocusGained
        if ( !first_launch ){
            reset_window("ENG");
        }
        else{
            textfield_title.setText("");
        }
    }//GEN-LAST:event_textfield_titleFocusGained
    /**
     * Handler event - pressing button 'search'
     * @param evt 
     */
    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        button_search.setText("Running...");
        first_launch = false;
        textarea_details.setVisible(true);
        if (textfield_title.getText().isBlank()){
            textfield_title.setText("");
        }
        else{
            try {
                parser = new Parser(connection.find_movie(textfield_title.getText()));
                
                results = parser.parse();
                
                if ( results.size() > 0 ){
                    fill_combobox(results,combobox_result);
                    combobox_result.setEnabled(true);
                }
                else{
                    blank_combobox(combobox_result,"No results");
                }
            } catch (UnirestException ex) {
                Logger.getLogger(main_window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_button_searchActionPerformed

    /**
     * Handler event - getting combobox result
     * @param evt 
     */
    private void combobox_resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_resultActionPerformed
        for( Movie_Data movie : results ){
            if ( movie.label().equals(combobox_result.getSelectedItem().toString())){
                fill_textarea(movie.show());
            }
        }
    }//GEN-LAST:event_combobox_resultActionPerformed
    
    /**
     * Handler event - getting combobox result
     * @param evt 
     */
    private void combobox_langpickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_langpickerActionPerformed
        String data = combobox_langpicker.getSelectedItem().toString();
        reset_window(data);
    }//GEN-LAST:event_combobox_langpickerActionPerformed

    
    /**
     * Funcition for resseting window to default
     */
    void reset_window(String lang){
        
        switch(lang){
            case "English":
                ll = new Language_Loader("ENG");
                break;
            case "Polish":
                ll = new Language_Loader("PL");
                break;
            case "French":
                ll = new Language_Loader("FR");
                break;
            default:
                ll = new Language_Loader("ENG");
                break;   
        }
        
        ll.get_data();
        
        textarea_details.setText(ll.results.get(0));
        button_search.setText(ll.results.get(1));
        label_results.setText(ll.results.get(2));

        combobox_result.setEnabled(false);
        blank_combobox(combobox_result,"None");
        
        textarea_details.setVisible(false);
        results = null;
    }
    
    /**
     * Function for inserting data to JTextArea object
     * @param text 
     */
    void fill_textarea(ArrayList<String> text){
        String content = "";
        
        for(String line : text){
            content = content + line + "\n";
        }
        
        textarea_details.setText(content);
    }
    /**
     * Function for inserting data to JTextArea object
     * @param text 
     */
    void fill_textarea(String text){
        textarea_details.setText(text);
    }
    
    /**
     * Function for clearing combobox object
     * @param to_fill 
     */
    void blank_combobox(JComboBox to_fill,String text){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        dcm.addElement(text);
        to_fill.setModel(dcm);
    }

    /**
     * Function for filling combobox
     * @param data
     * @param to_fill 
     */
    void fill_combobox(ArrayList<Movie_Data> data,JComboBox to_fill){
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        
        for(Movie_Data md : data){
            dcm.addElement(md.label());
        }
        
        to_fill.setModel(dcm);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_search;
    private javax.swing.JComboBox<String> combobox_langpicker;
    private javax.swing.JComboBox<String> combobox_result;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_results;
    private javax.swing.JTextArea textarea_details;
    private javax.swing.JTextField textfield_title;
    // End of variables declaration//GEN-END:variables
}
