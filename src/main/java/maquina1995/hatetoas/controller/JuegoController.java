package maquina1995.hatetoas.controller;

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
public class JuegoController extends AbstractWebserviceLv3Controller<JuegoService, Juego, Long, JuegoDto> {

}
