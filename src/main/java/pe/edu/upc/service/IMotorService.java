package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Motor;

public interface IMotorService {
	public void insertar(Motor motor);
	public List<Motor> listar();
	public void eliminar(int idMotor);
}
