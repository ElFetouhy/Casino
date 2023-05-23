public class JugadorNumero implements Runnable {
    int saldo;
    Banca banca;
    Coupier coupier;
    int numero;

    public JugadorNumero(int saldo, Banca banca, Coupier coupier) {
        this.saldo = saldo;
        this.banca = banca;
        this.coupier = coupier;
    }

    public void ganar(int cantidad) {
        this.saldo += cantidad;
    }

    public void apostar(int cantidad) {
        this.saldo -= cantidad;
    }

    @Override
    public void run() {

        while (banca.getSaldo() > 0 && this.saldo > 0) {
            synchronized (banca) {
                //System.out.println("Numero ganador:"+coupier.getNumeroRuleta());
                try {
                    banca.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                numero = (int) ((Math.random() * 37) + 1);
                System.out.println("Numero jugador: " + numero);


                if (coupier.getNumeroRuleta() == 0) {
                    apostar(10);
                    System.out.println("Banca gana...");
                    banca.sumarSaldo(10);
                    System.out.println("\t saldo jugador:" + this.saldo);
                } else if (coupier.getNumeroRuleta() == numero) {
                    System.out.println("Jugador gana!");
                    ganar(360);
                    banca.restarSaldo(360);
                    System.out.println("\t saldo jugador:" + this.saldo);
                } else {
                    System.out.println("Jugador pierde...");
                    apostar(10);
                    banca.sumarSaldo(10);
                    System.out.println("\t saldo jugador:" + this.saldo);
                }

            }
        }
    }
}
