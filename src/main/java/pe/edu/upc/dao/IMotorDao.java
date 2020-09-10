package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Motor;

public interface IMotorDao {
	public void insertar(Motor motor);
	public List<Motor> listar();
	public void eliminar(int idMotor);
}
