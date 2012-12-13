package de.saxsys.heizwertberechner;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class QBerechnungTest {

	private QBerechnung qBerechnung = new QBerechnung();

	@Ignore
	@Test
	public void testBerechnen() {

		// alle werte setzen
		double erwartetesErgebnis = 2381.5;

		double nLuftwechselZahl = 0.2;
		double raumSollWert = 20;
		double aussenTemperatur = -2.3;
		double flaecheFenster = 10;
		double kWertFenster = 1.3;
		double flaecheWand = 50;
		double kWertWand = 1.2;
		double qIWaermeVerluste = 50;

		QBerechnung qBerechnung = new QBerechnung();

		qBerechnung.setNluftWechselZahl(nLuftwechselZahl);
		qBerechnung.setRaumSollWert(raumSollWert);
		qBerechnung.setAussenTemperatur(aussenTemperatur);
		qBerechnung.setFlaecheFenster(flaecheFenster);
		qBerechnung.setKWertFenster(kWertFenster);
		qBerechnung.setFlaecheWand(flaecheWand);
		qBerechnung.setKWertWand(kWertWand);
		qBerechnung.setQiWaermeverluste(qIWaermeVerluste);
		// berechnen

		qBerechnung.berechnen();
		double result = qBerechnung.getResult();
		// ergebnis überprüfen

		assertEquals(erwartetesErgebnis, result, 0.5);

	}

	@Test
	public void testRaumSollWertUntergrenzeErlaubterWert() {

		double minimalErlaubteRaumSollWert = 5;

		qBerechnung.setRaumSollWert(minimalErlaubteRaumSollWert);
		assertEquals(minimalErlaubteRaumSollWert,
				qBerechnung.getRaumSollWert(), 0.5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRaumSollWertUntergrenzeVerbotenerWert() {

		double zuKleinerRaumSollWert = 4.9;

		qBerechnung.setRaumSollWert(zuKleinerRaumSollWert);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRaumSollWertObergrenzeVerbotenerWert() {

		double zuGrosserRaumSollWert = 35.1;

		qBerechnung.setRaumSollWert(zuGrosserRaumSollWert);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNLuftWechselZahlUntergrenzeVerbotenerWert() {
		double nLuftWechselZahlKleinerGleichNull = 0;

		qBerechnung.setRaumSollWert(nLuftWechselZahlKleinerGleichNull);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNLuftWechselZahlObergrenzeVerbotenerWert() {
		double nLuftWechselZahlGroesserAlsVierzig = 41;

		qBerechnung.setRaumSollWert(nLuftWechselZahlGroesserAlsVierzig);
	}

	@Test
	public void testNLuftWechselZahlUntergrenzeErlaubterWert() {
		double testNLuftWechselZahlUntergrenzeErlaubterWert = 0.2;

		qBerechnung
				.setNluftWechselZahl(testNLuftWechselZahlUntergrenzeErlaubterWert);
		assertEquals(testNLuftWechselZahlUntergrenzeErlaubterWert,
				qBerechnung.getNluftWechselZahl(), 0.5);
	}

	@Test
	public void testAussenTemperaturUntergrenzeErlaubterWert() {
		double aussenTemperaturUnterGrenzeErlaubterWert = -29.5;

		qBerechnung
				.setAussenTemperatur(aussenTemperaturUnterGrenzeErlaubterWert);
		assertEquals(aussenTemperaturUnterGrenzeErlaubterWert,
				qBerechnung.getAussenTemperatur(), 0.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAussenTemperaturUntergrenzeVerbotenerWert() {
		double aussenTemperaturUnterGrenzeVerbotenerWert = -30;

		qBerechnung
				.setAussenTemperatur(aussenTemperaturUnterGrenzeVerbotenerWert);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAussenTemperaturObergrenzeVerbotenerWert() {
		double aussenTemperaturObergrenzeVerbotenerWert = 41;

		qBerechnung
				.setAussenTemperatur(aussenTemperaturObergrenzeVerbotenerWert);
	}

	@Test
	public void testFlaecheFensterUntergrenzeErlaubteWerte() {
		double flaecheFensterUntergrenzeErlaubterWert = 0;

		qBerechnung.setFlaecheFenster(flaecheFensterUntergrenzeErlaubterWert);
		assertEquals(flaecheFensterUntergrenzeErlaubterWert,
				qBerechnung.getFlaecheFenster(), 0.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFlaecheFensterObergrenzeVerbotenerWert() {
		double flaecheFensterObergrenzeVerbotenerWert = -0.1;

		qBerechnung.setFlaecheFenster(flaecheFensterObergrenzeVerbotenerWert);
	}

	@Test
	public void testFlaecheWandUntergrenzeErlaubteWerte() {
		double flaecheWandUntergrenzeErlaubterWert = 0;

		qBerechnung.setFlaecheWand(flaecheWandUntergrenzeErlaubterWert);
		assertEquals(flaecheWandUntergrenzeErlaubterWert,
				qBerechnung.getFlaecheWand(), 0.5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFlaecheWandObergrenzeVerbotenerWert() {
		double flaecheWandObergrenzeVerbotenerWert = -0.1;

		qBerechnung.setFlaecheWand(flaecheWandObergrenzeVerbotenerWert);
	}

	@Test
	public void testKWertFensterUntergrenzeErlaubterWert() {
		double kWertFensterUntergrenzeErlaubterWert = 0.8;

		qBerechnung.setKWertFenster(kWertFensterUntergrenzeErlaubterWert);
		assertEquals(kWertFensterUntergrenzeErlaubterWert,
				qBerechnung.getKWertFenster(), 0.5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKWertFensterUntergrenzeVerbotenerWert(){
		double kWertFensterUntergrenzeVerbotenerWert = 0.6;
		
		qBerechnung.setKWertFenster(kWertFensterUntergrenzeVerbotenerWert);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKWertFensterObergrenzeVerbotenerWert(){
		double kWertFensterObergrenzeVerbotenerWert = 6.1;
		
		qBerechnung.setKWertFenster(kWertFensterObergrenzeVerbotenerWert);
	}
}
