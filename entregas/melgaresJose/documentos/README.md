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
   } while(opcion != 8);
```

Además agrega la opción **"[8] Salir del sistema"** al menú de opciones.


## Creacion de metodos para elementos del menú

Para cada acción del menú, se han creado métodos estáticos para mejorar la legibilidad y limpieza del código.