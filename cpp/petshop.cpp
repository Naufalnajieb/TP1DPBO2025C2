#include <iostream>
#include <string>
#include <bits/stdc++.h>

using namespace std;

/* Saya Naufal Fakhri Al-Najieb dengan NIM 2309648 mengerjakan Tugas Praktikum 1 
dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya 
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

class petshop{
    private:
        int ID;
        string Nama_Produk;
        string Kategori_Produk;
        int Harga_Produk;

    public:
        petshop(){
            this->ID = 0;
            this->Nama_Produk = "-";
            this->Kategori_Produk = "-";
            this->Harga_Produk = 0;
        }

        petshop(int ID, string Nama_Produk, string Kategori_Produk, int Harga_Produk){
            this->ID = ID;
            this->Nama_Produk = Nama_Produk;
            this->Kategori_Produk = Kategori_Produk;
            this->Harga_Produk = Harga_Produk;
        }

        void set_ID(int ID){
            this->ID = ID;
        }
        void set_Nama_Produk(string Nama_Produk){
            this->Nama_Produk = Nama_Produk;
        }
        void set_Kategori_Produk(string Kategori_Produk){
            this->Kategori_Produk = Kategori_Produk;
        }
        void set_Harga_Produk(int Harga_Produk){
            this->Harga_Produk = Harga_Produk;
        }
        
        int get_ID(){
            return this->ID;
        }
        string get_Nama_Produk(){
            return this->Nama_Produk;
        }
        string get_Kategori_Produk(){
            return this->Kategori_Produk;
        }
        int get_Harga_Produk(){
            return this->Harga_Produk;
        }

        void Sambutan(){
            cout << "\nSelamat Datang di PetShop Milik Naufal Fakhri Al-Najieb\n";
            cout << "Versi 1.0\n\n";
            cout << "++========================================================++\n";
            cout << "||    <<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>   ||\n";
            cout << "||                      Welcome User                      ||\n";
            cout << "||    <<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>   ||\n";
            cout << "++========================================================++\n\n";
        }
        void Menu_Program(){
            cout << "1. Tampilkan Produk" << endl;
            cout << "2. Tambah Data Produk" << endl;
            cout << "3. Ubah Data Produk" << endl;
            cout << "4. Hapus Data Produk" << endl;
            cout << "5. Cari Data Produk" << endl;
        }
        void Pilihan_Menu(int pilihan, list<petshop> *list_produk){
            if (pilihan == 1) {
                Show_Data(list_produk);
            } 
            else if (pilihan == 2){
                int ID, Harga_Produk;
                string Nama_Produk, Kategori_Produk;
                cout << "Tambah Data Secara Berurutan (ID->NAMA->KATEGORI->HARGA)" << endl;
                cout << "> ";
                cin >> ID >> Nama_Produk >> Kategori_Produk >> Harga_Produk;
                Add_Data(ID, Nama_Produk, Kategori_Produk, Harga_Produk, list_produk);
            }
            else if (pilihan == 3){
                int find;
                cout << "Silahkan sebut ID Produk yang akan di (Ubah) disini !" << endl;
                cout << "> ";
                cin >> find;
                Update_Data(list_produk, find);
            }
            else if (pilihan == 4){
                int find;
                cout << "Silahkan sebut ID Produk yang akan di (hapus) disini !" << endl;
                cout << "> ";
                cin >> find;
                Delete_Data(list_produk, find);
            }
            else if (pilihan == 5){
                string find;
                cout << "Silahkan Cari Nama Produk Disini !" << endl;
                cout << "> ";
                cin >> find;
                find_nama_produk(list_produk, find);
            }
            else{
                cout << "Pilihan Opsi Tidak Tersedia!" << endl;
            }
        }
        void Add_Data(int ID, string Nama_Produk, string Kategori_Produk, int Harga_Produk, list<petshop> *list_produk){

            if (!(*list_produk).empty()){
                int mark = 0;
                list<petshop>::iterator iterasi = (*list_produk).begin();
                while ((iterasi != (*list_produk).end()) && (mark != 1)){
                    if (iterasi->get_ID() == ID){
                        mark = 1;
                    }
                    iterasi++;
                }

                if (mark == 1){
                    cout << "Produk ID tidak boleh sama !" << endl;
                }
                else{
                    petshop save; // pembuatan objek pada setiap proses loop
                    save.set_ID(ID);
                    save.set_Nama_Produk(Nama_Produk);
                    save.set_Kategori_Produk(Kategori_Produk);
                    save.set_Harga_Produk(Harga_Produk);
                    (*list_produk).push_back(save); // masukin ke dalam list
                }
            }
            else{
                petshop save; // pembuatan objek pada setiap proses loop
                save.set_ID(ID);
                save.set_Nama_Produk(Nama_Produk);
                save.set_Kategori_Produk(Kategori_Produk);
                save.set_Harga_Produk(Harga_Produk);
                (*list_produk).push_back(save); // masukin ke dalam list
            }
        }

        void Show_Data(list<petshop> *list_produk){
            if ((*list_produk).empty()){
                cout << "Produk Masih kosong !" << endl;
            }
            else{
                list<petshop>::iterator iterasi = (*list_produk).begin();
    
                while (iterasi != (*list_produk).end()){
                    cout << "| " << iterasi->get_ID() << ". ";
                    cout << " | " << iterasi->get_Nama_Produk() << " | " << iterasi->get_Kategori_Produk();
                    cout << " | " << iterasi->get_Harga_Produk() << " | " << endl;
    
                    iterasi++;
                }
            }
        }
        void Update_Data(list<petshop> *list_produk, int find){
            if ((*list_produk).empty()){
                cout << "Produk Masih kosong !" << endl;
            }
            else{
                int mark = 0;
                list<petshop>::iterator iterasi = (*list_produk).begin();
                while ((iterasi != (*list_produk).end()) && (mark != 1)){
                    if (iterasi->get_ID() == find){
                        mark = 1;
                        
                        int ID, Harga_Produk;
                        string Nama_Produk, Kategori_Produk;
                        
                        cout << "Update Data Secara Berurutan (ID->NAMA->KATEGORI->HARGA)" << endl;
                        cout << "> ";
                        cin >> ID >> Nama_Produk >> Kategori_Produk >> Harga_Produk;
                        
                        iterasi->set_ID(ID);
                        iterasi->set_Nama_Produk(Nama_Produk);
                        iterasi->set_Kategori_Produk(Kategori_Produk);
                        iterasi->set_Harga_Produk(Harga_Produk);
                    }
                    iterasi++;
                }

                if (mark == 1){
                    cout << "Produk Berhasil Ter-Update !" << endl;
                }
            }
        }
        void Delete_Data(list<petshop> *list_produk, int find){
            if ((*list_produk).empty()){
                cout << "Produk Masih kosong !" << endl;
            }
            else{
                int mark = 0;
                list<petshop>::iterator iterasi = (*list_produk).begin();
                while ((iterasi != (*list_produk).end()) && (mark != 1)){
                    if (iterasi->get_ID() == find){
                        mark = 1;
                        (*list_produk).erase(iterasi);
                    }
                    iterasi++;
                }

                if (mark == 1){
                    cout << "Produk Berhasil Terhapus !" << endl;
                }
            }
        }
        void find_nama_produk(list<petshop> *list_produk, string find){
            
            if ((*list_produk).empty()){
                cout << "Produk Masih kosong !" << endl;
            }
            else{
                int mark = 0;
                list<petshop>::iterator iterasi = (*list_produk).begin();
                while ((iterasi != (*list_produk).end()) && (mark != 1)){
                    if (iterasi->get_Nama_Produk() == find){
                        mark = 1;
                        cout << "Produk Ditemukan :" << endl;
                        cout << "| " << iterasi->get_ID() << ". ";
                        cout << " | " << iterasi->get_Nama_Produk() << " | " << iterasi->get_Kategori_Produk();
                        cout << " | " << iterasi->get_Harga_Produk() << " | " << endl;
                    }
                    
                    iterasi++;
                }

            }
        }

        ~petshop(){
            
        }
};
