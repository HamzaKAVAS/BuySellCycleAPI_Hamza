Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Digital_gift_cards Database Testing
    #digital_gift_cards tablosuna 1 adet veri girişi yapıp eklenen veriyi digital_gift_cards tablosunda id numarası girerek siliniz.
    Given (digital_gift_cards) SQL query is prepared and executed.
    When (digital_gift_cards) is verified.
    And (digital_gift_cards) SQL Delete query is prepared and executed.
    Then (digital_gift_cards) SQL Delete query is verified.
    Then Database connection is terminated.






