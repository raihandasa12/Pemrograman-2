package latconsole;

import java.util.Scanner;

public class Mahasiswa {

    // Class Attributes
    private String nim, nama;
    private float uts, uas;
    private double nilaiakhir;
    
    // Getters and Setters
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getUts() {
        return uts;
    }

    public void setUts(float uts) {
        this.uts = uts;
    }

    public float getUas() {
        return uas;
    }

    public void setUas(float uas) {
        this.uas = uas;
    }

    // Calculate final score
    public double getNilaiAkhir() {
        nilaiakhir = (uts + uas) / 2;
        return nilaiakhir;
    }
    
    // Determine grade
    public String getGrade() {
        double nilaiAkhir = getNilaiAkhir();
        String grade;

        if (nilaiAkhir < 50)
            grade = "E";
        else if (nilaiAkhir < 60)
            grade = "D";
        else if (nilaiAkhir < 70)
            grade = "C";
        else if (nilaiAkhir < 80)
            grade = "B";
        else 
            grade = "A";
        
        return grade;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mahasiswa = new Mahasiswa();
        
        // Input student data
        System.out.print("NIM: ");
        mahasiswa.setNim(scanner.nextLine());
        
        System.out.print("Name: ");
        mahasiswa.setNama(scanner.nextLine());
        
        System.out.print("Hasil UTS: ");
        mahasiswa.setUts(scanner.nextFloat());
        
        System.out.print("Hasil UAS: ");
        mahasiswa.setUas(scanner.nextFloat());
        
        // Display results
        System.out.println("\nPenilaian Menyeluruh:");
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Name: " + mahasiswa.getNama());
        System.out.println("Hasil Akhir: " + mahasiswa.getNilaiAkhir());
        System.out.println("Grade: " + mahasiswa.getGrade());
        
        scanner.close();
    }
}