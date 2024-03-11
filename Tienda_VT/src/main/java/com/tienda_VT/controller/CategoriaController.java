package com.tienda_VT.controller;
import com.tienda_VT.domain.Categoria;
import com.tienda_VT.service.CategoriaService;
import com.tienda_VT.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = categoriaService.getCategorias(false);

        model.addAttribute("categorias", lista);
        model.addAttribute("total categorias ", lista.size());
        return "/categoria/listado";
    }

    

    @PostMapping("/guardar")
    public String guardar(Categoria categoria,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            firebaseStorageService.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria());
        }
        categoriaService.save(categoria);

        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String modifica(Categoria categoria,
            Model model) {
        categoria=categoriaService.getCategoria(categoria);
        model.addAttribute("categoria",categoria);
        return"categoria/modifica";
    }
    @GetMapping("/eliminar/{idCategoria}")
    public String elimina(Categoria categoria) {
        categoriaService.delete(categoria);
        
        return"redirect:/categoria/listado";
    }
}
