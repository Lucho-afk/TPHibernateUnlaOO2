package datos;

import java.time.LocalDate;

public class Cuota {

	private long idCuota;
	private int nroCuota;
	private LocalDate fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private LocalDate fechaDePago;
	private double punitorios;
	private Prestamo prestamo;

	public Cuota() {
		super();
	}

	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		super();
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesCuota = interesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
		this.prestamo = prestamo;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public long getIdCuota() {
		return idCuota;
	}

	protected void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresCuota() {
		return interesCuota;
	}

	public void setInteresCuota(double interesCuota) {
		this.interesCuota = interesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	@Override
	public String toString() {
		return "\nnroCuota=" + nroCuota + "\nfechaVencimiento=" + fechaVencimiento + "\nsaldoPendiente="
				+ saldoPendiente + "\namortizacion=" + amortizacion + "\ninteresCuota=" + interesCuota + "\ncuota="
				+ cuota + "\ndeuda=" + deuda + "\ncancelada=" + cancelada + "\nfechaDePago=" + fechaDePago
				+ "\npunitorios=" + punitorios + "\n\n\n";
	}

}
