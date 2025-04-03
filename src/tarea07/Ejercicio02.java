package tarea07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

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
        String[] arrayModulosDAW;
        String[] arrayModulosDAM;
        Set<String> modulosMatriculadosUnicos;
        List<String> modulosMatriculados;
                
        // Variables auxiliares
        List<String> modulosDAWActualizados;
        Iterator<String> iterator;
        String modulo;
                        
        // Variables de salida
        List<String> modulosDAW;
        List<String> modulosDAM;
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No hay entrada de datos, pues se usa un número fijo de elementos
        System.out.println("LISTAS DE MÓDULOS");
        System.out.println("-----------------------------");

        // Inicializamos los arrays que vamos a utilizar
        arrayModulosDAW = Utilidades.getArrayModulosDAW();
        arrayModulosDAM = Utilidades.getArrayModulosDAM();
        
        // Instanciamos las colecciones para trabajar con ellas
        modulosMatriculados = new ArrayList<>();
        modulosMatriculadosUnicos = new HashSet<>();
        
        // Rellenamos las listas de los ciclos con sus módulos correspondientes
        modulosDAW = Arrays.asList(arrayModulosDAW);
        modulosDAM = Arrays.asList(arrayModulosDAM);
        

        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------

        //Instanciamos las variables necesarias
        modulosDAWActualizados = new ArrayList<>();
        
        // Filtrar módulos de DAW para matrícula y marcar los seleccionados mediante uso de iterador
        iterator = modulosDAW.iterator();

        while (iterator.hasNext()) {
            modulo = iterator.next();
            if (!modulo.contains("i")) {
                modulosMatriculados.add(modulo);
                modulosMatriculadosUnicos.add(modulo);
                modulosDAWActualizados.add("**" + modulo + "**");
            } else {
                modulosDAWActualizados.add(modulo);
            }
        }

        // Asignar la lista actualizada a modulosDAW
        modulosDAW = modulosDAWActualizados;
        
        System.out.println();
        System.out.printf("Contenido inicial de la lista de módulos de DAW:  \n");
        Utilidades.mostrarModulos(modulosDAW);
        
        System.out.println();   
        System.out.printf("Contenido inicial de la lista de módulos de DAM:  \n");
        Utilidades.mostrarModulos(modulosDAM);

        // Ordenación de la lista por nombre del módulo (alfabético) y la mostramos por pantalla
        System.out.println();  
        System.out.printf ("Ordenación de la lista de módulos de DAM por nombre (alfabético):\n");
        Collections.sort(modulosDAW, new ComparadorModuloPorNombre());
        Utilidades.mostrarModulos(modulosDAM);
               
        // Ordenación de la lista por código del módulo y la mostramos por pantalla
        System.out.println();  
        System.out.printf ("Ordenación de la lista de módulos de DAM por código:\n");
        Collections.sort(modulosDAM, new ComparadorModuloPorCodigo());
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
