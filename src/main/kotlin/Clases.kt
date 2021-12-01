/**
 * Clase Pedido
 */
data class Pedido(val productos: List<Producto>, val estaEntregado: Boolean) {}


/**
 * Clase Producto
 */
data class Producto(val nombre: String, val precio: Double) {
    override fun toString() = "'$nombre' for $precio"
}


/**
 * Clase Ciudad
 */
data class Ciudad(val nombre: String) {
    override fun toString() = nombre
}


/**
 * Clase Tienda
 */

data class Tienda(val nombre: String, val clientes: List<Cliente>) {
    //4.2.1
    fun obtenerConjuntoDeClientes(): Set<Cliente> {
        return clientes.toSet()
    }


    //4.3.2
    fun obtenerCiudadesDeClientes(): Set<Ciudad> {
        var ciudades: MutableList<Ciudad> = mutableListOf(Ciudad(""))
        for (cliente in clientes) {
            ciudades.add(cliente.ciudad)
        }
        ciudades.removeFirst()
        return ciudades.toSet()
    }

    fun obtenerClientesPorCiudad(ciudad: Ciudad): List<Cliente> {
        return clientes.filter { it -> it.ciudad == ciudad }
    }


    //4.3.3
    fun checkTodosClientesSonDe(ciudad: Ciudad): Boolean {
        return (clientes.all { it -> it.ciudad == ciudad })
    }

    fun hayClientesDe(ciudad: Ciudad): Boolean {
        return (clientes.any { it -> it.ciudad == ciudad })
    }

    fun cuentaClientesDe(ciudad: Ciudad): Int {
        return clientes.filter { it -> it.ciudad == ciudad }.size
    }

    fun encuentraClienteDe(ciudad: Ciudad): Cliente {
        return clientes[clientes.indexOfFirst { it -> it.ciudad == ciudad }]
    }


    //4.3.4
    fun obtenerClientesOrdenadosPorPedidos(): List<Cliente> {
        return clientes.sortedByDescending { it -> it.pedidos.size }
    }


    //4.3.5
    fun obtenerClientesConPedidosSinEntregar(): Set<Cliente> {
        return clientes.filter { it ->
            it.pedidos.any { !it.estaEntregado }
        }.toSet()
    }


    //4.3.6
    fun obtenerProductosPedidos(): Set<Producto> {
        val lista: MutableList<Producto> = mutableListOf<Producto>(Producto("",0.0))
        for (cliente in clientes) {
            cliente.pedidos.forEach { it -> it.productos.forEach { it -> lista.add(it) } }
        }
        lista.removeFirst()
        return lista.toSet()
    }


    //4.3.7
    fun obtenerProductosPedidosPorTodos(): Set<Producto> {
        val lista: MutableList<Producto> = mutableListOf<Producto>(Producto("",0.0))
        for (cliente in clientes) {
            cliente.pedidos.forEach { it -> it.productos.forEach { it -> lista.add(it) } }
        }
        lista.removeFirst()
        return lista.toSet()
    }

    //4.3.8
    fun obtenerNumeroVecesProductoPedido(producto: Producto): Int {
        var productoMasPedido: Producto
        var contador = 0
        for (cliente in clientes) {
            contador += cliente.obtenerProductosPedidos().filter { it -> it.nombre == producto.nombre }.size
        }
        return contador
    }

    //4.3.9
    fun agrupaClientesPorCiudad(): MutableMap<Ciudad, List<Cliente>> {
        // Inicialización del map
        var mapa: MutableMap<Ciudad,List<Cliente>> = mutableMapOf(Ciudad("") to listOf<Cliente>(Cliente("",Ciudad(""),
            listOf(Pedido(listOf(Producto("",0.0)),true)))))

        var lista: List<Cliente>
        for (ciudad in obtenerCiudadesDeClientes()) {
            mapa[ciudad] = obtenerClientesPorCiudad(ciudad)
        }
        mapa.remove(Ciudad(""))
        return mapa
    }


    //4.3.10
    fun mapeaNombreACLiente() {} // map<String, Cliente>
    fun mapeaClienteACiudad() {} // map<Cliente, Ciudad>
    fun mapeaNombreClienteACiudad() {} // map<String, Ciudad>


    //4.3.11
    fun obtenerClientesConMasPedidos(): Cliente? {
        return clientes.maxByOrNull { it -> it.pedidos.size }
    }

}


/**
 * Clase Cliente
 */
data class Cliente(val nombre: String, val ciudad: Ciudad, val pedidos: List<Pedido>) {
    override fun toString() = "$nombre from ${ciudad.nombre}"


    //4.3.6
    fun obtenerProductosPedidos(): List<Producto> {
        val lista: MutableList<Producto> = mutableListOf<Producto>(Producto("",0.0))
        pedidos.forEach { it -> it.productos.forEach { it -> lista.add(it) } }
        lista.removeFirst()
        return lista

    }


    //4.3.8
    fun encuentraProductoMasCaro(): Producto? {
        val lista: MutableList<Producto> = mutableListOf(Producto("",0.0))
        for (pedido in pedidos) {
            if (pedido.estaEntregado) {
                lista.add(pedido.productos.maxByOrNull { it -> it.precio }!!)
            }
        }
        return lista.maxByOrNull { it -> it.precio }
    }


    //4.3.11
    fun obtenerProductoMasCaroPedido(): Producto? {
        return obtenerProductosPedidos().maxByOrNull { it -> it.precio }
    }
    //4.3.12
    fun dineroGastado(): Double {
        var contador = 0.0
        obtenerProductosPedidos().forEach { it -> contador += it.precio }
        return contador
    }

}
