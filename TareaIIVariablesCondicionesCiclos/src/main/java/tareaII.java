import java.util.Scanner;

public class tareaII {
    static final int MAX_ESTUDIANTES = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes desea ingresar? (máximo 5): ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (cantidad < 1 || cantidad > MAX_ESTUDIANTES) {
            System.out.println("Cantidad inválida. Debe ser entre 1 y 5.");
            return;
        }

        String[] nombres = new String[cantidad];
        double[] promedios = new double[cantidad];
        String[] estados = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            double[] notas = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = sc.nextDouble();
            }
            sc.nextLine(); // Limpiar buffer

            promedios[i] = calcularPromedio(notas);
            estados[i] = estaAprobado(promedios[i]) ? "Aprobado" : "Reprobado";
        }

        mostrarResumen(nombres, promedios, estados);
    }

    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return Math.round((suma / notas.length) * 100.0) / 100.0; // Redondeo a 2 decimales
    }

    public static boolean estaAprobado(double promedio) {
        return promedio >= 61;
    }

    public static void mostrarResumen(String[] nombres, double[] promedios, String[] estados) {
        System.out.println("\nResumen de estudiantes:");
        System.out.println("------------------------");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("Nombre: %-10s Promedio: %.2f     Estado: %s%n",
                    nombres[i], promedios[i], estados[i]);
        }
    }
}
