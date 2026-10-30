/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.Scanner;

/**
 *
 * @author veliz
 */
public class programa {
    
    
    public static void proyectoVenta() {

            // crear variable que escanea consola para asignar datos a variables
            Scanner teclado = new Scanner(System.in);

             // creacion de variables del menu principal
             int opcion;

             // creacion de variables para registrar una venta
             int cantidadProductos;
             int cantidad;
             int i;
             int opcionPago;

             String codigo;
             String nombre;
             String formaPago;

             double precio;
             double subtotalProducto;
             double subtotal;
             double descuento;
             double montoDescuento;
             double iva;
             double total;
             double efectivo;
             double cambio;

             // creacion de variables para consultar caja y estadisticas
             int ventasRealizadas = 0;
             int productosVendidos = 0;
             int ventasEfectivo = 0;
             int ventasTarjeta = 0;
             int ventasTransferencia = 0;

             double totalVendido = 0;
             double promedio = 0;
             double ventaMayor = 0;
             double ventaMenor = 0;

             // variable para controlar la primera venta
             int primeraVenta = 0;

             // menu principal mediante do-while
              do {

             System.out.println(" ");
             System.out.println("===== SISTEMA DE VENTAS =====");
             System.out.println(" ");
             System.out.println("1. Registrar una venta");
             System.out.println("2. Consultar caja");
             System.out.println("3. Mostrar estadisticas");
             System.out.println("4. Salir");
             System.out.println("------------------------------------");
             System.out.println("Ingrese una opcion:");
             System.out.println("====================================");
             opcion = teclado.nextInt();

             // validacion del menu principal
              while (opcion < 1 || opcion > 4) {
             System.out.println("Opcion incorrecta.");
             System.out.println("Ingrese una opcion del 1 al 4:");
             opcion = teclado.nextInt();
        }

        // seleccion de opciones mediante switch
        switch (opcion) {

            case 1:

                // registrar una venta

                // inicializacion de variables de la venta
                subtotal = 0;
                descuento = 0;
                montoDescuento = 0;
                iva = 0;
                total = 0;
                efectivo = 0;
                cambio = 0;

                // ingreso de la cantidad de productos
                System.out.println("Ingrese la cantidad de productos:");
                cantidadProductos = teclado.nextInt();

                // validacion de la cantidad de productos
                while (cantidadProductos <= 0) {
                    System.out.println("La cantidad debe ser mayor que cero.");
                    System.out.println("Ingrese nuevamente la cantidad:");
                    cantidadProductos = teclado.nextInt();
                }

                // ingreso de productos mediante ciclo for
                for (i = 1; i <= cantidadProductos; i++) {

                    System.out.println("Ingrese el codigo del producto:");
                    codigo = teclado.next();

                    System.out.println("Ingrese el nombre del producto:");
                    nombre = teclado.next();

                    System.out.println("Ingrese el precio del producto:");
                    precio = teclado.nextDouble();

                    // validacion del precio
                    while (precio <= 0) {
                        System.out.println("El precio debe ser mayor que cero.");
                        System.out.println("Ingrese nuevamente el precio:");
                        precio = teclado.nextDouble();
                    }

                    System.out.println("Ingrese la cantidad del producto:");
                    cantidad = teclado.nextInt();

                    // validacion de la cantidad
                    while (cantidad <= 0) {
                        System.out.println("La cantidad debe ser mayor que cero.");
                        System.out.println("Ingrese nuevamente la cantidad:");
                        cantidad = teclado.nextInt();
                    }

                    // operacion. Calcula el subtotal del producto
                    subtotalProducto = precio * cantidad;

                    // acumulacion del subtotal
                    subtotal = subtotal + subtotalProducto;

                    // acumulacion de productos vendidos
                    productosVendidos = productosVendidos + cantidad;

                    // muestro los datos del producto
                    System.out.println("Codigo: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Subtotal del producto: Q" + subtotalProducto);
                }

                // calculo del descuento
                if (subtotal < 200) {
                    descuento = subtotal * 0;
                } else if (subtotal < 500) {
                    descuento = subtotal * 0.05;
                } else if (subtotal < 1000) {
                    descuento = subtotal * 0.08;
                } else {
                    descuento = subtotal * 0.10;
                }

                // operacion. Calcula el monto con descuento
                montoDescuento = subtotal - descuento;

                // operacion. Calcula el IVA
                iva = montoDescuento * 0.12;

                // operacion. Calcula el total
                total = montoDescuento + iva;

                // muestro los calculos de la venta
                System.out.println("===== CALCULO DE LA VENTA =====");
                System.out.println("Subtotal: Q" + subtotal);
                System.out.println("Descuento: Q" + descuento);
                System.out.println("Monto con descuento: Q" + montoDescuento);
                System.out.println("IVA: Q" + iva);
                System.out.println("Total a pagar: Q" + total);

                // seleccion de la forma de pago
                System.out.println("===== FORMA DE PAGO =====");
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta");
                System.out.println("3. Transferencia");
                System.out.println("Ingrese la forma de pago:");
                opcionPago = teclado.nextInt();

                // validacion de la forma de pago
                while (opcionPago < 1 || opcionPago > 3) {
                    System.out.println("Opcion incorrecta.");
                    System.out.println("Ingrese una opcion del 1 al 3:");
                    opcionPago = teclado.nextInt();
                }

                // seleccion de la forma de pago mediante switch
                switch (opcionPago) {

                    case 1:

                        formaPago = "Efectivo";

                        // ingreso del efectivo recibido
                        System.out.println("Ingrese el efectivo recibido:");
                        efectivo = teclado.nextDouble();

                        // validacion del efectivo
                        while (efectivo < total) {
                            System.out.println("Efectivo insuficiente.");
                            System.out.println("Ingrese nuevamente el efectivo:");
                            efectivo = teclado.nextDouble();
                        }

                        // operacion. Calcula el cambio
                        cambio = efectivo - total;

                        // contador de ventas en efectivo
                        ventasEfectivo++;

                        break;

                    case 2:

                        formaPago = "Tarjeta";

                        // contador de ventas con tarjeta
                        ventasTarjeta++;

                        break;

                    default:

                        formaPago = "Transferencia";

                        // contador de ventas por transferencia
                        ventasTransferencia++;

                        break;
                }

                // acumulacion de ventas realizadas
                ventasRealizadas++;

                // acumulacion del dinero vendido
                totalVendido = totalVendido + total;

                // calculo de la venta mayor y menor
                if (primeraVenta == 0) {
                    ventaMayor = total;
                    ventaMenor = total;
                    primeraVenta = 1;
                } else {
                    if (total > ventaMayor) {
                        ventaMayor = total;
                    }

                    if (total < ventaMenor) {
                        ventaMenor = total;
                    }
                }

                // muestro el resumen de la venta
                System.out.println("===== RESUMEN DE LA VENTA =====");
                System.out.println("Cantidad de productos: " + cantidadProductos);
                System.out.println("Subtotal: Q" + subtotal);
                System.out.println("Descuento: Q" + descuento);
                System.out.println("IVA: Q" + iva);
                System.out.println("Total a pagar: Q" + total);
                System.out.println("Forma de pago: " + formaPago);

                if (opcionPago == 1) {
                    System.out.println("Efectivo recibido: Q" + efectivo);
                    System.out.println("Cambio: Q" + cambio);
                }

                System.out.println("Venta registrada correctamente.");

                break;

            case 2:

                // consultar caja
                System.out.println("===== CONSULTA DE CAJA =====");
                System.out.println("Ventas realizadas: " + ventasRealizadas);
                System.out.println("Productos vendidos: " + productosVendidos);
                System.out.println("Total vendido: Q" + totalVendido);
                System.out.println("Ventas en efectivo: " + ventasEfectivo);
                System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                System.out.println("Ventas por transferencia: " + ventasTransferencia);

                break;

            case 3:

                // mostrar estadisticas

                if (ventasRealizadas == 0) {

                    System.out.println("No existen ventas registradas.");

                } else {

                    // operacion. Calcula el promedio por venta
                    promedio = totalVendido / ventasRealizadas;

                    // muestro resultado
                    System.out.println("===== ESTADISTICAS =====");
                    System.out.println("Numero total de ventas: " + ventasRealizadas);
                    System.out.println("Cantidad total de productos vendidos: " + productosVendidos);
                    System.out.println("Total de dinero vendido: Q" + totalVendido);
                    System.out.println("Promedio por venta: Q" + promedio);
                    System.out.println("Ventas en efectivo: " + ventasEfectivo);
                    System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                    System.out.println("Ventas por transferencia: " + ventasTransferencia);
                    System.out.println("Venta de mayor valor: Q" + ventaMayor);
                    System.out.println("Venta de menor valor: Q" + ventaMenor);
                }

                break;

            case 4:

                // salir del sistema
                System.out.println("Saliendo del sistema de ventas.");

                break;
        }

    } while (opcion != 4);
        
       }
    
}

