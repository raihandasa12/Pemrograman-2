package pertemuan51;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class Pertemuan51 extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nimField, namaField, nilaiField;
    private JLabel statistikLabel;
    private java.util.List<Double> nilaiList = new ArrayList<>();

    public Pertemuan51() {
        setTitle("APLIKASI MANAJEMEN MAHASISWA");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel utama
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Judul
        JLabel titleLabel = new JLabel("DATA MAHASISWA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Tabel
        String[] columnNames = {"No", "NIM", "Nama", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));
        nimField = new JTextField();
        namaField = new JTextField();
        nilaiField = new JTextField();

        inputPanel.add(new JLabel("NIM:"));
        inputPanel.add(nimField);
        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(namaField);
        inputPanel.add(new JLabel("Nilai:"));
        inputPanel.add(nilaiField);

        // Tombol
        JButton tambahButton = new JButton("TAMBAH DATA");
        JButton refreshButton = new JButton("REFRESH");
        inputPanel.add(tambahButton);
        inputPanel.add(refreshButton);

        // Panel bawah
        JPanel bottomPanel = new JPanel(new BorderLayout());
        statistikLabel = new JLabel("Statistik akan muncul di sini.", SwingConstants.CENTER);
        bottomPanel.add(statistikLabel, BorderLayout.CENTER);

        // Tambahkan semua panel ke main
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Aksi tombol tambah
        tambahButton.addActionListener(e -> tambahData());
        refreshButton.addActionListener(e -> tampilkanStatistik());

        setVisible(true);
    }

    private void tambahData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String nilaiStr = nilaiField.getText();

        if (nim.isEmpty() || nama.isEmpty() || nilaiStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double nilai = Double.parseDouble(nilaiStr);
            String grade = hitungGrade(nilai);
            nilaiList.add(nilai);

            int no = tableModel.getRowCount() + 1;
            tableModel.addRow(new Object[]{no, nim, nama, nilai, grade});
            tampilkanStatistik();

            // Kosongkan input
            nimField.setText("");
            namaField.setText("");
            nilaiField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nilai harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanStatistik() {
        if (nilaiList.isEmpty()) {
            statistikLabel.setText("Belum ada data.");
            return;
        }

        double total = 0, tertinggi = Double.MIN_VALUE, terendah = Double.MAX_VALUE;
        for (double n : nilaiList) {
            total += n;
            if (n > tertinggi) tertinggi = n;
            if (n < terendah) terendah = n;
        }
        double rataRata = total / nilaiList.size();
        statistikLabel.setText(String.format("Total: %d mahasiswa | Rata-rata: %.2f | Tertinggi: %.2f | Terendah: %.2f",
                nilaiList.size(), rataRata, tertinggi, terendah));
    }

    private String hitungGrade(double nilai) {
        if (nilai >= 85) return "A";
        if (nilai >= 75) return "B";
        if (nilai >= 65) return "C";
        if (nilai >= 50) return "D";
        return "E";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Pertemuan51::new);
    }
}