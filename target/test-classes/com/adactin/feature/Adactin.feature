Feature: Hotel Booking In Adactin Application 

Scenario: user Login In The Adactin Web Application 
	Given user Launch The Url In Adactin Application 
	When user Enter The Username In Username Field 	And user Enter The Password In Password Field 
	Then user Click On The Login Button To Search Hotel Page 
	
Scenario: user Enter In To The Search Hotel Page 
	When user Select The Location Of A Hotel 
	And user Select The Name Of A Hotel At Selected Location 
	And user Select The Type Of A Hotel Room In Selected Hotel 
	And user Select Number Of Rooms In Selected Hotel Room 
	And user Enter Date Of Checkin In Date Field In A Format Of DD/MM/YYYY 
	And user Enter Date Of Checkout In Date Field In A Format Of DD/MM/YYYY 
	And user Select Number Of Adults In The Adults Per Room Field 
	And user Select Number Of Children In The Children Per Room Field 
	Then user Click On The Search Button To Select Hotel Page 
	
Scenario: user Enter In To The Select Hotel Page 
	When user Select The Radio Button In The Select Hotel Page 
	Then user Click On The Continue Button To Book Hotel Page 
	
Scenario: user Enter In To The Book Hotel Page 
	When user Enter The First Name In First Name Field 
	And user Enter The Last Name In Last Name Field 
	And user Enter The User Address In Billing Address Field 
	And user Enter Sixteen Digit Credit Card Number In Credit Card Number Field 
	And user Select The Credit Card Type In Credit Card Type Field 
	And user Select The Expiry Month Of The Credit Card In Expiry Date Field 
	And user Select The Expiry Year Of The Credit Card In Expiry Date Field 
	And user Enter the CVV Number In CVV Number Field 
	Then user Click On The Book Now Button To Booking Confirmation Page 
	
Scenario: user Enter In To The Booking Confirmation Page 
	When user Click On The Logout Button To Logout Page 
	
