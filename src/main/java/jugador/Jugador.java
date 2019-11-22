package jugador;

import jugador.presupuesto.EstadoPresupuestoDeEjercito;
import jugador.presupuesto.EstadoPresupuestoNoAgotado;
import pieza.Pieza;
import pieza.Ubicacion;

public class Jugador {


    private int numeroDeJugador;
    private Sector sector;
    private Ejercito ejercito;

    //---------Inicializacion---------//

    public Jugador(int numeroDeJugador){

        this.numeroDeJugador = numeroDeJugador;
        this.sector = new Sector(numeroDeJugador);
        this.ejercito = new Ejercito (numeroDeJugador);
    }

    //-----------GETTERS-----------//

    public int getNumeroDeJugador(){
        return numeroDeJugador;
    }
    public Sector getSector(){
        return sector;
    }
    public int getTamanioDelEjercito() {
        return this.ejercito.getTamanio();
    }

    //-----------SETTERS-------------//



    //----------Agrega Ubicacion A Unidad--------------//

    public void agregarUbicacionAPieza(Pieza pieza, int posicionX, int posicionY) throws PiezaFueraDeSectorException {
        Ubicacion ubicacionNueva = new Ubicacion(posicionX, posicionY);
        if (!sector.esDelSector(posicionX)){ throw new PiezaFueraDeSectorException();}
        pieza.setUbicacion(ubicacionNueva);
    }

}

    /*    public void quitarUnidad(Ubicacion ubicacion) {
        for (int i = 0; i < ejercito.size(); ++i) {
            if(ejercito.get(i).getUbicacion() == ubicacion){
                ejercito.remove(i);
            }
        }
    }

    private Unidad menuUnidades() {

        byte i = '1';
        Scanner capt = new Scanner(System.in);
        while (i != '0') {

            System.out.println("Ingrese 0 para terminar la compra de unidades");
            System.out.println("Ingrese 1 para seleccionar la unidad Infanteria");
            System.out.println("Ingrese 2 para seleccionar la unidad Jinete");
            System.out.println("Ingrese 3 para seleccionar la unidad Curandero");
            System.out.println("Ingrese 4 para seleccionar la unidad Catapulta");
            i = capt.nextByte();
            Unidad unidad = opcionesUnidades(i);
        }
        return null;
    }
    */
