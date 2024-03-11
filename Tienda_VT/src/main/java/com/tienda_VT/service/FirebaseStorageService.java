
package com.tienda_VT.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-vt-55a87.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "Techshop-VT";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "Firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-vt-55a87-firebase-adminsdk-x8if0-4f8fdc9ce6.json";
}

