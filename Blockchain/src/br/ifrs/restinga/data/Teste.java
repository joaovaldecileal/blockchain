/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.restinga.data;

import java.util.ArrayList;

/**
 *
 * @author yk.hjm
 */

public class Teste {
public static ArrayList<Block> blockchain = new ArrayList<Block>();
    

    public static void main(String[] args) {
        Chain c = new Chain();
	Block genesis = new Block("0");
        genesis.addTransacao(new Transacao("joao","pedro",1000));
        genesis.addTransacao(new Transacao("carlos","carlos", 5000));
        Block b2 = new Block(genesis.getHash());
        b2.addTransacao(new Transacao("pedro", "paulo",3000));
        Block b3  = new Block(b2.getHash());
        b3.addTransacao(new Transacao("carlos", "antonio", 3000));

	c.addBlock(b3);
        c.addBlock(b2);		
        c.addBlock(genesis);
        ChainValida();
	
        
//	for(int i = 1 ; i<=3;i++){
//            Block asdf = c.getBlock(i);
//  
//            if(i==1){
//                System.out.println("bloco: " + i +" valor: "  + asdf.getNonce()+
//                    " hash: " + asdf.getHash() );
//            }else{
//                System.out.println("bloco: " + i +" valor: " + asdf.getNonce()+
//                    " hash: " + asdf.getHash());
//            }
//	}
        
    }
    public static Boolean ChainValida() {
		Block blocoAtual; 
		Block blocoAnterior;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			blocoAtual = blockchain.get(i);
			blocoAnterior = blockchain.get(i-1);
			//compara o hash registrado e o hash calculado:
			if(!blocoAtual.getHash().equals(blocoAtual.calculaHash()) ){
				System.out.println("as hashes atuais não são iguais");			
				return false;
			}
			//comparar o hash anterior e o hash registrado
			if(!blocoAnterior.getHash().equals(blocoAtual.getHashAnterior()) ) {
				System.out.println("hashes anteriores não são iguais");
				return false;
			}
		}
                System.out.println("Blockchain é valida");
		return true;
	}
}
