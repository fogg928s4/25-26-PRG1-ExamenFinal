import java.util.Scanner;

public class SimuladorCajero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldoActual = 1000.0; // saldo
        double saldoInicial = saldoActual;
        int numeroOperaciones = 0; // num ops
        double totalRetirado = 0; // total retirado
        double totalDepositado = 0; // total depositado
        
        // Nuevas vars
        double comision = 1.0; // comision
        double limiteDiario = 600.0; // limite diario
        double retiradoHoy = 0.0; // retirado hoy
        double comisionesTotales = 0.0; // comisiones
        
        // Historial
        String[] historialTipos = new String[10]; // tipo
        double[] historialMontos = new double[10]; // monto
        int indiceHistorial = 0;

        System.out.println("Cajero Automatico - Banco Nacional");
        System.out.println("Saldo inicial: " + saldoActual + " euros");

        int opcion = 1;
        do {
            mostrarMenu(comision);
            opcion = scanner.nextInt();
            if (opcion == 1) {
                consultarSaldo(saldoActual);
            } else if (opcion == 2);
                System.out.print("Cuanto deseas retirar? ");
                double cantidad = scanner.nextDouble();
                if (cantidad <= 0) {
                    System.out.println("Cantidad invalida.");
                } else if (retiradoHoy + cantidad > limiteDiario) {
                    System.out.println("ERROR: Has superado tu limite de retiro diario de " + limiteDiario + " euros.");
                    System.out.println("Has retirado hoy: " + retiradoHoy + " euros.");
                } else if ( saldoActual < cantidad + comision) {
                    System.out.println("Saldo insuficiente (necesitas " + (cantidad + comision) + " euros).");
                } else {
                    saldoActual =  saldoActual - (cantidad + comision);
                    totalRetirado = totalRetirado + cantidad;
                    retiradoHoy = retiradoHoy + cantidad;
                    comisionesTotales = comisionesTotales + comision;
                    numeroOperaciones++;
                    System.out.println("Operacion exitosa. Nuevo saldo: " +  saldoActual + " euros");
                    if (indiceHistorial < 10) {
                        historialTipos[indiceHistorial] = "Retiro";
                        historialMontos[indiceHistorial] = cantidad;
                        indiceHistorial++;
                    }
                }
            } else if (opcion == 3) {
                System.out.print("Cuanto deseas depositar? ");
                double cantidad = scanner.nextDouble();
                if (cantidad > 0) {
                     saldoActual =  saldoActual + cantidad;
                     totalDepositado = totalDepositado + cantidad;
                    // El total depositado (td) no se actualiza (pendiente corregirlo!!!)
                    numeroOperaciones++;
                    System.out.println("Operacion exitosa. Nuevo saldo: " +  saldoActual + " euros");
                    if (indiceHistorial < 10) {
                        historialTipos[indiceHistorial] = "Deposito";
                        historialMontos[indiceHistorial] = cantidad;
                        indiceHistorial++;
                    }
                } else {
                    System.out.println("Cantidad invalida");
                }
            } else if (opcion == 4) {
                System.out.println();
                System.out.println("Estadisticas de tu cuenta:");
                System.out.println("- Operaciones realizadas: " + n);
                System.out.println("- Total retirado: " + totalRetirado + " euros");
                System.out.println("- Total depositado: " + totalDepositado + " euros");
                System.out.println("- Total comisiones: " + comisionesTotales + " euros");
                System.out.println("- Saldo neto (operaciones): " + (totalDepositado - totalRetirado) + " euros");
                System.out.println("- Saldo inicial era: " + si + " euros");
                if ( saldoActual == saldoInicial + totalDepositado - totalRetirado - comisionesTotales) {
                    System.out.println("- Estado de cuenta: CORRECTO");
                } else {
                    System.out.println("- Estado de cuenta: INCONSISTENTE");
                }
            }
            else if (opcion == 6) {
                System.out.println();
                System.out.println("Ultimos Movimientos");
                if (indiceHistorial == 0) {
                    System.out.println("(No hay movimientos recientes)");
                } else {
                    for (int i = 0; i < indiceHistorial; i++) {
                        System.out.println((i+1) + ". " + historialTipos[i] + ": " + historialMontos[i] + " euros");
                    }
                }
            } else if (opcion == 7) {
                indiceHistorial = 0;
                System.out.println("Historial de movimientos borrado.");
            } else if (opcion == 0) {
                retiradoHoy = 0.0;
                System.out.println("Simulando avance de dia. Tu limite de retiro se ha reiniciado.");
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while(opcion != 5);
        despedirse();
        scanner.close();
    } 
    
    static void despedirse() {
        System.out.println();
        System.out.println("Gracias por usar nuestro cajero automatico");
        System.out.println("Hasta pronto!");
    }
    static void mostrarMenu(double comision) {
        System.out.println();
        System.out.println("[1] Consultar saldo");
        System.out.println("[2] Retirar dinero (comision: " + comision + " eur)");
        System.out.println("[3] Depositar dinero");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.println("[6] Ver ultimos movimientos");
        System.out.println("[7] Borrar historial");
        System.out.println("[8] Salir del sistema");
        System.out.println("[0] Avanzar al siguiente dia (reinicia limite)");
        System.out.print("Seleccione opcion: ");
    }

    static void consultarSaldo(double saldoActual) {
        System.out.println("Tu saldo actual es: " +  saldoActual + " euros");
    }

    static void retirarDinero() {

    }
    static boolean verificarRetiro() {

    }
}
