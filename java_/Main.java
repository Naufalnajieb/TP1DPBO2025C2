import java.util.Scanner;
import java.util.ArrayList;

/* Saya Naufal Fakhri Al-Najieb dengan NIM 2309648 mengerjakan Tugas Praktikum 1 
dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya 
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

public class Main {
    
    public static void main(String[] args) {
        petshop Toko_Fakhri = new petshop();
        Toko_Fakhri.Sambutan();

        String confirmation;
        int Mark = 0;
        int value = 0;
        ArrayList<petshop> list_Produk = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try{
            do{
                Toko_Fakhri.Menu_Program();
                System.out.println();
                System.out.print("Pilih opsi menu > ");
                value = sc.nextInt();

                Toko_Fakhri.Pilihan_Menu(value, list_Produk, sc);
                System.out.println();
                System.out.println("Apakah Anda ingin memilih opsi lainnya lagi? (ya/tidak)");
                System.out.print("> ");
                confirmation = sc.next();
                if (confirmation.equalsIgnoreCase("tidak")){
                    Mark = 1;
                }
                else{
                    System.out.println();
                }
            }while(Mark != 1);
        }
        catch(Exception e){
            System.out.println("Error");
        }
        finally{
            sc.close();
        }
    }
}
