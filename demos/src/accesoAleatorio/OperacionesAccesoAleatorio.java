package accesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class OperacionesAccesoAleatorio {
    private static RandomAccessFile randomAccessFile;
    public static void main(String[] args) {
        try {
            randomAccessFile = new RandomAccessFile(EscribirAccesoAleatorio.FICHERO, "rw");
            cambiarDepartamento(0, 59);
            System.out.print(sumSalarios());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void cambiarDepartamento(int trabajador, int nuevoDepartamento) throws IOException {
        randomAccessFile.seek((long) EscribirAccesoAleatorio.TAMANO_TOTAL * trabajador + EscribirAccesoAleatorio.POS_DEPARTAMENTO);
        randomAccessFile.writeInt(nuevoDepartamento);
    }

    private static double sumSalarios() throws IOException {
        double sumSalarios = 0;
        long pointer = EscribirAccesoAleatorio.POS_SALARIO;

        while (randomAccessFile.length() > pointer) {
            randomAccessFile.seek(pointer);
            sumSalarios += randomAccessFile.readDouble();
            pointer += EscribirAccesoAleatorio.TAMANO_TOTAL;
        }
        return sumSalarios;
    }
}
