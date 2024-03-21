
package com.tienda_VT.dao;


import com.tienda_VT.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository <Producto,Long> {
    // Se define una consulta ampliada JPA para obtener la la lista de productos 
    //Que se encuentran en un rango de precios 
    public List<Producto> findByPrecioBetweenOrderByPrecio(double precioInf, double precioSup);
    
    // Consulta ampliada JPA para obtener la lista de productos por nombre
    public List<Producto> findByDescripcionContains(String nombre);
    
    // Consulta ampliada JPQL para obtener la lista de productos por id
    @Query("SELECT p FROM Producto p WHERE p.idProducto = :id")
    public List<Producto> consultaPorId(Long id);
    
    // Consulta ampliada SQL nativa para obtener la lista de productos por precio
    @Query(nativeQuery = true, 
           value = "SELECT * FROM producto WHERE precio > 0 AND precio <= :precio")
    public List<Producto> consultaPorPrecio(double precio);
    
    // Se define una consulta ampliada JPQL para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    @Query(value="SELECT p "
            + " FROM Producto p"
            + " WHERE p.precio"
            + " BETWEEN :precioInf and :precioSup"
            + " ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    // Se define una consulta ampliada SQL navita  para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    @Query(nativeQuery=true,
            value="SELECT * "
            + " FROM producto p"
            + " WHERE p.precio"
            + " BETWEEN :precioInf and :precioSup"
            + " ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(double precioInf, double precioSup);
    
}
