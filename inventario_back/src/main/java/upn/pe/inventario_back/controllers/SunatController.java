// src/main/java/com/tuempresa/tuapp/controller/SunatController.java
package upn.pe.inventario_back.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/sunat")
public class SunatController {

    @GetMapping("/{ruc}")
    public ResponseEntity<?> consultarRuc(@PathVariable String ruc) {
        String url = "https://api.apis.net.pe/v2/sunat/ruc?numero=" + ruc;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer $apis-token-11533.dQwdSyb6046QMR9tK5PTu8brPGLl8ynl"); // Ajusta el token de acceso

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al consultar la API de SUNAT", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
