import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class DataPekerjaan extends JFrame {

    private ArrayList<String> dataPekerjaan = new ArrayList<>();
    private JTextField kodeField, namaField;
    private JComboBox<String> tugasCombo;
    private JTable table;
    private DefaultTableModel tableModel;

    public DataPekerjaan() {
        // Konfigurasi frame
        setTitle("Aplikasi Data Pekerjaan");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBackground(Color.LIGHT_GRAY);

        // Komponen input
        inputPanel.add(new JLabel("Kode Pekerjaan:"));
        kodeField = new JTextField();
        inputPanel.add(kodeField);

        JButton lihatBtn = new JButton("Lihat");
        inputPanel.add(lihatBtn);

        inputPanel.add(new JLabel("Nama Pekerjaan:"));
        namaField = new JTextField();
        inputPanel.add(namaField);

        inputPanel.add(new JLabel("Jumlah Tugas:"));
        tugasCombo = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        inputPanel.add(tugasCombo);

        // Panel tabel
        tableModel = new DefaultTableModel(new String[]{"Kode", "Nama", "Tugas"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.GREEN);
        headerPanel.setPreferredSize(new Dimension(600, 20));

        tablePanel.add(headerPanel, BorderLayout.NORTH);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.PINK);

        JButton simpanBtn = new JButton("Simpan");
        JButton hapusBtn = new JButton("Hapus");
        JButton pilihBtn = new JButton("Pilih");
        JButton tutupBtn = new JButton("Tutup");

        buttonPanel.add(simpanBtn);
        buttonPanel.add(hapusBtn);
        buttonPanel.add(pilihBtn);
        buttonPanel.add(tutupBtn);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.PINK);
        footerPanel.setPreferredSize(new Dimension(600, 50));

        footerPanel.add(buttonPanel);

        // Menambahkan komponen ke frame
        add(inputPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Action listeners
        simpanBtn.addActionListener(e -> simpanData());
        hapusBtn.addActionListener(e -> hapusData());
        tutupBtn.addActionListener(e -> System.exit(0));
        lihatBtn.addActionListener(e -> tampilkanData());
    }

    private void simpanData() {
        if (validasiInput()) {
            String data = String.join(" | ",
                    kodeField.getText(),
                    namaField.getText(),
                    tugasCombo.getSelectedItem().toString()
            );
            dataPekerjaan.add(data);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            refreshTampilan();
        }
    }

    private boolean validasiInput() {
        if (kodeField.getText().isEmpty() || namaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Kode dan Nama Pekerjaan harus diisi!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void hapusData() {
        kodeField.setText("");
        namaField.setText("");
        tugasCombo.setSelectedIndex(0);
    }

    private void tampilkanData() {
        tableModel.setRowCount(0); // Clear existing data
        for (String data : dataPekerjaan) {
            String[] parts = data.split(" \\| ");
            if (parts.length == 3) {
                tableModel.addRow(parts);
            }
        }
    }

    private void refreshTampilan() {
        tampilkanData();
        hapusData();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DataPekerjaan app = new DataPekerjaan();
            app.setVisible(true);
        });

public class DataPekerjaan extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public DataPekerjaan() {
        // Inisialisasi model tabel
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama");
        tableModel.addColumn("Angka");

        // Inisialisasi tabel dengan model
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Menambahkan beberapa data contoh
        tableModel.addRow(new Object[]{"John", 25});
        tableModel.addRow(new Object[]{"Jane", 30});
        tableModel.addRow(new Object[]{"Doe", 22});

        // Atur ukuran dan visibilitas
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyForm();
    }
}
    
}