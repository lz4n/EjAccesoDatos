public class TiempoConcatenaciones {
    private static final int INTERACCIONES = 100000;
    public static void  main(String[] args) {
        long tiempoInicio, tiempoFinal;

        //StringBuffer
        StringBuffer stringBuffer = new StringBuffer("->");
        tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < TiempoConcatenaciones.INTERACCIONES; i++) {
            stringBuffer.append("#");
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("StringBuffer " + (tiempoFinal - tiempoInicio));

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder("->");
        tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < TiempoConcatenaciones.INTERACCIONES; i++) {
            stringBuilder.append("#");
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("StringBuilder " + (tiempoFinal - tiempoInicio));

        //String
        String string = "->";
        tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < TiempoConcatenaciones.INTERACCIONES; i++) {
            string += "#";
        }
        tiempoFinal = System.currentTimeMillis();
        System.out.println("String " + (tiempoFinal - tiempoInicio));
    }
}
