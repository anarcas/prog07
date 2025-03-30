package tarea07;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


/**
 * Ejercicio 3. Mapa de Ciclos y sus módulos
 *
 * @author Antonio Naranjo Castillo
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
      
        // Variables auxiliares
        int curso;
        int codigoModulo;
     
        // Variables de salida


        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un array de elementos fijos
        
        System.out.println("CÓDIGOS DE LOS MÓDULOS DE DAW POR CURSOS");
        System.out.println("----------------------------------------");
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Instanciamos las variables con las que vamos a trabajar
        List<String> codigosModulosDAW = Arrays.asList(Utilidades.getArrayCodigosModulosDAW());
        Map<Integer, List<Integer>> mapaCursos = new TreeMap<>();
         
        // Recorremos la lista de códigos del ciclo de DAW (curso-codigo de modulo)
        // y creamos el mapa con cada curso y los codigos de los modulos correspondientes
        for (String codigo : codigosModulosDAW) {
            String[] partes = codigo.split("-");
            curso = Integer.parseInt(partes[0]);
            codigoModulo = Integer.parseInt(partes[1]);

            // Agregar el código del módulo a la lista correspondiente en el mapa
            mapaCursos.putIfAbsent(curso, new ArrayList<>());
            mapaCursos.get(curso).add(codigoModulo);
        }
        
        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        System.out.printf("Contenido del mapa de códigos de módulos organizados por cursos:\n\n");
        for (Map.Entry<Integer, List<Integer>> entry : mapaCursos.entrySet()) {
            System.out.printf("Curso %d: %s\n", entry.getKey(), entry.getValue());
        }
        
    }
}