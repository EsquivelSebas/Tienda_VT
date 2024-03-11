package com.tienda_VT.service;
import com.tienda_VT.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    // se define la firma del metodo que rescupera la lista 
    //de objetos tipo Categoria que son los registro de 
    //la tabla Categoria 
    public List<Categoria> getCategorias(boolean activos);
    // se define la firma del metodo para recuperar un registro 
    //la tabla categoria , recuperando el registro que tiene el 
    //idCategoria , si no lo encuentra retorna el null
    
    public Categoria getCategoria(Categoria categoria);
    
    // se define la firma del metodo para recuperar un registro 
    //la tabla categoria , recuperando el registro que tiene el 
    //idCategoria , si no lo encuentra retorna el null
    
    public void  save  (Categoria categoria);
    
    //se define la firma del metodo para eliminar un registro 
    //la tabal categoria , considerado idCsategoria 
    public void  delete  (Categoria categoria);
}
