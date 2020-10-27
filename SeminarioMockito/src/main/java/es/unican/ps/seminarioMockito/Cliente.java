package es.unican.ps.seminarioMockito;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private List<Seguro> seguros = new LinkedList<Seguro>();
	private boolean minusvalia;
	private static final double REDUCCION_MINUSVALIA = 0.75;
	
	public Cliente(boolean minusvalia) {
		this.minusvalia = minusvalia;
	}
	
	public boolean isMinusvalia() {
		return minusvalia;
	}

	public void setMinusvalia(boolean minusvalia) {
		this.minusvalia = minusvalia;
	}

	public boolean addSeguro(Seguro s) {
		seguros.add(s);
		return true;
	}
	
	public double getTotal() {
		double total = 0.0;
		for (Seguro s:seguros)
			total+=s.getPrecio();
		if (minusvalia)
			return total*REDUCCION_MINUSVALIA;
		return total;
	}
	
	public List<Seguro> getSeguros() {
		return seguros;
	}

}
