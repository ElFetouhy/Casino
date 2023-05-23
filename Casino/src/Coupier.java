public class Coupier{

    int random;

    public synchronized void lanzarBola(){
        this.random= (int)(Math.random()*37);
    }

    public synchronized int getNumeroRuleta() {
        return random;
    }


}
