package pl.mzerek.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SAMOCHOD database table.
 * 
 */
@Embeddable
@NamedQuery(name="Samochod.findAll", query="SELECT s FROM Samochod s")
public class Samochod implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object cena;

	private BigDecimal kilometry;

	private String marka;

	private String miasto;

	public Samochod() {
	}

	public Object getCena() {
		return this.cena;
	}

	public void setCena(Object cena) {
		this.cena = cena;
	}

	public BigDecimal getKilometry() {
		return this.kilometry;
	}

	public void setKilometry(BigDecimal kilometry) {
		this.kilometry = kilometry;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getMiasto() {
		return this.miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

}