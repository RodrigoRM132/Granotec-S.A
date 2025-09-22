package upn.pe.inventario_back.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import upn.pe.inventario_back.models.Linea;
import upn.pe.inventario_back.models.dto.LineaRequest;
import upn.pe.inventario_back.models.dto.LineaResponse;
import upn.pe.inventario_back.repositories.LineaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineaService {

    private final LineaRepository lineaRepository;

    public List<LineaResponse> listarLineas() {
        return lineaRepository.findAll().stream()
                .map(this::mapToLineaResponse)
                .toList();
    }

    public void create(LineaRequest lineaRequest) {
        Linea nuevaLinea = Linea.builder()
                .nombre(lineaRequest.nombre())
                .build();
        lineaRepository.save(nuevaLinea);
    }

    private LineaResponse mapToLineaResponse(Linea linea) {
        return LineaResponse.builder()
                .id(linea.getId())
                .nombre(linea.getNombre())
                .build();
    }
}
