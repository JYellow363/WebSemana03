package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Pais;

public interface IPaisService {
	public void insertar(Pais pais);
	public List<Pais> listar();
	public void eliminar(int idPais);
}
