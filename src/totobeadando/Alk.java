package totobeadando;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alk {

    public static List<Fordulo> Fordulok = new ArrayList<>();

    public static void Beolvas()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
        try (BufferedReader br = new BufferedReader(new FileReader("toto.csv"))) {
            String sor;
            while ((sor = br.readLine()) != null) {
                    String[] split = sor.split(";");
                    int ev = Integer.parseInt(split[0]);
                    int het = Integer.parseInt(split[1]);
                    String fordulo = split[2];
                    if (fordulo.equals("")) {
                    fordulo = "0";
                }
                    LocalDate datum;
                    int forduloAHeten = Integer.parseInt(fordulo);
                    if (split[3].equals("")) {
                    datum = LocalDate.of(1900, 01, 01);
                }
                    else
                    {
                    String[] datumok = split[3].split("\\.");
                    if (datumok[2].equals("")) {
                    datumok[2] = "0";
                    }
                    datum = LocalDate.of(Integer.parseInt(datumok[0]),Integer.parseInt(datumok[1]),Integer.parseInt(datumok[2]));
                    }
                    
                    String tizennegyesstring = split[5].replaceAll("\\s+", "").replace("Ft","");
                    if (tizennegyesstring.equals("")) {
                    tizennegyesstring = "0";
                    }
                    String tizenharmasstring = split[7].replaceAll("\\s+", "").replace("Ft","");
                    if (tizenharmasstring.equals("")) {
                    tizenharmasstring = "0";
                    }
                    String tizentizesstring = split[13].replaceAll("\\s+", "").replace("Ft","");
                    if (tizentizesstring.equals("")) {
                    tizentizesstring = "0";
                    }
                    String tizenkettesstring = split[9].replaceAll("\\s+", "").replace("Ft","");
                    if (tizenkettesstring.equals("")) {
                    tizentizesstring = "0";
                    }
                    String tizeneggyesstring = split[11].replaceAll("\\s+", "").replace("Ft","");
                    if (tizeneggyesstring.equals("")) {
                    tizeneggyesstring = "0";
                    }
                    int tizennegyes = Integer.valueOf(tizennegyesstring);
                    int tizenharmas = Integer.valueOf(tizenharmasstring);
                    int tizenkettes = Integer.valueOf(tizenkettesstring);
                    int tizenegyes = Integer.valueOf(tizeneggyesstring);
                    int tizes = Integer.valueOf(tizentizesstring);
                    String[] nyertesek = {split[14],split[15],split[16],split[17],split[18],split[19],split[20],split[21],split[22],split[23],split[24],split[25],split[26],split[27]};
                    Fordulok.add(new Fordulo(ev,het,forduloAHeten,datum,tizennegyes,tizenharmas,tizenkettes, tizenegyes, tizes,nyertesek));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Kereses()
    {
        int legnagyobb = 0;
        for (int i = 0; i < Fordulok.size(); i++) {
            if (legnagyobb < Fordulok.get(i).getTizennegyes()) {
                legnagyobb = Fordulok.get(i).getTizennegyes();
            }
            if (legnagyobb < Fordulok.get(i).getTizenharmas()) {
                legnagyobb = Fordulok.get(i).getTizenharmas();
            }
            if (legnagyobb < Fordulok.get(i).getTizenkettes()) {
                legnagyobb = Fordulok.get(i).getTizenkettes();
            }
            if (legnagyobb < Fordulok.get(i).getTizenegyes()) {
                legnagyobb = Fordulok.get(i).getTizenegyes();
            }
            if (legnagyobb < Fordulok.get(i).getTizes()) {
                legnagyobb = Fordulok.get(i).getTizes();
            }
        }
        System.out.println("A legnagyobb nyeremeny amit rogzitettek: " + legnagyobb + " Ft");
    }
    public static void Statisztika()
    {
        DecimalFormat df = new DecimalFormat("##.##");
        double seged1 = 0;
        double seged2 = 0;
        double segedx = 0;
        double osszes = 0;
        for (int i = 0; i < Fordulok.size(); i++) {
            String[] seged = Fordulok.get(i).getNyertesek();
            for (String seged3 : seged) {
                switch (seged3) {
                    case "1":
                        seged1++;
                        osszes++;
                        break;
                    case "2":
                        seged2++;
                        osszes++;
                        break;
                    case "x":
                        segedx++;
                        osszes++;
                        break;
                }
            }
        }
        System.out.println("Statisztika: #1 csapat nyert: " + df.format(seged1*100/osszes)+ "%, " + "#2 csapat nyert: " 
                + df.format(seged2*100/osszes)+ "%, " + 
                "Dontetlen: " + df.format(segedx*100/osszes) + "%");
    }
    public static void UserTippeles()
    {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Kérem adjon meg egy dátumot: ");
        String datum = sc.nextLine();
        String[] split = datum.split("-|\\.");
        LocalDate seged = LocalDate.of(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        System.out.println("Kérem adjon meg egy tippet: ");
        String tipp = sc.nextLine().toUpperCase();
        Talalat UserTippeles = new Talalat(seged, Fordulok, tipp);
        String[] seged2 = UserTippeles.Usertipp();
        System.out.println("Eredmeny: Talalat: " + seged2[0] + ", nyeremeny: " + seged2[1]);
        
    }
    public static void main(String[] args) {
        Beolvas();
        Kereses();
        Statisztika();
        UserTippeles();
       
    }
    
}
