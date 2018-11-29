package src.main.java.model.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import src.main.java.model.Fichier;
import src.main.java.model.Url;

/**
 * Classe de tests de la classe Fichier
 * @author Romiche
 *
 */
public class TestFichier {

	final Url url = new Url("https://fr.wikipedia.org/wiki/Coupe du monde de football");
	final Url url2 = new Url("https://fr.wikipedia.org/wiki/Internationaux de France de tennis");
	
	Fichier Wikiurls = new Fichier();
	//final static File Wikiurls = new File("wikiurls.txt");
	
	/**
	 * Test de la m�thode addUrl()
	 * Ajoute un Url dans un Fichier
	 * @return true si ajout dans fichier OK
	 * @throws Exception
	 */
	@Test
	public void TestAdd() throws Exception {
		Fichier fichier = new Fichier();
		boolean assert1 = fichier.addUrl(url);
		//System.out.println(fichier.toString());
		assertTrue("Url ajout�", assert1);
	}
	
	/**
	 * Test de la m�thode removeUrl()
	 * Supprime un Url dans un Fichier
	 * @return true si suppression dans fichier OK
	 * @throws Exception
	 */
	@Test
	public void TestRemove() throws Exception {
		Fichier fichier = new Fichier();
		fichier.addUrl(url);
		fichier.addUrl(url2);
		boolean assertR = fichier.removeUrl(url);
		//System.out.println(fichier.toString());
		assertTrue("Url supprim�", assertR);
	}
	
	/**
	 * Test de la m�thode toString()
	 * Affiche le fichier contenant les Urls ajout�, sous forme de String
	 * 
	 */
	@Test
	public void TestToString() {
		Fichier fichier = new Fichier();
		fichier.addUrl(url);
		System.out.println(fichier.toString());
		assertEquals(fichier.toString(),
				"[~~~~~~~~~~~~~~~~~~~~~~~~~~~Fichier~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n"
				+ "1--> https://fr.wikipedia.org/wiki/Coupe du monde de football" + "\n"
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~]");
	}
	
	/**
	 * Production des Urls dans un fichier 
	 * (utilisation de la m�thode productUrl() de la classe Fichier)
	 * Ensuite on parcourt tous les Urls du fichier
	 * Et on test si ils existent ou non
	 * Enfin, les assert testent si il y a bien 314 Urls valident 
	 * et 22 non valident gr�ce � des variables comptants ces validit�s.
	 */
	@Test
	public void TestReadFile() {
		int articleOK = 0, articleKO = 0;
		Wikiurls.productUrls();
		for (Url url : Wikiurls.setUrl) {
			if (url.isValidUrl()) {
				articleOK++;
			} else {
				articleKO++;
			}
		}
		System.out.println(Wikiurls.toString());
		assertEquals(articleOK, 314);
		assertEquals(articleKO, 22);
	}
	

	/**
	 * 
	 */
	@Test
	public void TestUrlFromFile() {
		
	}
}