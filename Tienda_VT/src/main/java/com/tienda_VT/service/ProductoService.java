
package com.tienda_VT.service;

import com.tienda_VT.domain.Producto;
import java.util.List;


public interface ProductoService {
    
    /* Se define la firma del metodo que recupera la lista 
    de objetos tipo Producto que son los registros de la tabla producto */
    public List<Producto> getProductos(boolean activos);

    /* Se define  la firma del metodo para recuperar un registro de 
    la tabla producto, recuperando el registro que tiene el 
    idProducto, sino lo encuentra retorna null*/
    public Producto getProducto(Producto producto);

    /* Se define la firma del metodo para crear o actualizar un registro de 
    la tabla producto, Si el idProducto no tiene valor, se crea
    el registro, si tiene valor, entonces modifica ese registro */
    public void save(Producto producto);

    /* Se define la firma del metodo para eliminar un registro de 
    la tabla producto, considerando idProducto */
    public void delete(Producto producto);
    
      // Se define una consulta ampliada JPA para obtener la la lista de productos 
    //Que se encuentran en un rango de precios 
    public List<Producto> consultaJPA(double precioInf, double precioSup);
    
    // Se define una consulta ampliada JPQL para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    // Se define una consulta ampliada SQL navita  para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    public List<Producto> consultaSQL(double precioInf, double precioSup);
    
    
    
    //consultas de la tarea///////////////////////////////////////////////////
    public List<Producto> consultaPorNombre(String nombre);
    public List<Producto> consultaPorId(Long id);
    public List<Producto> consultaPorPrecio(double precioInf);
    
    
}
