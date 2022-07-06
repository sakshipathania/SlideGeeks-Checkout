@Coupon
Feature:  Coupon
Scenario: Coupon

Given user is already on Website Home Page cc
Then user is redirected to pricing page and choose the plan to pay cc
Then user is redirected checkout page cc
Then user proceed to pay with paypal pp cc
Then paypal popup appears and user navigates back to my account pp cc
Then user Signout account PP cc
