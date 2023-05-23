public class JugadorColor implements Runnable {
    int numero;
    String color;
    Banca banca;
    Coupier coupier;
    int saldo;
    public JugadorColor(int saldo,Banca banca, Coupier coupier) {
        this.saldo=saldo;
        this.banca= banca;
        this.coupier=coupier;
    }

    @Override
    public void run() {
        while(banca.getSaldo()>0){

            numero=(int)((Math.random()*99)+1);

        }
    }
}
