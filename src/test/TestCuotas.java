package test;

import datos.Prestamo;
import negocio.ClienteABM;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestCuotas {
	public static void main(String[] args) throws Exception {
		CuotaABM cuotaAbm = new CuotaABM();
		ClienteABM clienteABM = new ClienteABM();
		PrestamoABM prestamoAbm = new PrestamoABM();
		Prestamo p = prestamoAbm.traerPrestamo(1);
//		long ultimoIdCliente = cuotaAbm.agregar(1, LocalDate.now(), 45000.5, 12, 15.5, 1, 10000, false, LocalDate.now(),
//				123, p);

//		Prestamo pres = prestamoAbm.traerPrestamoYcuotas(1l);
//		System.out.println(pres);

//		Prestamo nuevoPrestamo = new Prestamo(LocalDate.now(), 100000, 1.15, 3, clienteABM.traer(1l));
//		int idNuevoPrestamo = prestamoAbm.altaPrestamoConCuotas(nuevoPrestamo);
//		cuotaAbm.pagarCuota(4l, 1, LocalDate.now(), 2);
		System.out.println(prestamoAbm.traerPrestamo(4));

	}

}
