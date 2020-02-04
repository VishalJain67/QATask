Feature: Purchase Feature
  Verify if user is able to purchase pillow using Credit card as Payment method

  Scenario: Peform Purchase of Pillow using Credit Card
    Given user is on page which lists the pillow to be purchased
    When user clicks on Buy Now and is taken to Payment page
    And user selects Credit card as payment option, enters card details and proceeds with payment
    And user enters the card otp and clicks on pay
    Then success message is displayed