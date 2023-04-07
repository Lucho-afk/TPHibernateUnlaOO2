package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) {
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) {
		Cliente c = dao.traer(idCliente);
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}
}