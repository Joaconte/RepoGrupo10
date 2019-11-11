package fiuba.algo3.TP2.model;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class Jugador {

    private EstadoPresupuestoDeEjercito presupuesto;
    private String nombre;
    private Sector sector;
    private Ejercito ejercito;

    //---------Inicializacion---------//

    public Jugador(String nombre, Sector sector){
        this.presupuesto = new EstadoPresupuestoNoAgotado();
        this.nombre = nombre;
        this.sector = sector;
        this.ejercito = new Ejercito (nombre);
    }

    //-----------GETTERS-----------//

    public String getNombre(){
        return nombre;
    }
    public Sector getSector(){
        return sector;
    }
    public int getTamanioDelEjercito() {
        return this.ejercito.getTamanio();
    }

    //-----------Metodos Ejercito-------------//

    public void agregarUnidad(int costoUnidad){
        this.presupuesto.agregarPiezas(this.ejercito, costoUnidad);
        this.setearPresupuesto();
    }

    public void quitarUnidad(int posicion){
        this.ejercito.removerPieza(posicion);
    }

    //------------Metodo Presupuesto------------//

    public void setearPresupuesto(){
        this.presupuesto = presupuesto.devolverEstadoDePresuesto();
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
