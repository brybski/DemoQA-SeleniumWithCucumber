Feature: Login tests
  As customer, I should be able to login

@SmokeTest
  Scenario: Successful logging in with correct credentials
    When User clicks on Login button
    Then User is redirected to 'Login' page
    When User inputs 'br' as a login and 'Haslo123!' as a password and clicks login button
    Then User 'br' is successfully logged in
    #to be done - scenario context to be used to avoid duplicating the data ('br' user listed twice)