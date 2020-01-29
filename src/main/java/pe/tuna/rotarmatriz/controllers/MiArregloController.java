package pe.tuna.rotarmatriz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tuna.rotarmatriz.models.entity.MiArreglo;
import pe.tuna.rotarmatriz.service.IMiArregloService;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class MiArregloController {

    @Autowired
    private IMiArregloService miArregloService;

    @PostMapping("/arrays")
    public ResponseEntity<?> create(@RequestBody MiArreglo arreglo) {

        List<List<Integer>> mainArray = new ArrayList<List<Integer>>();
        Map<String, Object> response = new HashMap<>();
        MiArreglo arregloNew = null;

        try{
            List<List<Integer>> arrayNxN = arreglo.getArregloEnteros();
            /**
             * sizeMainArray: tamanio array principal
             * error: false= cumple NxN, true= no cumple NxN
             */
            int sizeMainArray = arrayNxN.size();
            boolean error = false;

            // Validacion
            for (int i = 0; i < arrayNxN.size(); i++) {
                int sizeSubArray = arrayNxN.get(i).size();
                // Comparamos si tienen el mismo tamanio
                if (sizeMainArray != sizeSubArray) {
                    error = true;
                }
            }
            if (error) { // No cumple condicion NxN, encontro tamanios diferentes
                //return new MiArreglo(0L, "Verifique los datos del arreglo");
                response.put("mensaje", "error no cumple condicion NxN");
                response.put("error", "Error NxN");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
            } else { // Cumple condicion NxN
                for (int j = arrayNxN.size() - 1; j >= 0; j--) {
                    List<Integer> contieneItems = new ArrayList<Integer>();
                    for (int i = 0; i < arrayNxN.size(); i++) {
                        contieneItems.add(arrayNxN.get(i).get(j));
                    }
                    mainArray.add(contieneItems);
                }

                try{
                    arreglo.setImagen(mainArray.toString());
                    arregloNew = miArregloService.save(arreglo);
                }catch (DataAccessException e){
                    response.put("mensaje", "error al crear array inverso en la base de datos");
                    response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

                response.put("mensaje", "Imagen creado con exito");
                response.put("cliente", arregloNew);

                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

            }

        }catch (Exception ex){
            response.put("mensaje", "Error en array en la base de datos");
            response.put("error", ex.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/arrays")
    public List<MiArreglo> listar() {
        return miArregloService.findAll();
    }
}
