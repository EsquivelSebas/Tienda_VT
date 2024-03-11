package com.tienda_VT.service.impl;



import com.tienda_VT.dao.ProductoDao;
import com.tienda_VT.domain.Producto;
import com.tienda_VT.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProducroServiceImpl
        implements ProductoService {

    @Autowired
    private ProductoDao productoDao;
   
    @Override
    public Producto getProducto(Producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    @Transactional
    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }
    @Transactional
    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    @Transactional(readOnly=true)
    @Override
    public List<Producto> getProductos(boolean activos) {
       var lista= productoDao.findAll();
        
        if (activos){  // si se desea solo las productos activas
            lista.removeIf(c ->  !c.isActivo());
            
        }
        
        return lista;
    }

}
