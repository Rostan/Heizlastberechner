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
	private double flaecheFenster;
	private double flaecheWand;
	private double kWertFenster;
	private double kWertWand;
	private double qIWaermeVerluste;

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
		return flaecheFenster;
	}

	public void setFlaecheFenster(double flaecheFenster) {
		if (flaecheFenster < 0) {
			throw new IllegalArgumentException(
					"Fensterflaeche darf und kann nicht negativ sein!");
		}
		this.flaecheFenster = flaecheFenster;
	}

	public double getKWertFenster() {
		return kWertFenster;
	}

	public void setKWertFenster(double kWertFenster) {
		if (kWertFenster < 0.7 || kWertFenster > 6) {
			throw new IllegalArgumentException(
					"Waermedurchgangskoeffizient entspricht nicht dem Wertebereich von 0,7 W/(m²K) bis 5,9 W/(m²K)");
		}
		this.kWertFenster = kWertFenster;
	}

	public double getFlaecheWand() {
		return flaecheWand;
	}

	public void setFlaecheWand(double flaecheWand) {
		if (flaecheWand < 0) {
			throw new IllegalArgumentException(
					"Wandflaeche darf und kann nicht negativ sein!");
		}
		this.flaecheWand = flaecheWand;
	}

	public double getKWertWand() {
		return kWertWand;
	}

	public void setKWertWand(double kWertWand) {
		if (kWertWand < 0.2 || kWertWand > 5.3) {
			throw new IllegalArgumentException(
					"Waermedurchgangskoeffizient entspricht nicht dem Wertebereich von 0,7 W/(m²K) bis 5,9 W/(m²K)");
		}
		this.kWertWand = kWertWand;
	}

	public double getQiWaermeverluste() {
		return qIWaermeVerluste;
	}

	public void setQiWaermeverluste(double qIWaermeVerluste) {
		if (qIWaermeVerluste <= 0){
			throw new IllegalArgumentException(
					"Unzulässige Wertangabe in Watt!");
		}
		this.qIWaermeVerluste = qIWaermeVerluste;
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
