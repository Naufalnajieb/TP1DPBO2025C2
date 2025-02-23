import java.util.Scanner;
import java.util.ArrayList;

/* Saya Naufal Fakhri Al-Najieb dengan NIM 2309648 mengerjakan Tugas Praktikum 1 
dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya 
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

public class petshop{
    //Atribut
    private int ID;
    private String Nama_Produk;
    private String Kategori_Produk;
    private int Harga_Produk;

    //Constructor
    public petshop(){
        this.ID = 0;
        this.Nama_Produk = "-";
        this.Kategori_Produk = "-";
        this.Harga_Produk = 0;
    }
    public petshop(int ID, String Nama_Produk, String Kategori_Produk, int Harga_Produk){
        this.ID = ID;
        this.Nama_Produk = Nama_Produk;
        this.Kategori_Produk = Kategori_Produk;
        this.Harga_Produk = Harga_Produk;
    }

    //Setter
    public void set_ID(int ID){
        this.ID = ID;
    }
    public void set_Nama_Produk(String Nama_Produk){
        this.Nama_Produk = Nama_Produk;
    }
    public void set_Kategori_Produk(String Kategori_Produk){
        this.Kategori_Produk = Kategori_Produk;
    }
    public void set_Harga_Produk(int Harga_Produk){
        this.Harga_Produk = Harga_Produk;
    }

    //Getter
    public int get_ID(){
        return this.ID;
    }
    public String get_Nama_Produk(){
        return this.Nama_Produk;
    }
    public String get_Kategori_Produk(){
        return this.Kategori_Produk;
    }
    public int get_Harga_Produk(){
        return this.Harga_Produk;
    }

    //--------->Method
    //Menu Tampilan
    public void Sambutan(){
        System.out.println("\nSelamat Datang di PetShop Milik Naufal Fakhri Al-Najieb");
        System.out.println("Versi 1.0\n");
        System.out.println("++========================================================++");
        System.out.println("||    <<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>   ||");
        System.out.println("||                      Welcome User                      ||");
        System.out.println("||    <<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>   ||");
        System.out.println("++========================================================++\n");
    }
    public void Menu_Program(){
        System.out.println("1. Tampilkan Produk");
        System.out.println("2. Tambah Data Produk");
        System.out.println("3. Ubah Data Produk");
        System.out.println("4. Hapus Data Produk");
        System.out.println("5. Cari Data Produk");
    }
    public void Pilihan_Menu(int pilihan, ArrayList<petshop> list_produk, Scanner sc){
        if (pilihan == 1) {
            Show_Data(list_produk);
        } 
        else if (pilihan == 2){
            int ID, Harga_Produk;
            String Nama_Produk, Kategori_Produk;
            System.out.println("Tambah Data Secara Berurutan (ID->NAMA->KATEGORI->HARGA)");
            System.out.print("> ");
            
            ID = sc.nextInt();
            Nama_Produk = sc.next(); 
            Kategori_Produk = sc.next();
            Harga_Produk = sc.nextInt();
            Add_Data(ID, Nama_Produk, Kategori_Produk, Harga_Produk, list_produk);
        }
        else if (pilihan == 3){
            int find;
            System.out.println("Silahkan sebut ID Produk yang akan di (Ubah) disini !");
            System.out.print("> ");
            find = sc.nextInt();
            Update_Data(list_produk, find, sc);
        }
        else if (pilihan == 4){
            int find;
            System.out.println("Silahkan sebut ID Produk yang akan di (hapus) disini !");
            System.out.print("> ");
            find = sc.nextInt();
            Delete_Data(list_produk, find);
        }
        else if (pilihan == 5){
            String find;
            System.out.println("Silahkan Cari Nama Produk Disini !");
            System.out.print("> ");
            find = sc.next();
            find_nama_produk(list_produk, find);
        }
        else{
            System.out.println("Pilihan Opsi Tidak Tersedia!");
        }
    }

    //Create Data
    public void Add_Data(int ID, String Nama_Produk, String Kategori_Produk, int Harga_Produk, ArrayList<petshop> list_produk){

        if (!list_produk.isEmpty()){
            int mark = 0;
            int iterasi = 0;
            while ((iterasi < list_produk.size()) && (mark != 1)){
                if (list_produk.get(iterasi).get_ID() == ID){
                    mark = 1;
                }
                iterasi++;
            }

            if (mark == 1){
                System.out.println("Produk ID tidak boleh sama !");
            }
            else{
                petshop save = new petshop(); // pembuatan objek pada setiap proses loop
                save.set_ID(ID);
                save.set_Nama_Produk(Nama_Produk);
                save.set_Kategori_Produk(Kategori_Produk);
                save.set_Harga_Produk(Harga_Produk);
                (list_produk).add(save); // masukin ke dalam list
            }
        }
        else{
            petshop save = new petshop(); // pembuatan objek pada setiap proses loop
            save.set_ID(ID);
            save.set_Nama_Produk(Nama_Produk);
            save.set_Kategori_Produk(Kategori_Produk);
            save.set_Harga_Produk(Harga_Produk);
            (list_produk).add(save); // masukin ke dalam list
        }
    }
    //Show data
    public void Show_Data(ArrayList<petshop> list_produk){
        if (list_produk.isEmpty()){
            System.out.println("Produk Masih kosong !");
        }
        else{
            int iterasi = 0;
            while (iterasi < list_produk.size()){
                System.out.print("| " + list_produk.get(iterasi).get_ID() + ". ");
                System.out.print( " | " + list_produk.get(iterasi).get_Nama_Produk() + " | " + list_produk.get(iterasi).get_Kategori_Produk());
                System.out.println( " | " + list_produk.get(iterasi).get_Harga_Produk() + " | ");

                iterasi++;
            }
        }
    }
    //Update Data
    public void Update_Data(ArrayList<petshop> list_produk, int find, Scanner sc){
        if (list_produk.isEmpty()){
            System.out.println("Produk Masih kosong !");
        }
        else{
            int mark = 0;
            int iterasi = 0;
            while ((iterasi < list_produk.size()) && (mark != 1)){
                if (list_produk.get(iterasi).get_ID() == find){
                    mark = 1;
                    
                    int ID, Harga_Produk;
                    String Nama_Produk, Kategori_Produk;
                    
                    System.out.println("Update Data Secara Berurutan (ID->NAMA->KATEGORI->HARGA)");
                    System.out.print("> ");
                    ID = sc.nextInt();
                    Nama_Produk = sc.next(); 
                    Kategori_Produk = sc.next();
                    Harga_Produk = sc.nextInt();
                    
                    list_produk.get(iterasi).set_ID(ID);
                    list_produk.get(iterasi).set_Nama_Produk(Nama_Produk);
                    list_produk.get(iterasi).set_Kategori_Produk(Kategori_Produk);
                    list_produk.get(iterasi).set_Harga_Produk(Harga_Produk);
                }

                iterasi++;
            }

            if (mark == 1){
                System.out.println("Produk Berhasil Ter-Update !");
            }
        }
    }
    //Delete Data
    public void Delete_Data(ArrayList<petshop> list_produk, int find){
        if (list_produk.isEmpty()){
            System.out.println("Produk Masih kosong !");
        }
        else{
            int mark = 0;
            int iterasi = 0;
            while ((iterasi < list_produk.size()) && (mark != 1)){
                
                if (list_produk.get(iterasi).get_ID() == find){
                    mark = 1;
                    list_produk.remove(iterasi);
                }
                iterasi++;
            }

            if (mark == 1){
                System.out.println("Produk Berhasil Terhapus !");
            }
        }
    }
    //Find Data berdasarkan nama_produk
    public void find_nama_produk(ArrayList<petshop> list_produk, String find){
        
        if (list_produk.isEmpty()){
            System.out.println("Produk Masih kosong !");
        }
        else{
            int mark = 0;
            int iterasi = 0;
            while ((iterasi < list_produk.size()) && (mark != 1)){
                if (list_produk.get(iterasi).get_Nama_Produk() == find){
                    mark = 1;
                    System.out.println("Produk Ditemukan :");
                    System.out.print("| " + list_produk.get(iterasi).get_ID() + ". ");
                    System.out.print( " | " + list_produk.get(iterasi).get_Nama_Produk() + " | " + list_produk.get(iterasi).get_Kategori_Produk());
                    System.out.println( " | " + list_produk.get(iterasi).get_Harga_Produk() + " | ");
                }
                
                iterasi++;
            }

        }
    }
}