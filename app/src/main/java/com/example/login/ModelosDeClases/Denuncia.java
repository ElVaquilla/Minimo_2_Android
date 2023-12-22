package com.example.login.ModelosDeClases;

public class Denuncia {
    String date;
    String title;
    String message;
    String sender;

    public Denuncia(){}
    public Denuncia(String date, String title, String message, String sender){
        this.date = date;
        this.title = title;
        this.message = message;
        this.sender = sender;
    }
    public String getDate(){return this.date;}
    public String getTitle(){return this.title;}
    public String getMessage(){return this.message;}
    public String getSender(){return this.sender;}
    public void setDate(String date){this.date = date;}
    public void setTitle(String title){ this.title = title;}
    public void setMessage(String message){this.message = message;}
    public void setSender(String sender){this.sender = sender;}
}
