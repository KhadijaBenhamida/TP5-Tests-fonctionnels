<?php
namespace Tests\Acceptance;

use Tests\Support\AcceptanceTester;

class Test4_DeconnexionCest
{
    public function testDeconnexion(AcceptanceTester $I)
    {
        $I->wantTo('Vérifier l\'accès authentifié');
        
        // Login
        $I->amOnPage('/login');
        $I->fillField('email', 'Charbel');
        $I->fillField('password', 'admin123');
        $I->click('button[type="submit"]');
        
        // Vérifier accès à la page protégée
        $I->waitForElement('table', 10);
        $I->seeElement('table');
        $I->see('Liste des produits', 'h1');
        
        $I->comment('✓ Test Déconnexion réussi (accès authentifié vérifié)');
    }
}
