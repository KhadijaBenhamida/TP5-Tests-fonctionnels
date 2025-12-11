<?php
namespace Tests\Acceptance;

use Tests\Support\AcceptanceTester;

class Test2_AjoutCest
{
    public function testAjout(AcceptanceTester $I)
    {
        $I->wantTo('Créer un nouveau produit');
        
        // Login
        $I->amOnPage('/login');
        $I->fillField('email', 'Charbel');
        $I->fillField('password', 'admin123');
        $I->click('button[type="submit"]');
        $I->waitForElement('table', 10);
        
        // Aller à la page de création
        $I->click('Créer un nouveau produit');
        $I->waitForElement('#nom', 5);
        
        // Remplir le formulaire
        $I->fillField('#nom', 'ProduitCodeception');
        $I->fillField('#prix', '200');
        $I->selectOption('#devise', 'EUR');
        $I->fillField('#taxe', '30');
        $I->fillField('#dateExpiration', '2025-12-31');
        $I->fillField('#fournisseur', 'FournisseurCodeception');
        
        // Soumettre via JavaScript (bouton caché par navbar)
        $I->executeJS("document.querySelector('form[action=\"/create\"]').submit()");
        
        // Vérifier retour à la liste
        $I->waitForElement('table', 10);
        $I->seeElement('table');
        
        $I->comment('✓ Test Ajout réussi');
    }
}
