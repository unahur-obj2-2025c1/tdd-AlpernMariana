package ar.edu.unahur.obj2.tdd;

import java.util.function.BooleanSupplier;

public class CajaFuerte {

    private Boolean abierta;
    private Integer clave;
    private int intentosFallidos = 0;

    /*documento que al principio esta abierta, si no definimos un constructor, se crea
     * un constructor por defecto sin parámetros. Pero si hacemos uno, el por defecto,
     * no existe más */

    public CajaFuerte(){        
        this.abierta = true;
    }

    public Boolean estaAbierta() {
        return abierta;
    }

    public void cerrar(Integer clave) {
        if(this.abierta){         /* si la puerta esta abierta, le digo actualiza la clave y cerrala */
           this.clave = clave;
           this.abierta = false;
        }
     
    }

    public void abrir(Integer clave) {
        if(this.clave.equals(clave) && !this.estaBloqueada()){ 
        this.abierta = true;
        this.intentosFallidos = 0;  /*reseteo cantidad intentos fallidos */
        }else{
            this.intentosFallidos++; /*incremento los intentos fallidos */
        }
    }

    public Boolean estaBloqueada() {
        return this.intentosFallidos >= 3;
        
    }

}
