<!DOCTYPE html>

<html>

<head>

	<style>
		
		body {
			font-family: arial, sans-serif;
			font-size: 14px;
		}

	</style>

</head>

<body>

	<h1 style="text-decoration: underline;">Fancy Forms</h1>

	<h1>Add flight and airplane</h1>

	<form method="POST" action="AddFlight">

		From:  

		<select id="from_destination" name="from_destination">
			<option value="DELHI">DELHI</option>
			<option value="KOLKATA">KOLKATA</option>
			<option value="HYDERABAD">HYDERABAD</option>
			<option value="BANGALORE">BANGALORE</option>
			<option value="PUNE">PUNE</option>
			<option value="MUMBAI">MUMBAI</option>
			<option value="AHMEDABAD">AHMEDABAD</option>
		</select>

		<br /><br />

		To: 

		<select name="to_destination">
			<option value="DELHI">DELHI</option>
			<option value="KOLKATA">KOLKATA</option>
			<option value="HYDERABAD">HYDERABAD</option>
			<option value="BANGALORE">BANGALORE</option>
			<option value="PUNE">PUNE</option>
			<option value="MUMBAI">MUMBAI</option>
			<option value="AHMEDABAD">AHMEDABAD</option>
		</select>

		<h4>Time of flight:</h4>

		<hr />

		Year: 

		<select name="year">
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
		</select>

		<br /><br />

		Month: 

		<select name="month">
			<option value="0">January</option>
			<option value="1">February</option>
			<option value="2">March</option>
			<option value="3">April</option>
			<option value="4">May</option>
			<option value="5">June</option>
			<option value="6">July</option>
			<option value="7">August</option>
			<option value="8">September</option>
			<option value="9">October</option>
			<option value="10">November</option>
			<option value="11">December</option>
		</select>

		<br /><br />

		Day of month: 

		<input name="day" type="text"></input>

		<br /><br />

		Hour of day (0 - 23): 

		<input name="hour" type="text"></input>

		<br /><br />

		Minute (0 - 59): 

		<input name="minute" type="text"></input>

		<br /><br />

		Price: 

		<input name="price" type="text"></input>

		<hr />

		<h4>Airplane:</h4>

		Plane make: 

		<input name="airplane_make" type="text"></input>

		<br /><br />

		Model name: 

		<input name="airplane_model" type="text"></input>

		<br /><br />

		Seating: 

		<input name="airplane_seating" type="text"></input>

		<hr />

		<button type="submit">Add flight and airplane</button>

		<hr />

	</form>

	<h1>Add pilot to flight</h1>

	<form method="POST" action="AddPilot">

		First name:  

		<input name="first_name" type="text"></input>

		<br /><br />

		Last name:  

		<input name="last_name" type="text"></input>

		<br /><br />

		License:  

		<input name="license" type="text"></input>

		<br /><br />
		
		Pilot rank:
		
		<select name="pilot_rank">
			<option value="CAPTAIN">CAPTAIN</option>
			<option value="FIRST_OFFICER">FIRST_OFFICER</option>
			<option value="SECOND_OFFICER">SECOND_OFFICER</option>
		</select>
				
		<br /><br />

		Flight Id: 

		<input name="fid" type="text"></input>

		<hr />

		<button type="submit">Add pilot to flight</button>

		<hr />

	</form>

	<h1>Add Passenger</h1>

	<form method="POST" action="">

		First name:   

		<input name="first_name" type="text"></input>

		<br /><br />

		Last name:  

		<input name="last_name" type="text"></input>

		<br /><br />

		Date of birth:   

		<input name="dob" type="text"></input>

		<br /><br />

		Gender:  

		<select name="gender">
			<option value="Female">Female</option>
			<option value="Male">Male</option>
		</select>

		<hr />

		<button type="submit">Add passenger</button>

		<hr />

	</form>

		<h1>Add passenger to flight</h1>

	<form method="POST" action="">

		Add a passenger with an id of 

		<input name="pid" type="text"></input>

		to a flight with an id of 

		<input name="fid" type="text"></input>		

		<hr />

		<button type="submit">Add passenger to flight</button>

		<hr />


	</form>

	<h1>Add flight to passenger <span style="font-size: 16px; vertical-align: middle;">(give a passenger another flight ticket to his\her collection of flight tickets)</span></h1>

	<form method="post" action="">

		Add a ticket for a flight with an id of      

		<input name="fid" type="text"></input>

		to a passenger with an id of

		<input name="pid" type="text"></input>	

		<br /><br />

		<span style="font-weight: bold;">(In real world terms - add the flight ticket to the passenger's collection of flight tickets)</span>

		<hr />

		<button type="submit">Add flight (ticket) to passenger's flight tickets</button>

		<hr />


	</form>

</body>

</html>