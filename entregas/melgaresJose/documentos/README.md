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

Se crea un método estático que permite actualizar el historial de transacciones de forma más limpia.

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
