// #pragma once
#include "petshop.cpp"

/* Saya Naufal Fakhri Al-Najieb dengan NIM 2309648 mengerjakan Tugas Praktikum 1 
dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya 
maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

int main(){
    
    petshop Toko_Fakhri;
    Toko_Fakhri.Sambutan();
    
    string Confirmation;
    int Mark = 0;
    int value = 0;

    list<petshop> list_Produk;

    do{
        Toko_Fakhri.Menu_Program();
        cout << endl;
        cout << "Pilih opsi menu > ";
        cin >> value;
        
        Toko_Fakhri.Pilihan_Menu(value, &list_Produk);
        cout << endl;
        cout << "Apakah Anda ingin memilih opsi lainnya lagi? (ya/tidak)" << endl;
        cout << "> ";
        cin >> Confirmation;
        if (Confirmation == "tidak"){
            Mark = 1;
        }
        else{
            cout << endl;
        }
    }while(Mark != 1);

    return 0;
}