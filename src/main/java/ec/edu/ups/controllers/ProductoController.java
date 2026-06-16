/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controllers; 

import ec.edu.ups.models.Producto;
import ec.edu.ups.views.BuscarProductoView;
import ec.edu.ups.views.CrearProductoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USUARIO
 */
public class ProductoController {
    private Producto producto;
    private CrearProductoView crearProductoView;


    public ProductoController(CrearProductoView crearProdcutoView) {
        this.crearProductoView = crearProdcutoView;
        configurarEventosCrearProducto();
    }
    
    public void crearProducto(){
        int codigo = Integer.parseInt(crearProductoView.getTxtCodigo().getText());
        String nombre = crearProductoView.getTxtNombre().getText();
        double precio = Double.parseDouble(crearProductoView.getTxtPrecio().getText());
        producto = new Producto(codigo, nombre, precio);
        System.out.println("Producto creado exitosamente");
    }
    
    public void configurarEventosCrearProducto(){
        crearProductoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                crearProducto();
            }
        });
    }
}
