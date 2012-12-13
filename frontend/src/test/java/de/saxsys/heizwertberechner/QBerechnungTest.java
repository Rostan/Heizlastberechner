package de.saxsys.heizwertberechner;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class QBerechnungTest {

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

		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setRaumSollWert(minimalErlaubteRaumSollWert);
		assertEquals(qBerechnung.getRaumSollWert(),
				minimalErlaubteRaumSollWert, 0.5);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRaumSollWertUntergrenzeVerbotenerWert() {
		
		double zuKleinerRaumSollWert = 4.9;

		QBerechnung qBerechnung = new QBerechnung();

		qBerechnung.setRaumSollWert(zuKleinerRaumSollWert);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRaumSollWertObergrenzeVerbotenerWert() {
		
		double zuGrosserRaumSollWert = 35.1;

		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setRaumSollWert(zuGrosserRaumSollWert);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNLuftWechselZahlUntergrenzeVerbotenerWert(){
		double nLuftWechselZahlKleinerGleichNull = 0;
		
		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setRaumSollWert(nLuftWechselZahlKleinerGleichNull);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNLuftWechselZahlObergrenzeVerbotenerWert(){
		double nLuftWechselZahlGroeßerAlsVierzig = 41;
		
		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setRaumSollWert(nLuftWechselZahlGroeßerAlsVierzig);
	}
	
	@Test
	public void testNLuftWechselZahlUntergrenzeErlaubterWert(){
		double testNLuftWechselZahlUntergrenzeErlaubterWert = 0.2;
		
		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setNluftWechselZahl(testNLuftWechselZahlUntergrenzeErlaubterWert);
		assertEquals(qBerechnung.getNluftWechselZahl(),
				testNLuftWechselZahlUntergrenzeErlaubterWert, 0.5);
	}
	
	@Test
	public void testAussenTemperaturUntergrenzeErlaubterWert(){
		double aussenTemperaturUnterGrenzeErlaubterWert = -29.5;
		
		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setAussenTemperatur(aussenTemperaturUnterGrenzeErlaubterWert);
		assertEquals(qBerechnung.getAussenTemperatur(), aussenTemperaturUnterGrenzeErlaubterWert, 0.5); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAussenTemperaturUntergrenzeVerbotenerWert(){
		double aussenTemperaturUnterGrenzeVerbotenerWert = -30;
		
		QBerechnung qBerechnung = new QBerechnung();
		qBerechnung.setAussenTemperatur(aussenTemperaturUnterGrenzeVerbotenerWert);
	}
}
