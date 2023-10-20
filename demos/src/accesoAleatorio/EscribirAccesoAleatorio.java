package accesoAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirAccesoAleatorio {
    protected final static File FICHERO = new File("demos/src/accesoAleatorio/test2.dat");
    protected static final int LONGITUD_APELLIDO = 20,
            TAMANO_TOTAL = Integer.BYTES + EscribirAccesoAleatorio.LONGITUD_APELLIDO*Character.BYTES + Integer.BYTES + Double.BYTES,
            POS_DEPARTAMENTO = Integer.BYTES + EscribirAccesoAleatorio.LONGITUD_APELLIDO*Character.BYTES,
            POS_SALARIO = Integer.BYTES + EscribirAccesoAleatorio.LONGITUD_APELLIDO*Character.BYTES + Integer.BYTES;
    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(EscribirAccesoAleatorio.FICHERO, "rw")) {
            StringBuilder stringBuilder;

            int[] idTrabajadores = new int[]{1, 2, 3, 4, 5, 6, 7},
            departamentoTrabajadores = new int[] {10, 20, 10, 10, 30, 30, 20};
            String[] apellidoTrabajadores = new String[]{"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
            double[] salarioTrabahadores = new double[]{10, 24, 30, 15, 22, 14, 20};

            //Borramos el contenido del fichero
            randomAccessFile.setLength(0);

            for (int indice = 0; indice < idTrabajadores.length; indice++) {
                randomAccessFile.writeInt(idTrabajadores[indice]);

                //Para que todos los apellidos midan lo mismo
                stringBuilder = new StringBuilder(apellidoTrabajadores[indice]);
                stringBuilder.setLength(EscribirAccesoAleatorio.LONGITUD_APELLIDO);
                randomAccessFile.writeChars(stringBuilder.toString());

                randomAccessFile.writeInt(departamentoTrabajadores[indice]);
                randomAccessFile.writeDouble(salarioTrabahadores[indice]);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
