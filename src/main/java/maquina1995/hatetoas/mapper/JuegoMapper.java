package maquina1995.hatetoas.mapper;

import org.mapstruct.Mapper;

import maquina1995.hatetoas.domain.Juego;
import maquina1995.hatetoas.dto.JuegoDto;

@Mapper(componentModel = "spring")
public interface JuegoMapper extends AbstractMapper<Juego, JuegoDto> {

}
