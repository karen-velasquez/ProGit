package com.karen_velasquez.www.ProGit;

class MinibusNotFoundException extends RuntimeException {

	  MinibusNotFoundException(Long id) {
	    super("No se encontro el minibus" + id);
	  }
	}