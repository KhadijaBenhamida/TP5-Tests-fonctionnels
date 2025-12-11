<?php
namespace Tests\Support;

class AcceptanceHelper extends \Codeception\Module
{
    public function login($email, $password)
    {
        $I = $this->getModule('WebDriver');
        $I->amOnPage('/login');
        $I->fillField('email', $email);
        $I->fillField('password', $password);
        $I->click('button[type="submit"]');
        $I->waitForElement('table', 10);
    }
}
