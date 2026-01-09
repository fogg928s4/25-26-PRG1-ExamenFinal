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