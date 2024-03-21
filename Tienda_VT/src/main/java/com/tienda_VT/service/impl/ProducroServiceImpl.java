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
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {  // si se desea solo las productos activas
            lista.removeIf(c -> !c.isActivo());

        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    // Se define una consulta ampliada JPA para obtener la la lista de productos 
    //Que se encuentran en un rango de precios 
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPA(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByPrecio(precioInf, precioSup);
    }

    // Se define una consulta ampliada JPQL para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }

    // Se define una consulta ampliada SQL navita  para obtener la la lista de productos 
    //Que se encuentran en un rango de precios
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }

    @Override
    public List<Producto> consultaPorNombre(String nombre) {
        
       return productoDao.findByDescripcionContains(nombre);
    }

    @Override
    public List<Producto> consultaPorId(Long id) {
        return  productoDao.consultaPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaPorPrecio(double precioInf) {
        return productoDao.consultaPorPrecio(precioInf);
    }

    
}
