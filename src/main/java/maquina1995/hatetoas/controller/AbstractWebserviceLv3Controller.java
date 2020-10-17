package maquina1995.hatetoas.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import maquina1995.hatetoas.domain.Persistible;
import maquina1995.hatetoas.dto.AbstractHatetoasDto;
import maquina1995.hatetoas.service.AbstractGenericService;

/**
 * Clase abstracta para la creación de webservices de nivel 2
 * 
 * @author MaQuiNa1995
 *
 * @param <S> service
 * @param <T> entity
 * @param <K> clave primaria de la entity
 * @param <D> dto
 */
public abstract class AbstractWebserviceLv3Controller<S extends AbstractGenericService<T, K, D>,
        T extends Persistible<K>,
        K extends Serializable,
        D extends AbstractHatetoasDto<K>> {

	@Autowired
	protected S service;

	@PostMapping
	public ResponseEntity<T> create(@RequestBody D dto) {
		return ResponseEntity.ok(service.create(dto));
	}

	@GetMapping({ "/", "/{id}" })
	public ResponseEntity<List<D>> find(@RequestParam(required = false) K id) {
		List<D> dtos = id == null ? service.findAll() : Arrays.asList(service.find(id));

		dtos.forEach(dto -> {
			Link link = WebMvcLinkBuilder.linkTo(this.getClass())
			        .slash(dto.getId())
			        .withSelfRel();

			dto.add(link);
		});

		return ResponseEntity.ok(dtos);
	}

	@PutMapping
	public ResponseEntity<T> update(@RequestBody D dto) {
		return ResponseEntity.ok(service.update(dto));
	}

	@DeleteMapping
	public ResponseEntity<K> delete(@RequestParam K id) {
		service.delete(id);
		return ResponseEntity.ok(id);
	}

}
