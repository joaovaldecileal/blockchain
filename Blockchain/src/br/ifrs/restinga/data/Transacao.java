/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.restinga.data;

/**
 *
 * @author 10070267
 */
public class Transacao {
    private String from;
    private String to;
    private int value;
    private String hash;
    
    
     
    public Transacao(String from, String to,int value){
        this.from = from;
        this.to = to;
        this.value= value;
        this.hash = calculaHash();
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    private String calculaHash() {
        String calculaHash = CryptoFunc.getSHA2(
                getTo() + getFrom()+ Integer.toString(getValue()));
        return calculaHash;
    }
    
}
