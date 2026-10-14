package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tech.pedido.Pedido;
import com.tech.productos.Producto;

public class PedidoTest {

    private Pedido pedido;
    private Producto producto;
    @BeforeEach
    void setup() {
        this.pedido = new Pedido("PDO-001", "Carlos");
        this.producto = new Producto("PRD-001", "Azucar", 15.2);   
        pedido.agregarProducto(producto);
    }

    @Test
    public void testActualizarNombre() {
        assertTrue(true);
    }

    @Test
    public void testCrearPedido() {
        assertNotNull(this.pedido);
    }
    @Test 
    public  void testAgregarProducto(){
        Producto producto2= new Producto("PRD-002", "Cafe instantaneo", 22.4);
        pedido.agregarProducto(producto2);
        assertEquals(2, pedido.getProductos().size());    }

    @Test 
    public void testEliminarProductoPorNombre(){
        pedido.eliminarProductoPorNombre("Azucar");
        assertEquals(0, pedido.getProductos().size());

    }
}