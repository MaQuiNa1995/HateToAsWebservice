package maquina1995.hatetoas.mapper;

public interface AbstractMapper<T, D> {

	abstract D entityToDto(T entity);

	abstract T dtoToEntity(D dto);

}
