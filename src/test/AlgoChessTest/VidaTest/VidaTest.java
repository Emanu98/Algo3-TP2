package AlgoChessTest.VidaTest;

import model.AlgoChess.Unidades.AtributosDeUnidades.Vida;
import org.junit.Test;
import org.junit.Assert;

public class VidaTest {

    @Test
    public void creoVidaConValorCienLaBajoHastaCeroAcaboDevuelveTrue() {
        Vida vida = new Vida (100);
        vida.tomaDanio(100);
        Assert.assertTrue (vida.acabo());
    }

    @Test
    public void creoVidaConValorCincuentaLaBajoHastaUnoAcaboDevuelveFalse() {
        Vida vida = new Vida (50);
        vida.tomaDanio(49);
        Assert.assertFalse (vida.acabo());
    }

    @Test
    public void BajoVidaHastaCeroLaCuroAcaboDevuelveFalse() {
        Vida vida = new Vida (50);
        vida.tomaDanio(51);
        vida.recibiCuracion(2);
        Assert.assertFalse (vida.acabo());
    }

}
