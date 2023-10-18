package ej12;

import java.io.*;

/**
 * Modifica el ejercicio anterior utilizando buffers en lugar de leer/escribir carácter a carácter. Además, el programa
 * deberá mostrar el contenido en MAYÚSCULAS. Salida esperada:<br>
 * &emsp;<i>ESTEESUNMÉTODOQUEAÑADECONTENIDOAUNFICHERODETEXTOCARÁCTERACARÁCTER</i>
 */
public class Main {
    private static final File ARCHIVO = new File("T1/src/ej12/caracteres.txt");
    private static final String TEXTO = "Este es un método que añade contenido a un fichero de texto carácter a carácter";

    public static void main(String[] args) {

        //Escritura en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Main.ARCHIVO))) {
            writer.write(Main.TEXTO);
        } catch (IOException exception) {
            System.err.print("Ha ocurrido un error de escritura.");
        }

        //Lectura del fichero
        try (BufferedReader reader = new BufferedReader(new FileReader(Main.ARCHIVO))) {
            System.out.print("El contenido sin espacios es: ");
            reader.lines().forEach(linea -> System.out.println(linea.replace(" ", "").toUpperCase()));
        } catch (IOException exception) {
            System.err.print("Ha ocurrido un error de escritura.");
        }
    }
}
