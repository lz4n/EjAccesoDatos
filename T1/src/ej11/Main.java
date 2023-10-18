package ej11;

import java.io.*;

/**
 * Utilizando código Java, crea un fichero de texto <code>caracteres.txt</code> con el siguiente contenido (escribiendo carácter a carácter):<br>
 * &emsp;<i>Este es un método que añade contenido a un fichero de texto carácter a carácter</i><br><br>
 * Almacénalo en el mismo paquete que el archivo <code>.java</code>. Lee el fichero de texto carácter a carácter y muestra
 * su contenido por pantalla sin espacios. Es decir, la salida de la consola deberá mostrar:<br>
 * &emsp;<i>Esteesunmétodoqueañadecontenidoaunficherodetextocarácteracarácter</i>
 */
public class Main {
    private static final File ARCHIVO = new File("T1/src/ej11/caracteres.txt");
    private static final String TEXTO = "Este es un método que añade contenido a un fichero de texto carácter a carácter";

    public static void main(String[] args) {

        //Escritura en el fichero
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Main.ARCHIVO))) {
            for (char caracter: Main.TEXTO.toCharArray()) {
                writer.write(caracter);
            }
        } catch (IOException exception) {
            System.err.print("Ha ocurrido un error de escritura.");
        }

        //Lectura del fichero
        try (BufferedReader reader = new BufferedReader(new FileReader(Main.ARCHIVO))) {
            int caracter;
            System.out.print("El contenido sin espacios es: ");
            while ((caracter = reader.read()) != -1) {
                if (caracter != ' ') {
                    System.out.print((char) caracter);
                }
            }
        } catch (IOException exception) {
            System.err.print("Ha ocurrido un error de escritura.");
        }
    }
}
