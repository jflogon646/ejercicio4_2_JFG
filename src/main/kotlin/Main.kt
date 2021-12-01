/**
 * Clase ejecutable
 */
fun main() {
    //Objetos Ciudad
    var ciudad1: Ciudad = Ciudad("Madrid")
    var ciudad2: Ciudad = Ciudad("Cádiz")
    var ciudad3: Ciudad = Ciudad("Barcelona")
    var ciudad4: Ciudad = Ciudad("Toledo")
    var ciudad5: Ciudad = Ciudad("Sevilla")
    var ciudad6: Ciudad = Ciudad("Granada")


    //Objetos Producto
    var producto1: Producto = Producto("Disco duro SSD Kingston 240GB",24.99)
    var producto2: Producto = Producto("Memoria RAM Corsair 16GB(2x8GB)",81.40)
    var producto3: Producto = Producto("MSI Modern 14 i5",698.99)
    var producto4: Producto = Producto("Memoria USB 64GB",5.60)
    var producto5: Producto = Producto("Acer Spin 3",899.90)
    var producto6: Producto = Producto("Lenovo Ideapad Gaming 3",749.50)
    var producto7: Producto = Producto("Acer Aspire 3", 559.50)
    var producto8: Producto = Producto("Medion Akoya",499.90)
    var producto9: Producto = Producto("MSI Pulse GL76",1499.90)
    var producto10: Producto = Producto("Gigabyte G5",999.95)
    var producto11: Producto = Producto("MSI Katana GF66",1049.50)
    var producto12: Producto = Producto("Asus Rog Strix G15",2099.90)

    //Objetos Pedido
    var pedido1: Pedido = Pedido(listOf(producto1,producto4,producto4),true)
    var pedido2: Pedido = Pedido(listOf(producto3,producto6,producto11),true)
    var pedido3: Pedido = Pedido(listOf(producto12,producto4,producto4,producto11),false)
    var pedido4: Pedido = Pedido(listOf(producto11,producto1,producto5),true)
    var pedido5: Pedido = Pedido(listOf(producto8,producto6,producto8),true)
    var pedido6: Pedido = Pedido(listOf(producto3,producto3,producto11),false)
    var pedido7: Pedido = Pedido(listOf(producto1,producto8,producto4),true)
    var pedido8: Pedido = Pedido(listOf(producto6,producto5,producto7),true)
    var pedido9: Pedido = Pedido(listOf(producto11,producto6,producto7),true)
    var pedido10: Pedido = Pedido(listOf(producto10,producto1,producto3),false)
    var pedido11: Pedido = Pedido(listOf(producto7,producto8),true)
    var pedido12: Pedido = Pedido(listOf(producto5,producto10,producto2),true)
    var pedido13: Pedido = Pedido(listOf(producto3,producto11,producto4),true)
    var pedido14: Pedido = Pedido(listOf(producto1,producto7,producto5),false)
    var pedido15: Pedido = Pedido(listOf(producto2,producto4,producto8),true)


    //Objetos Cliente
    var cliente1: Cliente = Cliente("Antonio Fernández",ciudad1, listOf(pedido2,pedido3,pedido10))
    var cliente2: Cliente = Cliente("Jesús Gutiérrez",ciudad3,listOf(pedido1))
    var cliente3: Cliente = Cliente("Alejandro Benítez",ciudad2,listOf(pedido14))
    var cliente4: Cliente = Cliente("Dorian Leal",ciudad4,listOf(pedido15,pedido5,pedido6,pedido4))
    var cliente5: Cliente = Cliente("Paolo Galindo",ciudad4,listOf(pedido12,pedido7))
    var cliente6: Cliente = Cliente("Manuel Revuelta",ciudad3,listOf(pedido8))
    var cliente7: Cliente = Cliente("Agustín González",ciudad5,listOf(pedido9,pedido11))
    var cliente8: Cliente = Cliente("Cristóbal Tamayo",ciudad6,listOf(pedido13))

    //Objeto Tienda
    val tienda: Tienda = Tienda("Pccomponentes", listOf(cliente1,cliente2,cliente3,cliente4,cliente5,cliente6,cliente7,cliente8))


    
    //4.3.1
    println("*".repeat(15) + " Apartado 4.3.1 " + "*".repeat(15))
    println(tienda.obtenerConjuntoDeClientes())

    //4.3.2
    println("*".repeat(15) + " Apartado 4.3.2 " + "*".repeat(15))
    println(tienda.obtenerCiudadesDeClientes())
    println(tienda.obtenerClientesPorCiudad(ciudad4))

    //4.3.3
    println("*".repeat(15) + " Apartado 4.3.3 " + "*".repeat(15))
    println(tienda.checkTodosClientesSonDe(ciudad4))
    println(tienda.hayClientesDe(ciudad4))
    println(tienda.cuentaClientesDe(ciudad4))
    println(tienda.encuentraClienteDe(ciudad4))

    //4.3.4
    println("*".repeat(15) + " Apartado 4.3.4 " + "*".repeat(15))
    println(tienda.obtenerClientesOrdenadosPorPedidos())

    //4.3.5
    println("*".repeat(15) + " Apartado 4.3.5 " + "*".repeat(15))
    println(tienda.obtenerClientesConPedidosSinEntregar())

    //4.3.6
    println("*".repeat(15) + " Apartado 4.3.6 " + "*".repeat(15))
    println(tienda.obtenerProductosPedidos())
    println(cliente4.obtenerProductosPedidos())

    //4.3.7
    println("*".repeat(15) + " Apartado 4.3.7 " + "*".repeat(15))
    println(tienda.obtenerProductosPedidosPorTodos())

    //4.3.8
    println("*".repeat(15) + " Apartado 4.3.8 " + "*".repeat(15))
    println(cliente1.encuentraProductoMasCaro())
    println(tienda.obtenerNumeroVecesProductoPedido(producto4))

    //4.3.9
    println("*".repeat(15) + " Apartado 4.3.9 " + "*".repeat(15))
    println(tienda.agrupaClientesPorCiudad())

    //4.3.10
    println("*".repeat(15) + " Apartado 4.3.10 " + "*".repeat(15))
    println()
    println()
    println()

    //4.3.11
    println("*".repeat(15) + " Apartado 4.3.11 " + "*".repeat(15))
    println(tienda.obtenerClientesConMasPedidos())
    println(cliente1.obtenerProductoMasCaroPedido())

    //4.3.12
    println("*".repeat(15) + " Apartado 4.3.12 " + "*".repeat(15))
    println(cliente4.dineroGastado())
}