/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package e31190270_queue;

import java.util.Scanner;

/**
 *
 * @author Makhmuda_Nurul_Khasana
 */
public class Bank {
    //deklarasi variabel id, nama, perlu, next
    int id; 
    String nama,perlu;
    Bank next;
    
    //method scanner untuk inputan angka
    static Scanner in=new Scanner(System.in);
    //method scanner untuk inputan string
    static Scanner str=new Scanner(System.in);
    
    public void input(){ //method untuk menginputkan data nasabah
        System.out.print("ID        : ");
        id=in.nextInt(); //nilai var id dari inputan
        System.out.print("NAMA      : ");
        nama=str.nextLine(); //nilai var nama dari inputan
        System.out.print("KEPERLUAN : ");
        perlu=str.nextLine(); //nilai var perlu dari inputan
        next=null; //nilai var next = null
    }
    
    public void read(){ //method untuk menampilkan nilai var id, nama, perlu
        System.out.println("|| "+id+" \t|| "+nama+" \t|| "+perlu+"   \t||");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //inisialisasi var menu
        int menu=0; 
        //objek queue dari class linked
        linked queue=new linked();
        while(menu!=4){ //jika menu !=4 benar
            System.out.print("1.Enqueue\n2.Dequeue\n3.View\n4.Exit\n : ");
            menu=in.nextInt(); //masukkan variabel menu
            //jika menu==1, panggil method enqueue dari objek queue
            if(menu==1)queue.enqueue(); 
            //jika menu==2, panggil method dequeue dari objek queue
            else if(menu==2)queue.dequeue();
            //jika menu==3, panggil method view dari objek queue
            else if(menu==3)queue.view();
            //jika menu==4, tampil output string keluar
            else if(menu==4)System.out.println("- keluar -");
            //jika input selain angka menu maka tampil output string salah
            else System.out.println("- Salah -");
            System.out.println("");
        }
    }
}

    class linked{
        Bank front,rear;
        //constructor linked
        public linked(){
            //inisialisasi var front dan rear = null
            front=null;
            rear=null;
    }
    
     /*
        Fungsi EnQueue untuk memasukkan sebuah elemen dalam queue
     */
    //method enqueue
    public void enqueue(){
        //membuat objek baru
        Bank baru=new Bank();
        baru.input(); //panggil method input dari objek baru
        //jika front bernilai null, ganti nilai var front, front=baru
        if(front==null)front=baru; 
        //jika tidak, ganti nilai var next dari objek rear
        else rear.next=baru;
        rear=baru; //ganti nilai var rear
    }
    
    /*
    Fungsi DeQueue untuk untuk mengambil sebuah elemen dari queue. 
    Operasi ini sering disebut juga serve. 
    Hal ini dilakukan dengan cara memindahkan sejauh satu langkah ke posisi di depannya
    sehingga otomatis elemen yang paling depan akan tertimpa dengan elemen yang terletak di belakangnya
     */
    //method dequeue
    public void dequeue(){
        //jika front = null maka tampil string kosong
        if(front==null)System.out.println("- Kosong -");
        else{
            //jika tidak, maka tampil nilai var id dari objek front
            System.out.println("Keluar Data Dengan Id : "+front.id);
            front=front.next; //ganti nilai atribut front
        }
    }
    
    //method view
    public void view(){
        //jika front = null maka tampil kosong
        if(front==null)System.out.println("- Kosong -");
        else{ //jika tidak
            System.out.println("|| Id \t|| Nama || Keperluan ||");
            //objek dengan nilai atribut front
            //jika a!=null benar, panggil method read dari objek a
            //ganti nilai var a, a=a.next
            for(Bank a=front; a!=null; a=a.next) a.read();
        }
    }
}