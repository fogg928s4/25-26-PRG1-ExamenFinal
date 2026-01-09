# Observaciones y Correciones


## Nomenclatura de variables

Se han realizado los siguientes cambios a los nombres de las variables

`s` -> `saldoActual`
`si` -> `saldoInicial`
`n` -> `numeroOperaciones`
`sc` -> `scanner`
`tr` -> `totalRetirado`
`td` -> `totalDepositado`
`com` -> `comision`
`lim_d` -> `limiteDiario`
`r_hoy` -> `retiradoHoy`
`com_tot` -> `comisionesTotales`
`o` -> `opcion`
`hist_t` -> `historialTipos`
`hist_m` -> `historialMontos`
`hist_idx` -> `indiceHistorial`
`c` -> `cantidad`
`com_tot` -> `comisionesTotales`

## Actualizacion de Total Depositado

En la línea 69 se realiza la actualización que quedaba pendiente del total depositado

```java
   totalDepositado = totalDepositado + cantidad;
```

## Cambio en funcionamiento del ciclo principal

El ciclo principal de funcionamiento fue cambiado para permitir una salida del sistema. Con ello pasa de
```java
   while(true) {
	int opcion = scanner.nextInt();
	...
   }
```

a la forma siguiente:

```java
	int opcion;
   do {
		opcion = scanner.nextInt();
		...
   } while(opcion != 5);
```


## Creacion de metodos para elementos del menú

Para cada acción del menú, se han creado métodos estáticos para mejorar la legibilidad y limpieza del código.

### Guardar en historial

Se crea un método estático que permite actualizar el historial de transacciones de forma más limpia. Este retorna un número según se hayan realizado cambios o no al historial (+1 o 0 si no se realizaron cambios). Este número se suma al índice global del historial.

### [3] Depositar Dinero

Creación de un método estático para depositar dinero al presionar la opción 3 del menú. Esta actualiza el saldo actual con la cantidad depositada (previamente verificada) y muestra un mensaje de éxito al usuario.

```java
    static double depositarDinero(double saldoActual,double totalDepositado, double cantidad) {
         saldoActual =  saldoActual + cantidad;
         totalDepositado = totalDepositado + cantidad;
         // El total depositado (td) no se actualiza (pendiente corregirlo!!!)
         System.out.println("Operacion exitosa. Nuevo saldo: " +  saldoActual + " euros");
    }
```

Este método siempre toma en cuenta la actualización del total depositado que se realizó en un commit anterior.

### [4] Ver Estadisticas

Creación de un método estático para la visualización de las estadísticas de la cuenta bancaria. Este toma los datos de la cuenta y se los presenta al usuario.

```java
    static void mostrarEstadisticas(int numeroOperaciones, double totalRetirado, double totalDepositado, double comisionesTotales, double saldoInicial) {
        System.out.println("Estadisticas de tu cuenta:");
        ...
        if ( esConsistenteCuenta(saldoActual,saldoInicial, totalDepositado,totalRetirado, comisionesTotales)) {
            System.out.println("- Estado de cuenta: CORRECTO");
        } else {
            System.out.println("- Estado de cuenta: INCONSISTENTE");
        }
    }
```

### [6] Ver Últimos Movimientos

Se crea un método estático para ver los últimos movimientos realizados. Un sencillo ciclo for que recorre el historial de tipos y de montos.

```java
    static void verUltimosMovimientos(String historialTipos, double historialMontos, int indice) {
        System.out.println();
        System.out.println("Ultimos Movimientos");
        if (indiceHistorial == 0) {
            System.out.println("(No hay movimientos recientes)");
        } else {
            for (int i = 0; i < indiceHistorial; i++) {
                System.out.println((i+1) + ". " + historialTipos[i] + ": " + historialMontos[i] + " euros");
            }
        }
    }
```
