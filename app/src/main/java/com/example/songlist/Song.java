package com.example.songlist;

public class Song {


    private String tittle;
    private String artiats;
    private String coverImage;
    private String SongURL;

    public Song () {}
    public Song(String tittle,String artiats,String coverImage,String SongURL){

        this.tittle =tittle;
        this.artiats=artiats;
        this.coverImage=coverImage;
        this.SongURL=SongURL;

    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getArtiats() {
        return artiats;
    }

    public void setArtiats(String artiats) {
        this.artiats = artiats;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getSongURL() {
        return SongURL;
    }

    public void setSongURL(String songURL) {
        SongURL = songURL;
    }
}
