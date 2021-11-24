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
    fun obtenerConjuntoDeClientes() {

    }
    //4.2.2
    fun obtenerCiudadesDeClientes() {} //set<ciudad>
    fun obtenerClientesPorCiudad(ciudad: Ciudad) {} //list<cliente>
    //4.2.3
    fun checkTodosClientesSonDe(ciudad: Ciudad) {} //Boolean
    fun hayClientesDe(ciudad: Ciudad) {} //Boolean
    fun cuentaClientesDe(ciudad: Ciudad) {} //Int
    fun encuentraClienteDe(ciudad: Ciudad) {} //Cliente?
    //4.2.4
    fun obtenerClientesOrdenadosPorPedidos() {} //List<Cliente>
    //4.2.5
    fun obtenerClientesConPedidosSinEntregar() {} //set<cliente>
    //4.2.6
    fun obtenerProductosPedidos() {} //Set<Producto>
    //4.2.7
    fun obtenerProductosPedidosPorTodos() {} //set<producto>
    //4.2.8
    fun obtenerNumeroVecesProductoPedido(producto: Producto) {} //producto?
    //4.2.9
    fun agrupaClientesPorCiudad() {} //map<ciudad,list<cliente>>
    //4.2.10
    fun mapeaNombreACLiente() {} // map<String, Cliente>
    fun mapeaClienteACiudad() {} // map<Cliente, Ciudad>
    fun mapeaNombreClienteACiudad() {} // map<String, Ciudad>
    //4.2.11
    fun obtenerClientesConMasPedidos() {} //Cliente?


    /*
    Funciones auxiliares privadas
     */

}


/**
 * Clase Cliente
 */
data class Cliente(val nombre: String, val ciudad: Ciudad, val pedidos: List<Pedido>) {
    override fun toString() = "$nombre from ${ciudad.nombre}"
    //4.2.6
    fun obtenerProductosPedidos() {} //list<producto>
    //4.2.8
    fun encuentraProductoMasCaro() {} // Producto?
    //4.2.11
    fun obtenerProductoMasCaroPedido() {} //Producto?
    //4.2.12
    fun dineroGastado() {} // Double

}
