package tarea07;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * Ejercicio 1. Creando conjuntos de ciclos DAW y DAM con sus módulos
 *
 * @author Antonio Naranjo Castillo
 */
public class Ejercicio01 {

    /**
     * Método principal de ejecución del programa del ejercicio 1
     * @param args Lista de cadenas de texto que se pasan como argumento
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
        String[] arrayModulosDAW;
        String[] arrayModulosDAM;
                
        // Variables auxiliares

        // Variables de salida
        Set<String> modulosDAW;
        Set<String> modulosDAM;
        Set<String> unionModulos;
        Set<String> interseccionModulos;
        Set<String> diferenciaModulos;
                
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay entrada de datos, pues se usa un número fijo de elementos
        System.out.println("CONJUNTOS DE MÓDULOS DE DAW Y DAM");
        System.out.println("--------------------------------");

        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Inicializamos los arrays que vamos a utilizar
        arrayModulosDAW = Utilidades.getArrayModulosDAW();
        arrayModulosDAM = Utilidades.getArrayModulosDAM();
        
        // Inicialimando las colecciones que vamos autilizar
        // Al usar conjuntos (Set) garantizamos que no se pueden repetir elementos
        modulosDAW = new HashSet<>();
        modulosDAM = new HashSet<>();
        unionModulos = new HashSet<>();
        interseccionModulos = new HashSet<>();
        diferenciaModulos = new HashSet<>();
        
        // Rellenamos los conjuntos de los ciclos con sus módulos correspondientes
        // Si se emplease un buble for se tendría:
        //        for (String modulo : arrayModulosDAW) {
        //            modulosDAW.add(modulo);
        //        }
        // Pero resulta un código más eficiente si se emplea el método estático asList() de la clase Arrays, tal que:
        modulosDAW.addAll(Arrays.asList(arrayModulosDAW));
        // Y de la misma manera con los módulos de DAM se tiene:
        modulosDAM.addAll(Arrays.asList(arrayModulosDAM));
        
        // Unión de los dos conjuntos
        unionModulos.addAll(modulosDAW);
        unionModulos.addAll(modulosDAM);
        
        // Intersección de los conjuntos
        interseccionModulos.addAll(modulosDAW);
        interseccionModulos.retainAll(modulosDAM);

        // Diferencia de los conjuntos
        diferenciaModulos.addAll(modulosDAM);
        diferenciaModulos.removeAll(modulosDAW);
        
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Recorremos los conjuntos y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1 (módulos DAW):\n");
        Utilidades.mostrarModulos(modulosDAW);

        System.out.printf("\nConjunto C2 (módulos DAM):\n");
        Utilidades.mostrarModulos(modulosDAM);

        System.out.printf("\nUnión C1 y C2:\n");
        Utilidades.mostrarModulos(unionModulos);

        System.out.printf("\nInterseccion C1 y C2:\n");
        Utilidades.mostrarModulos(interseccionModulos);

        System.out.printf("\nDiferencia C1 y C2:\n");
        Utilidades.mostrarModulos(diferenciaModulos);

    }
}
