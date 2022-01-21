SELECT Login.* FROM Login 
LEFT JOIN Client ON Login.clientid = Client.clientid WHERE (FirstName = 'Estrella' AND LastName = 'Bazely') AND Login.EmailAddress IS NOT NULL;