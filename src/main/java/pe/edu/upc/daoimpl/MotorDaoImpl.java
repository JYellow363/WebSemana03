package pe.edu.upc.daoimpl;
import pe.edu.upc.dao.IMotorDao;
import pe.edu.upc.entity.Motor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class MotorDaoImpl implements IMotorDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="a")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Motor motor) {
		try {
			em.persist(motor);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Motor> listar() {
		List<Motor> lista = new ArrayList<Motor>();
		try {
			Query q = em.createQuery("select m from Motor m");
			lista = (List<Motor>)q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idMotor) {
		Motor mot = new Motor();
		try {
			mot = em.getReference(Motor.class, idMotor);
			em.remove(mot);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
