/* 3. Tome el ejercicio B de la clase 3 y que por parámetro se pueda elegir si es una
codificación o decodificación, el valor del desplazo, y 2 archivos, uno para la entrada y
otro para la salida. Que por pantalla solo indique si terminó o no correctamente, los
resultados deben estar en el archivo de salida
*/

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaArchivoEntrada = "C:\\Users\\fabri\\Desktop\\Programacion\\NEORIS\\Clase 4-Programa y Archivos\\TextoACodificar.txt";
        String rutaArchivoSalida = "C:\\Users\\fabri\\Desktop\\Programacion\\NEORIS\\Clase 4-Programa y Archivos\\TextoCodificado.txt";
        System.out.println("Ingrese si quiere que sea una codificación (1) o decodificación (2): ");
        boolean codificador = false;
        int opcion = scanner.nextInt();
        if (opcion == 1){codificador = true;}else if(opcion == 2){codificador = false;}
        System.out.println("Ingrese la cantidad de veces que quiere que se desplace la de/codificación: ");
        int desplazamiento = scanner.nextInt();

        codificar(codificador, desplazamiento, rutaArchivoEntrada, rutaArchivoSalida);
    }

    public static void codificar(boolean codificacion, int desplazo, String entrada, String salida)
    {
        String textoACodificar = "";
        try {
            for (String linea : Files.readAllLines(Paths.get(entrada)))
            {
                textoACodificar += linea;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(codificacion)
        {
            String textoCodificado = codificacion(textoACodificar, desplazo);
            try {
                Files.writeString(Paths.get(salida), textoCodificado);
                System.out.println("Texto codificado con éxito");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{String textoDecodificado = decodificacion(textoACodificar, desplazo);
            try {
                Files.writeString(Paths.get(salida), textoDecodificado);
                System.out.println("Texto decodificado con éxito");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static String codificacion(String texto, int desplazo)
    {
        String cadenaCodificada = "";
        byte[] decodedBytes = texto.getBytes();
        for(int j = 0; j < desplazo; j++) {
            for (int i = 0; i < decodedBytes.length; i++) {
                decodedBytes[i]++;
            }
        }
        return cadenaCodificada = new String(decodedBytes);
    }
    public static String decodificacion(String texto, int desplazo)
    {
        String cadenaDecodificada = "";
        byte[] decodedBytes = texto.getBytes();
        for(int j = 0; j < desplazo; j++) {
            for (int i = 0; i < decodedBytes.length; i++) {
                decodedBytes[i]--;
            }
        }
        return cadenaDecodificada = new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
