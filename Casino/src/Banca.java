public class Banca {
    int saldo;
    public Banca(int saldo){
        this.saldo=saldo;
    }

    public void sumarSaldo(int cantidad) {
        this.saldo +=cantidad;
    }
    public void restarSaldo(int cantidad){
        this.saldo-=cantidad;
    }

    public int getSaldo() {
        return saldo;
    }
}
