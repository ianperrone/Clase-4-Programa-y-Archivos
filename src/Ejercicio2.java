import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/* 2. Haga una main donde por parámetro envíe la ruta de un archivo. Ese archivo debe
contener números. El programa debe escribir por consola la suma de esos números
    a. Al programa anterior agreguele un parámetro para que la operación pueda ser
    suma o multiplicación */

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String archivo = "C:\\Users\\fabri\\Desktop\\Programacion\\NEORIS\\Clase 4-Programa y Archivos\\numeros.txt";
        System.out.println("Si quiere que se realice una suma, escriba 'suma'. De lo contrario será una multiplicacion: ");
        String opcion = scn.nextLine().toLowerCase();
        SumaoMultiplicacion(archivo, opcion);
    }

    public static void SumaoMultiplicacion(String archivo, String opcion)
    {
        try {
            int suma = 0;
            int multiplicacion = 0;
            int vueltas = 0;
            for (String lineas : Files.readAllLines(Paths.get(archivo)))
            {
                String[] numeros = lineas.split(" ");
                multiplicacion = Integer.parseInt(numeros[0]);
                for (String numero: numeros)
                {
                    int valor = Integer.parseInt(numero);
                    if (!opcion.equals("suma"))
                    {
                        if (vueltas != 0){multiplicacion *= valor;}
                    }
                    else
                    {
                        suma += valor;
                    }
                    vueltas += 1;
                }
            }
            if(opcion.equals("suma"))
            {
                System.out.println("La suma total de los números es: " + suma);
            }
            else{System.out.println("La multiplicación total de los números es: " + multiplicacion);}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
