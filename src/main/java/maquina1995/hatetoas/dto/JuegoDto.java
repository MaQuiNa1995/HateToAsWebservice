package maquina1995.hatetoas.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class JuegoDto extends RepresentationModel<JuegoDto> implements PersistibleDto<Long> {

	@EqualsAndHashCode.Exclude
	private Long id;
	private String titulo;
	private String plataforma;
}
