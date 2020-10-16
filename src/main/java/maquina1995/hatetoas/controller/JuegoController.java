package maquina1995.hatetoas.controller;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import maquina1995.hatetoas.domain.Juego;
import maquina1995.hatetoas.dto.JuegoDto;
import maquina1995.hatetoas.service.JuegoService;

@RestController
@RequestMapping(path = "/juego")
@RequiredArgsConstructor
@Api(tags = "Ejemplo de webservice de Nivel 3 HATETOAS")
public class JuegoController extends AbstractWebserviceLv2Controller<JuegoService, Juego, Long, JuegoDto> {

	// TODO pasar a generico
	@Override
	public ResponseEntity<List<JuegoDto>> find(@PathVariable(required = false) Long id) {

		String linkRepresentation = "http://localhost:8080/juego/%s";

		Link link;

		List<JuegoDto> dtos = super.find(id).getBody();

		for (JuegoDto juegoDto : dtos) {
			link = Link.of(String.format(linkRepresentation, juegoDto.getId()));
			juegoDto.add(link);
		}

		return ResponseEntity.ok(dtos);
	}

}
