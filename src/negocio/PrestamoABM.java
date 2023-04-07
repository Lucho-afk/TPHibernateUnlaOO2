package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	private CuotaABM cuotaAbm = new CuotaABM();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
//Implementar: si el no existe el prestamo lanzar la excepción

		Prestamo p = dao.traer(idPrestamo);
		if (p == null) {
			throw new Exception("No existe prestamo");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}

	public int Alta(Prestamo prestamo) {
		return dao.agregar(prestamo);
	}

	public void Modificar(Prestamo prestamo) {
		dao.actualizar(prestamo);
	}

	public void eliminar(Prestamo prestamo) {
		dao.eliminar(prestamo);
	}

	public Prestamo traerPrestamoYcuotas(long id) {
		return dao.traerPrestamoYcuotas(id);
	}

	// hay que cambiar esta funcion pero no enteindo el codigo de amortizacion.
	public int altaPrestamoConCuotas(Prestamo prestamo) throws Exception {
		long idPrestamoGenerado = this.Alta(prestamo);
		Prestamo p = this.traerPrestamo(idPrestamoGenerado);
		double interes = prestamo.getInteres();
		double monto = prestamo.getMonto();
		double saldoPendiente = monto;
		LocalDate fecha = prestamo.getFecha();
		int cantidadDeCuotas = prestamo.getCantCuotas();
		int n = cantidadDeCuotas;//
		for (int i = 0; i < cantidadDeCuotas; i++) {
			fecha = fecha.plusMonths(i);
			double amortizacion = (saldoPendiente) / Math.pow(1 + interes, n - i) - 1;
			cuotaAbm.agregar(i + 1, fecha, saldoPendiente, amortizacion, saldoPendiente * interes,
					amortizacion + saldoPendiente * interes, saldoPendiente - amortizacion, false, null, 0, p);
			saldoPendiente = saldoPendiente - amortizacion;
		}
		return (int) idPrestamoGenerado;

	}

	/*
	 * Pendiente implementar Alta, Modificar
	 */
}
