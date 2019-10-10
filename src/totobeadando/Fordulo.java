package totobeadando;

import java.time.LocalDate;
import java.util.Arrays;

public class Fordulo {

    

    private int ev;
    private int het;
    private int forduloAHeten;
    private LocalDate datum;
    private int tizennegyes;
    private int tizenharmas;
    private int tizenkettes;
    private int tizenegyes;
    private int tizes;


    private String[] nyertesek;

    @Override
    public String toString() {
        return "Fordulo{" + "ev=" + ev + ", het=" + het + ", forduloAHeten=" + forduloAHeten + ", datum=" + datum + ", tizennegyes=" + tizennegyes + ", tizenharmas=" + tizenharmas + ", tizenkettes=" + tizenkettes + ", tizenegyes=" + tizenegyes + ", tizes=" + tizes + ", nyertesek=" + Arrays.toString(nyertesek) + '}';
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return het;
    }

    public void setHet(int het) {
        this.het = het;
    }

    public int getForduloAHeten() {
        return forduloAHeten;
    }

    public void setForduloAHeten(int forduloAHeten) {
        this.forduloAHeten = forduloAHeten;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getTizennegyes() {
        return tizennegyes;
    }

    public void setTizennegyes(int tizennegyes) {
        this.tizennegyes = tizennegyes;
    }

    public int getTizenharmas() {
        return tizenharmas;
    }

    public void setTizenharmas(int tizenharmas) {
        this.tizenharmas = tizenharmas;
    }

    public int getTizenkettes() {
        return tizenkettes;
    }

    public void setTizenkettes(int tizenkettes) {
        this.tizenkettes = tizenkettes;
    }

    public int getTizenegyes() {
        return tizenegyes;
    }

    public void setTizenegyes(int tizenegyes) {
        this.tizenegyes = tizenegyes;
    }

    public int getTizes() {
        return tizes;
    }

    public void setTizes(int tizes) {
        this.tizes = tizes;
    }

    public String[] getNyertesek() {
        return nyertesek;
    }

    public void setNyertesek(String[] nyertesek) {
        this.nyertesek = nyertesek;
    }

    public Fordulo(int ev, int het, int forduloAHeten, LocalDate datum, int tizennegyes, int tizenharmas, int tizenkettes, int tizenegyes, int tizes, String[] nyertesek) {
        this.ev = ev;
        this.het = het;
        this.forduloAHeten = forduloAHeten;
        this.datum = datum;
        this.tizennegyes = tizennegyes;
        this.tizenharmas = tizenharmas;
        this.tizenkettes = tizenkettes;
        this.tizenegyes = tizenegyes;
        this.tizes = tizes;
        this.nyertesek = nyertesek;
    }
}
