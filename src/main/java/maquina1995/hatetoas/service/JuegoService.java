package maquina1995.hatetoas.service;

import org.springframework.stereotype.Service;

import maquina1995.hatetoas.domain.Juego;
import maquina1995.hatetoas.dto.JuegoDto;
import maquina1995.hatetoas.mapper.JuegoMapper;
import maquina1995.hatetoas.repository.JuegoRepository;

@Service
public class JuegoService extends AbstractGenericServiceImpl<Juego, Long, JuegoDto, JuegoRepository, JuegoMapper> {

}
