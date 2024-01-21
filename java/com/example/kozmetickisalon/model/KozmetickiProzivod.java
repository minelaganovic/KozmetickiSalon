package com.example.kozmetickisalon.model;

public class KozmetickiProzivod {
    private  Long id;
    private  String detalji;
    private int cena;
    private String naziv;

    //private byte[] slika;

    public KozmetickiProzivod() {
    }

    public KozmetickiProzivod(Long id, String detalji, int cena, String naziv) {
        this.id = id;
        this.detalji = detalji;
        this.cena = cena;
        this.naziv = naziv;
        // this.slika = slika;
    }


    public Long getId() {
        return id;
    }

    public int getCena() {
        return cena;
    }
    public String getNaziv() {
        return naziv;
    }
    public String getDetalji() {
        return detalji;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public void setDetalji(String detalji) {
        this.detalji = detalji;
    }

    @Override
    public String toString() {
        return "KozmetickiProizvod{" +
                "id=" + id +
                ", detalji='" + detalji + '\'' +
                ", cena=" + cena +
                ", naziv='" + naziv + '\'' +
                //", slika=" + Arrays.toString(slika) + // Dodajemo informacije o slici
                '}';
    }
}
