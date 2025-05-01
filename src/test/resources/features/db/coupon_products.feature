Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Coupon_products Database Testing
    #coupon_products tablosunu coupon_id'ye göre gruplayarak her kupon için kaç ürün olduğunu bulunuz.

    Given (coupon_products) SQL query is prepared and executed.
    When (coupon_products) is verified.
    Then Database connection is terminated.