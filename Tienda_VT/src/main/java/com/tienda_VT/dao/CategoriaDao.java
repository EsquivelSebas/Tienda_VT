
package com.tienda_VT.dao;


import com.tienda_VT.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao 
          extends JpaRepository<Categoria,Long>{
    
}
