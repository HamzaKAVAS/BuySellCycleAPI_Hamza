Feature: Verify the name value of a categorie with 'slug = fashion' in the Categories table.

  Background: Database connectivity
    Given Database connection established

  Scenario: Verify the name value of a categorie with 'slug = fashion' in the Categories table.
    When a SQL query is prepared and executed on the Categories table.
    Then the name of the category with slug = fashion should be verified as "Fashion".
    Then Database connection is terminated.