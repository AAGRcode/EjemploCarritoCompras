/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controllers; 

import ec.edu.ups.carrito.dao.ProductoDAO;
import ec.edu.ups.carrito.dao.ProductoDAOMemoria;
import ec.edu.ups.models.Producto;
import ec.edu.ups.views.ActualizarProductoView;
import ec.edu.ups.views.BuscarProductoView;
import ec.edu.ups.views.CrearProductoView;
import ec.edu.ups.views.EliminarProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USUARIO
 */
public class ProductoController {
    private ProductoDAO productoDAO;
    private CrearProductoView crearProductoView;
    private BuscarProductoView buscarProductoView;
    private ActualizarProductoView actualizarProductoView;
    private EliminarProductoView eliminarProductoView;

    public ProductoController(ProductoDAO productoDAO, CrearProductoView crearProductoView, BuscarProductoView buscarProductoView, ActualizarProductoView actualizarProductoView, EliminarProductoView eliminarProductoView) {
        this.productoDAO = productoDAO;
        this.crearProductoView = crearProductoView;
        this.buscarProductoView = buscarProductoView;
        this.actualizarProductoView = actualizarProductoView;
        this.eliminarProductoView = eliminarProductoView;
        configurarEventosCrearProducto();
        configurarEventosBuscarProducto();
        configurarEventosEliminarProducto();
        configurarEventosActualizarProducto();
        configurarEventosBuscarEliminar();
        configurarEventosBuscarActualizar();
    }
    
    public void crearProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        
        Producto producto = new Producto(codigo, nombre, precio);
        productoDAO.crear(producto);
        crearProductoView.mostrarInformacion("Producto creado exitosamente");
    }
    
    public void configurarEventosCrearProducto(){
        crearProductoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                crearProducto();
            }
        });
    }
    
    public void buscarProducto(){
    int codigo = Integer.parseInt(buscarProductoView.getTxtCodigo().getText());
    Producto producto = productoDAO.buscar(codigo);

    if(producto != null){
        buscarProductoView.getTxtNombre().setText(producto.getNombre());
        buscarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
    }else {
        buscarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }

    public void configurarEventosBuscarProducto(){
    buscarProductoView.getBtnAceptar().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {            
            buscarProducto();
        }
    });
    }
    //
    public void buscarProductoActualizar(){
        int codigo = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscar(codigo);
        if(producto != null){
            actualizarProductoView.getTxtNombre().setText(producto.getNombre());
            actualizarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }else {
            actualizarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }

    public void configurarEventosBuscarActualizar(){
        actualizarProductoView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoActualizar();
            }
        });
    }

    public void actualizarProducto(){
        int codigo = Integer.parseInt(actualizarProductoView.getTxtCodigo().getText());
        String nombre = actualizarProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(actualizarProductoView.getTxtPrecio().getText());

        Producto producto = new Producto(codigo, nombre, precio);
        productoDAO.actualizar(codigo, producto);
        actualizarProductoView.mostrarInformacion("Producto actualizado exitosamente");
    }

    public void configurarEventosActualizarProducto(){
        actualizarProductoView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });
    }
    //
    public void buscarProductoEliminar(){
        int codigo = Integer.parseInt(eliminarProductoView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscar(codigo);
        if(producto != null){
            eliminarProductoView.getTxtNombre().setText(producto.getNombre());
            eliminarProductoView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }else {
            eliminarProductoView.mostrarInformacion("Producto no encontrado");
        }
    }

    public void configurarEventosBuscarEliminar(){
        eliminarProductoView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoEliminar();
            }
        });
    }

    public void eliminarProducto(){
        int codigo = Integer.parseInt(eliminarProductoView.getTxtCodigo().getText());
        productoDAO.eliminar(codigo);
        eliminarProductoView.mostrarInformacion("Producto eliminado exitosamente");
    }

    public void configurarEventosEliminarProducto(){
        eliminarProductoView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }
}
