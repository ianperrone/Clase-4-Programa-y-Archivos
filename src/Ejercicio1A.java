import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* a. haga un main, donde por parámetro ponga 3 números y una letra que
represente ascendente o descendente y los muestre ordenados por tal criterio */


public class Ejercicio1A {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ingrese el primer número a ordenar: ");
        int primerNumero = scaner.nextInt();
        System.out.println("Ingrese el segundo número a ordenar: ");
        int segundoNumero = scaner.nextInt();
        System.out.println("Ingrese el tercer número a ordenar: ");
        int tercerNumero = scaner.nextInt();
        System.out.println("Escriba la letra 'a' si quiere ordenarlo ascendentemente, sino otra letra: ");
        char ascOdesc = scaner.next().charAt(0);

        ordenarArray(primerNumero, segundoNumero, tercerNumero, ascOdesc);
    }
    public static void ordenarArray(int num1, int num2, int num3, char orden){
        Integer ordenarNumeros[] = new Integer[]{num1, num2, num3};
        if (Character.toLowerCase(orden) == 'a')
        {
            Arrays.sort(ordenarNumeros);
        }
        else {Arrays.sort(ordenarNumeros, Collections.reverseOrder());}
        System.out.println("El Array ordenado: ");
        for (int i = 0; i < ordenarNumeros.length; i++)
        {
            System.out.print(ordenarNumeros[i] + " - ");
        }
    }
}