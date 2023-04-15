package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
//Implementar: si el no existe el prestamo lanzar la excepción

		Prestamo p = dao.traerPrestamoYcuotas(idPrestamo);
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

	// Puede que la logica de la amortizacion este mal.
	public int altaPrestamoConCuotas(Prestamo prestamo) throws Exception {
		/*--------------------Doy de alta el nuevo prestamo y lo trago para guardarlo en una variable----------------*/
		long idPrestamoGenerado = this.Alta(prestamo);
		Prestamo p = this.traerPrestamo(idPrestamoGenerado);

		/*-------------------Creo variables que voy a necesitar para el calculo de amortizacion----------------------*/
		double interes = prestamo.getInteres();
		double monto = prestamo.getMonto();
		double saldoPendiente = monto;
		LocalDate fecha = prestamo.getFecha();
		int cantidadDeCuotas = prestamo.getCantCuotas();
		int n = cantidadDeCuotas;

		/*-------------------------IMPORTANTE: Creo un set que va a ser mi lista de cutoas----------------------------*/
		Set<Cuota> lstCuotas = new HashSet<Cuota>();

		/*---------Con este for lo que hago es e llenar ese set y para cada cuota le aplico la regla del negocio------*/
		for (int i = 0; i < cantidadDeCuotas; i++) {
			fecha = fecha.plusMonths(i);
			double amortizacion = (saldoPendiente) / Math.pow(1 + interes, n - i) - 1;
			lstCuotas.add(new Cuota(i + 1, fecha, saldoPendiente, amortizacion, saldoPendiente * interes,
					amortizacion + saldoPendiente * interes, saldoPendiente - amortizacion, false, null, 0, p));
			saldoPendiente = saldoPendiente - amortizacion;
		}

		/*------------Al prestamo que me traje de la bd le seteo el el set de cuotas y despues lo modifico-------------*/

		p.setCuotas(lstCuotas);
		this.Modificar(p);
		return (int) idPrestamoGenerado;
		// Como tengo activado la propiedad dentro de la tag CASCADE ="UPDATE-SAVE"
		// al darle persistencia al prestamo o en este caso hacerle un update va a
		// persistir las cuotas
	}

	/*
	 * Pendiente implementar Alta, Modificar
	 */
}
