package negocio;

import java.time.LocalDate;

import dao.CuotaDao;
import dao.PrestamoDao;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
	CuotaDao dao = new CuotaDao();
	PrestamoDao prestamoDao = new PrestamoDao();

	public int agregar(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		Cuota c = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda,
				cancelada, fechaDePago, punitorios, prestamo);
		return dao.agregar(c);
	}

	public void modificar(Cuota c) {
		dao.actualizar(c);
	}

	public Cuota traerXnroCuotaYPrestamo(int id, long idPrestamo) {
		return dao.traer(id, idPrestamo);
	}

//	En el caso de que un cliente venga a pagar una cuota se invocará al método traerCuota de
//	CuotaABM se se “setearán” los atributos: cancelada, fechaDePago, punitorios y por último modificarCuota
//	de CuotaABM.
	public String pagarCuota(long idPrestamo, int nroCuota, LocalDate fechaDePago, double punitorios) throws Exception {
		Cuota c = null;
		Prestamo p = prestamoDao.traerPrestamoYcuotas(idPrestamo);
		if (p == null) {
			throw new Exception("NO EXISTE ESTE CLIENTE");
		}
		for (Cuota cuota : p.getCuotas()) {
			if (cuota.getNroCuota() == nroCuota) {
				c = cuota;
			}
		}
		if (c == null) {
			throw new Exception("NO EXISTE ESTA CUOTA ASIOCIADA A ESTE CLIENTE");
		}
		c.setFechaDePago(fechaDePago);
		c.setPunitorios(punitorios);
		c.setCancelada(true);
		this.modificar(c);
		return "se registro el pago el dia: " + fechaDePago;
	}

}
