package funciones;

import java.time.LocalDate;

public class Funciones {

	public static String traerFechaCorta(LocalDate fechaDeNacimiento) {

		return fechaDeNacimiento.getDayOfMonth() + "-" + fechaDeNacimiento.getMonthValue() + "-"
				+ fechaDeNacimiento.getYear();
	}

}
