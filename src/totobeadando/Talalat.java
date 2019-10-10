package totobeadando;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Talalat {

    public Talalat(LocalDate timetipp, List<Fordulo> innenkeres, String tipp) {
        this.timetipp = timetipp;
        this.innenkeres = innenkeres;
        this.tipp = tipp;
    }
    private LocalDate timetipp;
    private List<Fordulo> innenkeres;
    private String tipp;
    
    public String[] Usertipp()
    {
        int eredmenycount = 0;
        String nyeremeny = "";
        for (Fordulo datumkeres : innenkeres) {
            if (datumkeres.getDatum().compareTo(timetipp) == 0) {
                String[] seged = datumkeres.getNyertesek();
                String[] spliteltvalasz = tipp.split("(?!^)");                
                for (int i = 0; i < seged.length; i++) {
                    if (seged[i].equals(spliteltvalasz[i])) {
                        eredmenycount++;
                    }
                }
                switch(eredmenycount)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        nyeremeny = "0 Ft";
                        break;
                    case 10:
                        nyeremeny = String.valueOf(datumkeres.getTizes()) + " Ft";
                        break;
                    case 11:
                        nyeremeny = String.valueOf(datumkeres.getTizenegyes()) + " Ft";
                        break;
                    case 12:
                        nyeremeny = String.valueOf(datumkeres.getTizenkettes()) + " Ft";
                        break;
                    case 13:
                        nyeremeny = String.valueOf(datumkeres.getTizenharmas()) + " Ft";
                        break;
                    case 14:
                        nyeremeny = String.valueOf(datumkeres.getTizennegyes()) + " Ft";
                        break;
                    
                }
            }
        }
        String[] eredmeny = {String.valueOf(eredmenycount), nyeremeny};
    return eredmeny;
    }
}
