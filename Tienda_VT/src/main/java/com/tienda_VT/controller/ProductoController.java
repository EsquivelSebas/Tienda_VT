package com.tienda_VT.controller;
import com.tienda_VT.domain.Producto;
import com.tienda_VT.service.FirebaseStorageService;
import com.tienda_VT.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);

        model.addAttribute("productos", lista);
        model.addAttribute("total productos ", lista.size());
        return "/producto/listado";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            firebaseStorageService.cargaImagen(imagenFile, "producto", producto.getIdProducto());
        }
        productoService.save(producto);

        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto,
            Model model) {
        producto=productoService.getProducto(producto);
        model.addAttribute("producto",producto);
        return"producto/modifica";
    }
    @GetMapping("/eliminar/{idProducto}")
    public String elimina(Producto producto) {
        productoService.delete(producto);
        
        return"redirect:/producto/listado";
    }
}
