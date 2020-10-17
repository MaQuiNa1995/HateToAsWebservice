package maquina1995.hatetoas.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public abstract class AbstractHatetoasDto<K extends Serializable> extends RepresentationModel<AbstractHatetoasDto<K>> {

	public abstract K getId();

	public abstract void setId(K id);
}
