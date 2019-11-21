package model.AlgoChess.Unidades;

import model.AlgoChess.Equipos.Equipo;
import model.AlgoChess.Excepciones.CasilleroEnemigoExcepcion;
import model.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import model.AlgoChess.Excepciones.CoordenadaFueraDeRangoExcepcion;
import model.AlgoChess.Excepciones.NoAlcanzanPuntosExcepcion;
import model.AlgoChess.Tablero.Casillero;
import model.AlgoChess.Unidades.AtributosDeUnidades.*;

public abstract class Unidad {

    Casillero ubicacion;

    Vida vida;

    Costo costo;

    protected Equipo equipo;
    public Unidad(Equipo unEquipo){
        equipo = unEquipo;
    }

    public void inicializarEnCasillero(Casillero unCasillero) throws CasilleroEnemigoExcepcion, CasilleroOcupadoExcepcion {

        if(equipo.esEnemigoDeCasillero(unCasillero)){
            throw new CasilleroEnemigoExcepcion();
        }

        unCasillero.ocuparCasillero();
        ubicacion = unCasillero;
    }
    public boolean esDelEquipo(Equipo unEquipo){
        return equipo.esIgualA(unEquipo);
    }

    public void recibirCuracion(int curacion) {
        vida.recibiCuracion(curacion);
    }

    public void sufrirDanio (int dmg) {
        vida.tomaDanio(dmg);
    }

    public boolean murio() {
        return (vida.acabo());
    }

    public int comprar (int fondos) throws NoAlcanzanPuntosExcepcion {
        return costo.descontarCosto (fondos);
    }

    public void atacar(Unidad objetivo) {};

    public boolean esAdyacenteA(Casillero unCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.esAdyacenteA(unCasillero);
    }

    public boolean estaEnRangoCercanoDe(Casillero unCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoCercanoDe(unCasillero);
    }

    public boolean estaEnRangoMedianoDe(Casillero unCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoMedianoDe(unCasillero);
    }

    public boolean estaEnRangoLejanoDe(Casillero unCasillero) throws CoordenadaFueraDeRangoExcepcion {
        return ubicacion.estaEnRangoLejanoDe(unCasillero);
    }

}
