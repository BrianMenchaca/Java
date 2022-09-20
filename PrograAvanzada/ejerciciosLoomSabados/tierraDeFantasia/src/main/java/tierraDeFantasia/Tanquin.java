package tierraDeFantasia;

public class Tanquin extends Raza {

    private int saludMaxima;
    private boolean medita;
    
    
    public Tanquin() {
        super();
        salud=300;
        rangoAtaque=3;
        this.dañoBasico=82;
        saludMaxima=salud;
        medita = false;
    }

 

    @Override
    public void atacar(Raza obj) {
        if(this.puedeAtacar()) {
            obj.recibirAtaque(this.dañoBasico);        
            this.medita = false;
        } else {
            System.out.println("No puede atacar");
        }
    }

 

    @Override
    public void descansar() {
        this.medita = true;
        this.salud =+ 100;
    }

 

    @Override
    public void recibirAtaque(int p) {
        salud -= p*2;
    }

 

    @Override
    public void moverse() {
        // TODO Auto-generated method stub
        
    }
    
    public boolean puedeAtacar() {
        return !medita;
    }

 

}