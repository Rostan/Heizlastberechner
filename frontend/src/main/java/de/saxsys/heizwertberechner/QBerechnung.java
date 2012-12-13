package de.saxsys.heizwertberechner;

/**
 * 
 * @author roman.stange
 * 
 */

public class QBerechnung {

	private static final double SPEZ_WAERMEKAP_LUFT = 1005; // J/(kg*K)
	private static final double DICHTE_LUFT = 1.292; // [ kg / m3 ]
	private double raumSollWert;
	private double nLuftWechselZahl;
	private double aussenTemperatur;

	public double getNluftWechselZahl() {

		return nLuftWechselZahl;
	}

	public void setNluftWechselZahl(double nLuftWechselZahl) {
		if (nLuftWechselZahl < 0.2 || nLuftWechselZahl > 40) {
			throw new IllegalArgumentException(
					"Luftwechselangaben sollten zwischen 0.2/h und 40/h liegen !");
		}
		this.nLuftWechselZahl = nLuftWechselZahl;
	}

	public double getRaumSollWert() {

		return raumSollWert;
	}

	public void setRaumSollWert(double raumSollWert) {
		if (raumSollWert < 5 || raumSollWert > 35) {
			throw new IllegalArgumentException(
					"Raumsollwert sollte zwischen 5°C und 35°C liegen!");
		}
		this.raumSollWert = raumSollWert;

	}

	public double getAussenTemperatur() {
		return aussenTemperatur;
	}

	public void setAussenTemperatur(double aussenTemperatur) {
		if (aussenTemperatur <= -30 || aussenTemperatur > 40) {
			throw new IllegalArgumentException(
					"Außentemperatur entspricht lebensgefährlichen Bedingungen!");
		}
		this.aussenTemperatur = aussenTemperatur;
	}

	public double getFlaecheFenster() {
		return 0;
	}

	public void setFlaecheFenster(double flaecheFenster) {
	}

	public double getKWertFenster() {
		return 0;
	}

	public void setKWertFenster(double kWertFenster) {
	}

	public double getFlaecheWand() {
		return 0;
	}

	public void setFlaecheWand(double flaecheWand) {
	}

	public double getKWertWand() {
		return 0;
	}

	public void setKWertWand(double kWertWand) {
	}

	public double getQiWaermeverluste() {
		return 0;
	}

	public void setQiWaermeverluste(double qIWaermeVerluste) {
	}

	public double getqHeiz() {
		return 0;
	}

	public void setqHeiz(double qHeiz) {
	}

	public double getResult() {
		return 0;
	}

	public void berechnen() {
	}

}
