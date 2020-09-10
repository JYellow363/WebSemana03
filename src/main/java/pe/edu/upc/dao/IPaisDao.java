package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Pais;

public interface IPaisDao {
	public void insertar(Pais pais);
	public List<Pais> listar();
	public void eliminar(int idPais);
}
