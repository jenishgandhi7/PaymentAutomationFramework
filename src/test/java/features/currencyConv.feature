Feature: Payment Form using Credit Card or ACH payment Method

  Scenario Outline: Credit Card Payment
    Given Initialize the browser with chrome
    And Navigate to "https://staging.autobooks.co/pay/autobooks--ephrata-national-bank" Site
    When Enter User Information  <FirstName>, <LastName>, <Email>, <Company> and <Description>
    And Enter Payment amount <Amount> and Payment Schedule <Schedule_Type> with <Schedule_Frq>
    And Enter Credit Card  Details as <CardHolderName>, <CardNumber>, <Exp_Month>, <Exp_Year>, <CCV> and <Zipcode>
    Then Verify that Payment on Confirmation page
    And close browsers

    Examples: 
      | FirstName | LastName | Email              | Company    | Description      | Amount | Schedule_Type     | Schedule_Frq | CardHolderName | CardNumber       | Exp_Month | Exp_Year | CCV | Zipcode |
      | Test      | QA       | test.QA@gmail.com  | test Cmpny | Test Description | 100.00 | One Time Payment  |              | Test QA        | 5112000100000003 |        06 |     2022 | 121 |   78727 |
      | Test1     | QA1      | test.QA1@gmail.com | test Cmpny | Test Description | 120.00 | Recurring Payment | Monthly      | Test QA        | 5112000100000003 |        06 |     2022 | 121 |   78727 |
      | Test2     | QA2      | test.QA2@gmail.com | test Cmpny | Test Description | 150.00 | Recurring Payment | Weekly       | Test QA        | 5112000100000003 |        06 |     2022 | 121 |   78727 |

  Scenario Outline: ACH Payment
    Given Initialize the browser with chrome
    And Navigate to "https://staging.autobooks.co/pay/autobooks--ephrata-national-bank" Site
    When Enter User Information  <FirstName>, <LastName>, <Email>, <Company> and <Description>
    And Enter Payment amount <Amount> and Payment Schedule <Schedule_Type> with <Schedule_Frq>
    And Enter ACH Payment Details as <CardHolderName>, <Acc_Type>, <Acc_USe>, <Acc_Routing>, <Acc_number> and <Acc_No_Conf>
    Then Verify that Payment on Confirmation page
    And close browsers

    Examples: 
      | FirstName | LastName | Email              | Company    | Description      | Amount | Schedule_Type     | Schedule_Frq | CardHolderName | Acc_Type | Acc_Use  | Acc_Routing | Acc_number       | Acc_No_Conf      |
      | Test      | QA       | test.QA@gmail.com  | test Cmpny | Test Description | 100.00 | One Time Payment  |              | Test QA        | Checking | Personal |   072000805 | 5112000100000003 | 5112000100000003 |
      | Test1     | QA1      | test.QA1@gmail.com | test Cmpny | Test Description | 120.00 | Recurring Payment | Monthly      | Test QA        | Savings  | Business |   072000805 | 5112000100000003 | 5112000100000003 |
      | Test2     | QA2      | test.QA2@gmail.com | test Cmpny | Test Description | 150.00 | Recurring Payment | Weekly       | Test QA        | Checking | Personal |   072000805 | 5112000100000003 | 5112000100000003 |
