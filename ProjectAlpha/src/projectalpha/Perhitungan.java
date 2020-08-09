/*
Nama Kelompok : LinuxTech
Tema CargoMan : Pengiriman Barang TIKI
Algoritma : 0/1 Knapsack
Nama Anggota Kelompok :
- Mikha Christian Satria Girsang (1810520086)
- Lalu Advan Lavida (1810520094)
- Muhammad Pandu Suryapranata (1810520091)
- Vingkyn Fadillah (1810520084)
- Fedi Fandawa (1810520060)
 */
package projectalpha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author MikhaGirsang
 */
public class Perhitungan  {
    
    public ArrayList<List<String>> barang = new ArrayList<List<String>>();
    public ArrayList<List<String>> barangterambil = new ArrayList<List<String>>();
    public ArrayList<List<String>> baranghasil = new ArrayList<List<String>>();

    public void addouter(ArrayList<String> data) {
        //pilihan = c; 
        List childrenList = new ArrayList(data);
        barang.add(childrenList);

    }
    
    public void nilaihasil(int kapasitas){
        int harga = 0;
        int berat = 0;
        int profit = 0;
        int cap = kapasitas;
        for (int i = 0; i < barang.size(); i++) {
            if(berat<cap){
                if (berat + Integer.valueOf(barang.get(i).get(1)) <= cap){
                berat = berat + Integer.valueOf(barang.get(i).get(1));
                profit = profit + Integer.valueOf(barang.get(i).get(2));
                baranghasil.add(barang.get(i));
                }
            } else {
                break;
            }
        }
    }
    
    public int nilaiprofit(int kapasitas){
        int harga = 0;
        int berat = 0;
        int profit = 0;
        int cap = kapasitas;
        for (int i = 0; i < barang.size(); i++) {
            if(berat<cap){
                if (berat + Integer.valueOf(barang.get(i).get(1)) <= cap){
                berat = berat + Integer.valueOf(barang.get(i).get(1));
                profit = profit + Integer.valueOf(barang.get(i).get(2));
                //barangterambil.add(barang.get(i));
                }
            } else {
                break;
            }
        }
        return profit;
    }
    
    public int nilaiberat(int kapasitas){
        int harga = 0;
        int berat = 0;
        int profit = 0;
        int cap = kapasitas;
        for (int i = 0; i < barang.size(); i++) {
            if(berat<cap){
                if (berat + Integer.valueOf(barang.get(i).get(1)) <= cap){
                berat = berat + Integer.valueOf(barang.get(i).get(1));
                profit = profit + Integer.valueOf(barang.get(i).get(2));
                //barangterambil.add(barang.get(i));
                }
            } else {
                break;
            }
        }
        return berat;
    }

    public void knapsack(int kapasitas) {
        int harga = 0;
        int berat = 0;
        int profit = 0;
        int cap = kapasitas;
        for (int i = 0; i < barang.size(); i++) {
            if(berat<cap){
                if (berat + Integer.valueOf(barang.get(i).get(1)) <= cap){
                berat = berat + Integer.valueOf(barang.get(i).get(1));
                profit = profit + Integer.valueOf(barang.get(i).get(2));
                barangterambil.add(barang.get(i));
                }
            } else {
                break;
            }
        }
    }
    
    public void testprint(){
        System.out.println(barangterambil);
    }

    public void addDensity(){
        double density;
        double temp = Math.pow(10, 2);
        for (int i = 0;i<barang.size();i++){
            density = Double.valueOf(barang.get(i).get(2)) / Double.valueOf(barang.get(i).get(1));
            barang.get(i).add(3, Double.toString(Math.round(density*temp)/temp));
        }
        Collections.sort(barang, new Column2Comparator());
    }
    
    public void sortDensity(){
        double density;
        double temp = Math.pow(10, 2);
        for (int i = 0;i<barang.size();i++){
            density = Double.valueOf(barang.get(i).get(2)) / Double.valueOf(barang.get(i).get(1));
            barang.get(i).add(3, Double.toString(Math.round(density*temp)/temp));
        }
        Collections.sort(barang, new Column2Comparator());
        for (int a = 0;a<barang.size();a++){
            barang.get(a).remove(3);
        }
    }
    
    public void sortBerat() {
        Collections.sort(barang, new Column0Comparator());
    }

    public void sortProfit() {
        Collections.sort(barang, new Column1Comparator());
    }

    public void print() {
        System.out.println(barang);
    }

    public class Column0Comparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return Integer.valueOf(o1.get(1)).compareTo(Integer.valueOf(o2.get(1)));
        }

        @Override
        public Comparator<List<String>> reversed() {
            return reversed();
        }
    };

    public class Column1Comparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return Integer.valueOf(o2.get(2)).compareTo(Integer.valueOf(o1.get(2)));
        }

        @Override
        public Comparator<List<String>> reversed() {
            return reversed();
        }
    };
    
    public class Column2Comparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return Double.valueOf(o2.get(3)).compareTo(Double.valueOf(o1.get(3)));
        }

        @Override
        public Comparator<List<String>> reversed() {
            return reversed();
        }
    };
}
