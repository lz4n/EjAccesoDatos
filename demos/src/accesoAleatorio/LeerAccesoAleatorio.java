package accesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class LeerAccesoAleatorio {
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(EscribirAccesoAleatorio.FICHERO, "r")) {
            char[] apellido = new char[EscribirAccesoAleatorio.LONGITUD_APELLIDO];

            while (randomAccessFile.length() > randomAccessFile.getFilePointer()) {
                System.out.println("Empleado:");

                System.out.printf("\tId: %d\n", randomAccessFile.readInt());

                for (int indice = 0; indice < apellido.length; indice++) {
                    apellido[indice] = randomAccessFile.readChar();
                }
                System.out.printf("\tNombre: %s\n", new String(apellido));

                System.out.printf("\tDepartamento: %d\n", randomAccessFile.readInt());

                System.out.printf("\tSalario: %.2f\n", randomAccessFile.readDouble());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
