package test;

class Beta extends Alpha{

	private int value = 51;

    public int incrementarValor (int value) throws ExceptionPrueba {
    	
   		this.value += value;
    	if(value > 100) {
       		throw new ExceptionPrueba();
    	}
    	
    	return this.value;
    }
    
    public String getType() {
    	return "beta";
    }
    
    public String message() {
    	return "hola";
    }
    
    
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
