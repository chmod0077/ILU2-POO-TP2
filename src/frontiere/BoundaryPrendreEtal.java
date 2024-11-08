package frontiere;

import java.util.Scanner;
import java.util.ResourceBundle.Control;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if( !controlPrendreEtal.verifierIdentite(nomVendeur) ) {
			System.out.println("Je suis désolée " + nomVendeur + ", mais il faut etre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux te trouver un étal.");


			if( !controlPrendreEtal.resteEtals() ) {
				System.out.println("Désolée " + nomVendeur + ", je n'ai plus d'étal qui ne soit déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous!");
				System.out.println("Il me faudrait quelques renseignements");
				String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
				
				int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				
				if( numEtal != -1 ) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro " + numEtal);
				}
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
