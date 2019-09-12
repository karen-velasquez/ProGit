package com.karen_velasquez.www.ProGit;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
	@Entity
	class Minibus{
		private @Id @GeneratedValue Long id;
		private int numero;
		private String p_partida;
		 
		Minibus(){}
			Minibus(int numero, String p_partida){
				this.numero=numero;
				this.p_partida=p_partida;
		}
		

}