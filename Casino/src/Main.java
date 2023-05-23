public class Main {
    public static void main(String[] args) {
        Banca banca = new Banca(10000);
        Coupier coupier = new Coupier();


        Thread jugadorNumero = new Thread(new JugadorNumero(100, banca, coupier));
        //Thread jugadorColor = new Thread(new JugadorColor(100,banca,coupier));
        jugadorNumero.start();
        //jugadorColor.start();


        while (banca.getSaldo() > 0) {
            synchronized (banca) {
                try {

                    System.err.println("Saldo banca:" + banca.getSaldo());
                    coupier.lanzarBola();
                    System.err.println("numero ganador: " + coupier.getNumeroRuleta());

                    banca.notify();

                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            //jugadorColor.join();
            jugadorNumero.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}