package ec.edu.ups.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AAGR
 */
public class Carrito {
    private List<ItemCarrito> items; 

    public Carrito() {
        items = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto, int cantidad){
        ItemCarrito item = new ItemCarrito(producto, cantidad);
        items.add(item);
    }
    
    public ItemCarrito buscarItemPorCodigo(int codigo){
        for(ItemCarrito item : items){
            if(item.getProducto().getCodigo() == codigo){
                return item;
            }
        }
        return null;
    }
    
    public void eliminarProducto(int codigoProducto){
        ItemCarrito item = buscarItemPorCodigo(codigoProducto);
        
        if(item != null){
            items.remove(item);
        }
    }
    
    public double calcularTotal(){
        double total=0.0;
        for(ItemCarrito item : items){
            total += item.calcularSubtotal();
        }
        return total;
    }
}
