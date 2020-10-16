package maquina1995.hatetoas.domain;

import java.io.Serializable;

public interface Persistible<K extends Serializable> {

	K getId();

	void setId(K id);

}
