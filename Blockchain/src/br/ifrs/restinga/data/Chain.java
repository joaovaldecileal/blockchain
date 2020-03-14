/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrs.restinga.data;

/**
 *
 * @author yk.hjm
 */

public class Chain {
    
    public static int dificuldade = 4;
    
    private Block first, last;
    private int total;
        public Chain() {
            this.first = null;
            this.last = null;
            this.total = 0;
	
        }
		
    public boolean isEmpyt() {
        return this.first == null && this.last==null;
	}
	
    public void addBlock(Block b) {
        b.mineBlock(dificuldade);
	if(this.isEmpyt()){
            this.first = b;
            this.last = b;
            
        }else {      
            
            b.setPrevious(this.last);
            
            this.last = b; 
        }
            this.total++;	
        }
		
    public Block getBlock(int index) {
        Block next = this.last;
	for(int i = this.total; i>index; i--){
            next = next.getPrevious(); 
        }		
        return next;
    }
}
