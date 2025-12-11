<?php
namespace Tests\Acceptance;

use Tests\Support\AcceptanceTester;

class Test1_ListingCest
{
    public function testListing(AcceptanceTester $I)
    {
        $I->wantTo('Vérifier que la liste des produits s\'affiche correctement');
        
        // Login
        $I->amOnPage('/login');
        $I->fillField('email', 'Charbel');
        $I->fillField('password', 'admin123');
        $I->click('button[type="submit"]');
        
        // Attendre et vérifier la table
        $I->waitForElement('table', 10);
        $I->seeElement('table');
        $I->see('Liste des produits', 'h1');
        
        $I->comment('✓ Test Listing réussi');
    }
}
