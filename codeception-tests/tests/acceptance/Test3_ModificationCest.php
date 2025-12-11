<?php
namespace Tests\Acceptance;

use Tests\Support\AcceptanceTester;

class Test3_ModificationCest
{
    public function testModification(AcceptanceTester $I)
    {
        $I->wantTo('Modifier un produit existant');
        
        // Login
        $I->amOnPage('/login');
        $I->fillField('email', 'Charbel');
        $I->fillField('password', 'admin123');
        $I->click('button[type="submit"]');
        $I->waitForElement('table', 10);
        
        // Cliquer sur "Mettre à jour"
        $I->click('Mettre à jour');
        $I->waitForElement('#nom', 5);
        
        // Modifier le nom
        $I->executeJS("document.getElementById('nom').value = ''");
        $I->fillField('#nom', 'ProduitModifieCodeception');
        
        // Soumettre via JavaScript
        $I->executeJS("
            var id = window.location.pathname.split('/maj/')[1];
            document.querySelector('form[action=\"/update/' + id + '\"]').submit();
        ");
        
        // Vérifier retour à la liste
        $I->waitForElement('table', 10);
        $I->seeElement('table');
        
        $I->comment('✓ Test Modification réussi');
    }
}
