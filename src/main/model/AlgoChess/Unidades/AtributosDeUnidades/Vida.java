package model.AlgoChess.Unidades.AtributosDeUnidades;

public class Vida {

    private int valor;

    public Vida (int valorDeVida){
       valor = valorDeVida;
    }

    public void tomaDanio(int danio) {
        valor -= danio;
    }

    public boolean acabo() {
        return valor<=0;
    }

    public void recibiCuracion(int curacion) {
        valor += curacion;
    }

}
