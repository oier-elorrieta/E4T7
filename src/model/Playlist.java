package model;

import java.util.Objects;

public class Playlist {

    private int kapazitatea;
    private String titulua;
    
    public Playlist(int kapazitatea, String titulua) {
        super();
        this.kapazitatea = kapazitatea;
        this.titulua = titulua;
    }
    
    
    public int getKapazitatea() {
        return kapazitatea;
    }
    public void setKapazitatea(int kapazitatea) {
        this.kapazitatea = kapazitatea;
    }
    public String getTitulua() {
        return titulua;
    }
    public void setTitulua(String titulua) {
        this.titulua = titulua;
    }
    
    
    @Override
    public String toString() {
        return "Playlist [kapazitatea=" + kapazitatea + ", titulua=" + titulua + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        return kapazitatea == other.kapazitatea && Objects.equals(titulua, other.titulua);
    }

    
}