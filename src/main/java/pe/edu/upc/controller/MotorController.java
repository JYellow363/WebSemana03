package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Motor;
import pe.edu.upc.service.IMotorService;

@Named
@RequestScoped
public class MotorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMotorService mService;
	private Motor motor;
	List<Motor> listaMotores;
	
	@PostConstruct
	public void init() {
		this.listaMotores = new ArrayList<Motor>();
		this.motor = new Motor();
		this.listar();
	}
	
	public String nuevoMotor() {
		this.setMotor(new Motor());
		return "motor.xhtml";
	}
	
	public void insertar() {
		try {
			mService.insertar(motor);
			limpiarMotor();
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaMotores = mService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarMotor() {
		this.init();
	}
	
	public void eliminar(Motor mo) {
		try {
			mService.eliminar(mo.getIdMotor());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public List<Motor> getListaMotores() {
		return listaMotores;
	}

	public void setListaMotores(List<Motor> listaMotores) {
		this.listaMotores = listaMotores;
	}
	
	
	

}
