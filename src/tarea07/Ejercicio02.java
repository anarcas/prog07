package tarea07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Ejercicio 2. Trabajando con listas de módulos
 *
 * @author Antonio Naranjo Castillo
 */
public class Ejercicio02 {

    /**
     * Método principal de ejecución del programa del ejercicio 2
     * @param args
     */
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
                
        // Variables auxiliares
                        
        // Variables de salida
                
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No hay entrada de datos, pues se usa un número fijo de elementos
        System.out.println("LISTAS DE MÓDULOS");
        System.out.println("-----------------------------");

        // Inicializamos los arrays que vamos a utilizar
        List<String> modulosMatriculados = new ArrayList<>();
        Set<String> modulosMatriculadosUnicos = new HashSet<>();
        
        // Instanciamos las colecciones para trabajar con ellas
        List<String> modulosDAW = new ArrayList<>(Arrays.asList(Utilidades.getArrayModulosDAW()));
        List<String> modulosDAM = new ArrayList<>(Arrays.asList(Utilidades.getArrayModulosDAM()));
        
        // Rellenamos las listas de los ciclos con sus módulos correspondientes

        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------

        // Filtrar módulos de DAW para matrícula y marcar los seleccionados
        ListIterator<String> iterator = modulosDAW.listIterator();
        while (iterator.hasNext()) {
            String modulo = iterator.next();
            if (!modulo.contains("i")) {
                modulosMatriculados.add(modulo);
                modulosMatriculadosUnicos.add(modulo);
                iterator.set("**" + modulo + "**");
            }
        }
        
        //Instanciamos las variables necesarias
        System.out.println();
        System.out.printf("Contenido inicial de la lista de módulos de DAW:  \n");
        Utilidades.mostrarModulos(modulosDAW);
        
        System.out.println();   
        System.out.printf("Contenido inicial de la lista de módulos de DAM:  \n");
        Utilidades.mostrarModulos(modulosDAM);

        // Recorremos la lista de modulos de DAW
                
        // Ordenación de la lista por nombre del módulo (alfabético) y la mostramos por pantalla
        System.out.println();  
        System.out.printf ("Ordenación de la lista de módulos de DAM por nombre (alfabético):\n");
        modulosDAM.sort(new ComparadorModuloPorNombre());
        Utilidades.mostrarModulos(modulosDAM);
               
        // Ordenación de la lista por código del módulo y la mostramos por pantalla
        System.out.println();  
        System.out.printf ("Ordenación de la lista de módulos de DAM por código:\n");
        modulosDAM.sort(new ComparadorModuloPorCodigo());
        Utilidades.mostrarModulos(modulosDAM);

        
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        
        System.out.println();     
        System.out.printf("Contenido final de la lista de módulos de DAW:  \n");
        Utilidades.mostrarModulos(modulosDAW);
        
        System.out.println();   
        System.out.printf("Contenido final de la lista de módulos matriculados (DAW): \n");
        Utilidades.mostrarModulos(modulosMatriculados);
                    
        System.out.println();   
        System.out.printf("Contenido final del conjunto de módulos matriculados (DAW): \n");
        Utilidades.mostrarModulos(modulosMatriculadosUnicos);
   
    }
}

/**
 * Clase que permite comparar dos módulos usando como criterio
 * de comparación su nombre. Se trata de una comparación alfabética.
 */
class ComparadorModuloPorNombre implements Comparator<String> {

    @Override
    public int compare(String m1, String m2) {
        return m1.split("-")[1].compareTo(m2.split("-")[1]);
    }
}

/**
 * Clase que permite comparar dos módulos usando como criterio
 * de comparación su código.
 */
class ComparadorModuloPorCodigo implements Comparator<String> {
    @Override
    public int compare(String m1, String m2) {
        return Integer.compare(Integer.parseInt(m1.split("-")[0]), Integer.parseInt(m2.split("-")[0]));
    }
}
