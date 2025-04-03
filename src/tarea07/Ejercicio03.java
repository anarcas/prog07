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

    /**
     * Método principal de ejecución del programa del ejercicio 3
     * @param args Lista de cadenas de texto que se pasan como argumento
     */
    public static void main(String[] args) {
        
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        
        // Variables de entrada
        List<String> codigosModulosDAW;
                
        // Variables auxiliares
        int curso;
        int codigoModulo;
        String[] partes;
        List<Integer> listaModulos;
     
        // Variables de salida
        Map<Integer, List<Integer>> mapaCursos;


        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un array de elementos fijos
        
        System.out.println("CÓDIGOS DE LOS MÓDULOS DE DAW POR CURSOS");
        System.out.println("----------------------------------------");
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Rellenamos las listas de los ciclos con sus módulos correspondientes
        // Se emplea el método estático asList() de la clase Arrays en lugar de un bucle for
        codigosModulosDAW = Arrays.asList(Utilidades.getArrayCodigosModulosDAW());
        
        // Instanciamos las variables con las que vamos a trabajar
        mapaCursos = new TreeMap<>();
         
        // Recorremos la lista de códigos del ciclo de DAW (curso-codigo de modulo)
        // y creamos el mapa con cada curso y los codigos de los modulos correspondientes
        for (String codigo : codigosModulosDAW) {
            // Se usa el método split() para partir la cadena de texto en dos usando el guion "-" como deliminador
            partes = codigo.split("-");
            curso = Integer.parseInt(partes[0]);
            codigoModulo = Integer.parseInt(partes[1]);

            // Comprobamos si el curso ya está en el mapa
            listaModulos = mapaCursos.get(curso);

            // Si no existe el curso en el mapa, se inicia una nueva lista
            if (listaModulos == null) {
                listaModulos = new ArrayList<>();
                mapaCursos.put(curso, listaModulos);
            }

            // Añadimos el código del módulo a la lista correspondiente
            listaModulos.add(codigoModulo);
        }
        
        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        // Se usa el método keySet() para recorrer las claves del mapa
        for (Integer course : mapaCursos.keySet()) {
            // Se imprime en pantalla empleando el método printf()
            System.out.printf("Módulos de %dº curso: %s\n", course, mapaCursos.get(course));
        }
    }
}