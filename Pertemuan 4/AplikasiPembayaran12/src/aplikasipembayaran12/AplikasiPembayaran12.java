package aplikasipembayaran12;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

public class AplikasiPembayaran12 { 

    public static void main(String[] args) { 
        JFrame frame = new JFrame("Pembayaran"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(600, 400); 
        frame.setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing

        // Row 1 - NO. MEJA
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        frame.add(new JLabel("NO. MEJA:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 0; 
        JTextField noMejaField = new JTextField(10); 
        frame.add(noMejaField, gbc); 

        // Row 2 - TOTAL PESANAN
        gbc.gridx = 0; 
        gbc.gridy = 1; 
        frame.add(new JLabel("TOTAL PESANAN:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 1; 
        JTextField totalPesananField = new JTextField(10); 
        frame.add(totalPesananField, gbc); 

        // Row 3 - PPN
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        frame.add(new JLabel("PPN:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 2; 
        JTextField ppnField = new JTextField(10); 
        frame.add(ppnField, gbc); 

        // Row 4 - UANG PEMBAYARAN
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        frame.add(new JLabel("UANG PEMBAYARAN:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 3; 
        JTextField uangPembayaranField = new JTextField(10); 
        frame.add(uangPembayaranField, gbc); 

        // Row 5 - UANG KEMBALI
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        frame.add(new JLabel("UANG KEMBALI:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 4; 
        JTextField uangKembaliField = new JTextField(10); 
        uangKembaliField.setEditable(false); // Not editable by user
        frame.add(uangKembaliField, gbc); 

        // Row 6 - STRUK and BAYAR buttons
        gbc.gridx = 0; 
        gbc.gridy = 5; 
        JButton strukButton = new JButton("STRUK"); 
        frame.add(strukButton, gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 5; 
        JButton bayarButton = new JButton("BAYAR"); 
        frame.add(bayarButton, gbc); 

        // Row 7 - STRUK output area
        gbc.gridx = 0; 
        gbc.gridy = 6; 
        gbc.gridwidth = 2; 
        JTextArea strukArea = new JTextArea(5, 30); 
        strukArea.setLineWrap(true); 
        strukArea.setWrapStyleWord(true); 
        frame.add(new JScrollPane(strukArea), gbc); 

        // Row 8 - TOTAL PENDAPATAN
        gbc.gridx = 0; 
        gbc.gridy = 7; 
        frame.add(new JLabel("TOTAL PENDAPATAN:"), gbc); 
        gbc.gridx = 1; 
        gbc.gridy = 7; 
        JTextField totalPendapatanField = new JTextField(10); 
        totalPendapatanField.setEditable(false); // Not editable by user
        frame.add(totalPendapatanField, gbc); 

        // Action Listener for STRUK button
        strukButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                String struk = "No Meja: " + noMejaField.getText() + "\n" + 
                               "Total Pesanan: " + totalPesananField.getText() + "\n" + 
                               "PPN: " + ppnField.getText() + "\n" + 
                               "Uang Pembayaran: " + uangPembayaranField.getText() + "\n" + 
                               "Uang Kembali: " + uangKembaliField.getText() + "\n" + 
                               "STRUK"; // Adding STRUK to output
                strukArea.setText(struk); 
            } 
        }); 

        // Action Listener for BAYAR button
        bayarButton.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                try { 
                    int totalPesanan = Integer.parseInt(totalPesananField.getText()); 
                    int ppn = Integer.parseInt(ppnField.getText()); 
                    int uangPembayaran = Integer.parseInt(uangPembayaranField.getText()); 

                    // Calculate amount back and total income
                    int total = totalPesanan + ppn; 
                    uangKembaliField.setText(String.valueOf(uangPembayaran - total)); 
                    totalPendapatanField.setText(String.valueOf(total)); 
                } catch (NumberFormatException ex) { 
                    JOptionPane.showMessageDialog(frame, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE); 
                } 
            } 
        }); 

        // Make frame visible
        frame.setVisible(true); 
    } 
}