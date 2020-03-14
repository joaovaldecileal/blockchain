/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.restinga.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yk.hjm
 */

public class Block {

  
    private String hash;
    private String hashAnterior;
    private Block previous;
    private String merkleRoot;
    private ArrayList<Transacao> transacao;
    private int nonce;
    
    
//    public Block(){
//        transacao.add(new Transacao("joao","pedro",1000));
//        transacao.add(new Transacao("pedro", "paulo",3000));
//        transacao.add(new Transacao("carlos", "antonio", 3000));
//        transacao.add(new Transacao("carlos","carlos", 5000));
//        
//    }
    public void mineBlock(int dificuldade) {
		merkleRoot = MerkleRoot(transacao);
		String target = CryptoFunc.DificuldadeString(dificuldade); 
		while(!hash.substring( 0, dificuldade).equals(target)) {
			nonce ++;
			hash = calculaHash();
		}
		System.out.println("Bloco minerado!!! : " + " nonce "+ nonce + " hash: " + hash);
	}
   public boolean addTransacao(Transacao transaction) {		
        transacao.add(transaction);
        System.out.println("Transação adicionada com sucesso ao bloco");
        return true;
	}

    public Block(String hasAnterior) {		
        this.transacao = new ArrayList<>();
        this.hashAnterior = hasAnterior;
        this.hash = calculaHash();
    }
    public final String calculaHash(){
        String calcula = CryptoFunc.getSHA2(
                getHashAnterior()+getMerkleRoot()+getNonce());
        return calcula;
    }
    
    
    public static String MerkleRoot(List<Transacao> transacoes) {
        int count = transacoes.size();
        List<String> arvore = new ArrayList<>();
        for(Transacao transacao : transacoes) {
               arvore.add(transacao.getHash());
        }
        List<String> arvoreHash = arvore;
        while(count > 1) {
                arvoreHash = new ArrayList<>();
                for(int i=1; i < arvore.size(); i+=2) {
                        arvoreHash.add(CryptoFunc.getSHA2(arvore.get(i-1) + arvore.get(i)));
                }
                count = arvoreHash.size();
                arvore= arvoreHash;
        }

        String merkleRoot = (arvoreHash.size() == 1) ? arvoreHash.get(0) : "";
        return merkleRoot;
    }
 

    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void setTransacao(List<Transacao> transacao) {
        this.transacao = (ArrayList<Transacao>) transacao;
    }

    public String getHashAnterior() {
        return hashAnterior;
    }

    public void setHashAnterior(String hashAnterior) {
        this.hashAnterior = hashAnterior;
    }
    
    public String getHash() {
        return hash;
    }

    public void setHash(String hash){
        this.hash = hash;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
 
    public Block getPrevious() {
        return this.previous;
    }

    public void setPrevious(Block b) {
        this.previous = b;
    }
    

}
