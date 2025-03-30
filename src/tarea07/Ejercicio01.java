package tarea07;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

/**
 * Ejercicio 1. Creando conjuntos de ciclos DAW y DAM con sus módulos
 *
 * @author Antonio Naranjo Castillo
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
        String[] arrayModulosDAW = Utilidades.getArrayModulosDAW();
        String[] arrayModulosDAM = Utilidades.getArrayModulosDAM();
        
        // Variables auxiliares

        // Variables de salida
        Set<String> modulosDAW = new HashSet<>();
        Set<String> modulosDAM = new HashSet<>();
        Set<String> unionModulos = new HashSet<>();
        Set<String> interseccionModulos = new HashSet<>();
        Set<String> diferenciaModulos = new HashSet<>();
        
        
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
        modulosDAW.addAll(Arrays.asList(arrayModulosDAW));
        modulosDAM.addAll(Arrays.asList(arrayModulosDAM));
        
        // Inicialimando las colecciones que vamos autilizar
        
        // Al usar conjuntos (Set) garantizamos que no se pueden repetir elementos
        
        // Rellenamos los conjuntos de los ciclos con sus módulos correspondientes
        
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
