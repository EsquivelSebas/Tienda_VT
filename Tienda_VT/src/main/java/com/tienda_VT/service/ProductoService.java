
package com.tienda_VT.service;

import com.tienda_VT.domain.Producto;
import java.util.List;


public interface ProductoService {
    // se define la firma del metodo que rescupera la lista 
    //de objetos tipo Producto que son los registro de 
    //la tabla Producto 
    public List<Producto> getProductos(boolean activos);
    // se define la firma del metodo para recuperar un registro 
    //la tabla producto , recuperando el registro que tiene el 
    //idProducto , si no lo encuentra retorna el null
    
    public Producto getProducto(Producto producto);
    
    // se define la firma del metodo para recuperar un registro 
    //la tabla producto , recuperando el registro que tiene el 
    //idProducto , si no lo encuentra retorna el null
    
    public void  save  (Producto producto);
    
    //se define la firma del metodo para eliminar un registro 
    //la tabal producto , considerado idCsategoria 
    public void  delete  (Producto producto);
}
