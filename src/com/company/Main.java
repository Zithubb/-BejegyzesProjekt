package com.company;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;





public class Main {

    static List<Bejegyzes> beList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void kettoPerb(){
        System.out.println("Addja meg mennyi új bejegyzést akar: ");
        int szam = sc.nextInt();
        String szerzo, tartalom;
        for (int i = 0; i < szam; i++) {
            int j=i+1;
            System.out.println(j + ". bejegyzés:");
            System.out.println("Szerző: ");
            szerzo = sc.next();
            System.out.println("Tartalom: ");
            tartalom = sc.next();
            Bejegyzes l = new Bejegyzes(szerzo, tartalom);
            beList.add(l);
        }
        System.out.println(beList);
    }
    public static  List<Bejegyzes> beolvas(String fajlNev){

        try {
            FileReader fr=new FileReader("bejegyzesek.txt", Charset.defaultCharset());
            BufferedReader br = new BufferedReader(fr);

            String adatok= br.readLine();

            while (adatok!=null){
                String[] adat=adatok.split(";");
                Bejegyzes bejegyzes= new Bejegyzes(adat[0],adat[1]);
                beList.add(bejegyzes);
                adatok= br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return beList;
    }





    public static void main(String[] args) {

        Bejegyzes b1 = new Bejegyzes("Anita", "Lenni vagy nem lenni, ez itt a kérdés");
        Bejegyzes b2 = new Bejegyzes("Andris", "Hol van az agy amikor az kellene?");
        beList.add(b1);
        beList.add(b2);
        System.out.println(beList);

        kettoPerb();
        beolvas("bejegyzes.txt");





    }
}
