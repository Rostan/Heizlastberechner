package de.saxsys.heizwertberechner;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.binding.Bindings;

/**
 * QBerechnung stellt die Parameter und Methoden zur Heizmengenberechnung zur Verfügung.
 * 
 * @author roman.stange
 * 
 */

public class QBerechnung {

	private static final double SPEZ_WAERMEKAP_LUFT = 1005; // J/(kg*K)
	private static final double DICHTE_LUFT = 1.292; // [ kg / m3 ]
	private static final double SEKUNDEN_PRO_STUNDE = 3600;
	private DoubleProperty raumSollWert = new SimpleDoubleProperty();
	private DoubleProperty nLuftWechselZahl = new SimpleDoubleProperty();
	private DoubleProperty aussenTemperatur = new SimpleDoubleProperty();
	private DoubleProperty flaecheFenster = new SimpleDoubleProperty();
	private DoubleProperty flaecheWand = new SimpleDoubleProperty();
	private DoubleProperty kWertFenster = new SimpleDoubleProperty();
	private DoubleProperty kWertWand = new SimpleDoubleProperty();
	private DoubleProperty qIWaermeVerluste = new SimpleDoubleProperty();
	private DoubleProperty qHeiz = new SimpleDoubleProperty();

	private DoubleProperty ergebnis = new SimpleDoubleProperty();
	protected NumberBinding deltaTemperatur;
	protected NumberBinding nLuftwechselZahlProStundeInSekunden; 
	protected NumberBinding waermeVerlusteDurchFenster;
	protected NumberBinding waermeVerlusteDurchWand;
	protected NumberBinding verlusteMinusGewinne;
	
	/**
	 * Konstruktor der Heizmenge Qi in Watt pro Stunde ausrechnet
	 */
	
	public QBerechnung() {
		deltaTemperatur = Bindings.subtract(raumSollWert,
				aussenTemperatur);
		nLuftwechselZahlProStundeInSekunden = (Bindings.divide(nLuftWechselZahl, SEKUNDEN_PRO_STUNDE));
		waermeVerlusteDurchFenster = Bindings.add((nLuftwechselZahlProStundeInSekunden
				.multiply(DICHTE_LUFT).multiply(SPEZ_WAERMEKAP_LUFT)
				.multiply(deltaTemperatur)), (flaecheFenster
				.multiply(kWertFenster).multiply(deltaTemperatur)));
		
		waermeVerlusteDurchWand = Bindings.add(waermeVerlusteDurchFenster,
				(flaecheWand.multiply(kWertWand).multiply(deltaTemperatur)));
		verlusteMinusGewinne = Bindings.subtract(waermeVerlusteDurchWand, qIWaermeVerluste);
		
		ergebnis.bind(verlusteMinusGewinne);
	}
	
	
	/**
	 * 
	 * @return die Luftwechselzahl n pro Stunde
	 */
	public double getNluftWechselZahl() {

		return nLuftWechselZahl.get();
	}

	public void setNluftWechselZahl(double nLuftWechselZahl) {
		if (nLuftWechselZahl < 0.2 || nLuftWechselZahl > 40) {
			throw new IllegalArgumentException(
					"Wert für Luftwechselzahl liegt nicht im Wertebereich - sollte zwischen 0.2/h und 40/h liegen !");
		}
		this.nLuftWechselZahl.set(nLuftWechselZahl);
	}
	
	/**
	 * 
	 * @return Raumsollwert in °Celsius
	 */
	public double getRaumSollWert() {

		return raumSollWert.get();
	}

	public void setRaumSollWert(double raumSollWert) {
		if (raumSollWert < 5 || raumSollWert > 35) {
			throw new IllegalArgumentException(
					"Raumsollwert erscheint unrealistisch - sollte zwischen 5°C und 35°C liegen!");
		}
		this.raumSollWert.set(raumSollWert);

	}
	/**
	 * 
	 * @return Außentemperatur in ° Celsius
	 */
	public double getAussenTemperatur() {
		return aussenTemperatur.get();
	}

	public void setAussenTemperatur(double aussenTemperatur) {
		if (aussenTemperatur <= -30 || aussenTemperatur > 40) {
			throw new IllegalArgumentException(
					"Wert der Außentemperatur entspricht lebensgefährlichen Bedingungen!");
		}
		this.aussenTemperatur.set(aussenTemperatur);
	}
	/**
	 * 
	 * @return Fensterfläche in m²
	 */
	public double getFlaecheFenster() {
		return flaecheFenster.get();
	}

	public void setFlaecheFenster(double flaecheFenster) {
		if (flaecheFenster < 0) {
			throw new IllegalArgumentException(
					"Angaben der Fensterflaeche dürfen und können nicht negativ sein!");
		}
		this.flaecheFenster.set(flaecheFenster);
	}
	
	/**
	 * 
	 * @return k-Wert Fenster(Wärmedurchgangskoeffizent)
	 */
	public double getKWertFenster() {
		return kWertFenster.get();
	}

	public void setKWertFenster(double kWertFenster) {
		if (kWertFenster < 0.7 || kWertFenster > 6) {
			throw new IllegalArgumentException(
					"Waermedurchgangskoeffizient entspricht nicht dem Wertebereich von 0,7 W/(m²K) bis 5,9 W/(m²K)");
		}
		this.kWertFenster.set(kWertFenster);
	}
	/**
	 * 
	 * @return Fensterfläche in m²
	 */
	public double getFlaecheWand() {
		return flaecheWand.get();
	}

	public void setFlaecheWand(double flaecheWand) {
		if (flaecheWand < 0) {
			throw new IllegalArgumentException(
					"Angaben der Wandflaeche dürfen und könnennicht negativ sein!");
		}
		this.flaecheWand.set(flaecheWand);
	}
	/**
	 * 
	 * @return  k-Wert Wand (Wärmedurchgangskoeffizent)
	 */
	public double getKWertWand() {
		return kWertWand.get();
	}
	
	/**
	 * 
	 * @param kWertWand
	 */
	public void setKWertWand(double kWertWand) {
		if (kWertWand < 0.2 || kWertWand > 5.3) {
			throw new IllegalArgumentException(
					"Waermedurchgangskoeffizient entspricht nicht dem Wertebereich von 0,2 W/(m²K) bis 5,3 W/(m²K)");
		}
		this.kWertWand.set(kWertWand);
	}
	/**
	 * 
	 * @return Wärmeverluste in Watt
	 */
	public double getQiWaermeverluste() {
		return qIWaermeVerluste.get();
	}
	
	/**
	 * 
	 * @param qIWaermeVerluste
	 */
	public void setQiWaermeverluste(double qIWaermeVerluste) {
		if (qIWaermeVerluste <= 0) {
			throw new IllegalArgumentException(
					"Unzulässige Wertangabe in Watt!");
		}
		this.qIWaermeVerluste.set(qIWaermeVerluste);
	}
	
	/**
	 * 
	 * @return Heizwert in Watt
	 */
	public double getQHeiz() {
		return qHeiz.get();
	}

	public void setQHeiz(double qHeiz) {
		if (qHeiz <= 0) {
			throw new IllegalArgumentException("Unzulässige Wertangabe!");
		}
		this.qHeiz.set(qHeiz);
	}

	public double getResult() {
		return ergebnis.get();
	}

	public DoubleProperty ergebnisProperty() {
		return ergebnis;
	}

}
