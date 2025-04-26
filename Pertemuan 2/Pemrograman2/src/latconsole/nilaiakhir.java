/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latconsole;

import java.util.Scanner;

/**
 *
 * @author Raihan Dasa
 */
public class nilaiakhir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa mahasiswa = new Mahasiswa();
        
        // Input student data
        System.out.print("Enter NIM: ");
        mahasiswa.setNim(scanner.nextLine());
        
        System.out.print("Enter Name: ");
        mahasiswa.setNama(scanner.nextLine());
        
        System.out.print("Enter UTS Score: ");
        mahasiswa.setUts(scanner.nextFloat());
        
        System.out.print("Enter UAS Score: ");
        mahasiswa.setUas(scanner.nextFloat());
        
        // Display results
        System.out.println("\nStudent Details:");
        System.out.println("NIM: " + mahasiswa.getNim());
        System.out.println("Name: " + mahasiswa.getNama());
        System.out.println("Final Score: " + mahasiswa.getNilaiAkhir());
        System.out.println("Grade: " + mahasiswa.getGrade());
        
        scanner.close();
    }
}

