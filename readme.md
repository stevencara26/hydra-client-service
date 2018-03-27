# hydra-client-service
Fields in the Client and EndClient beans are as follows:

    Client
        Integer clientId
        String clientName
    
    EndClient
        Integer endClientId
        String endClientName
 

The controller can perform the following functions:

    ClientController
        findOneClient(@PathVariable Integer id), via a GET to /one/client/{id}
        findAllClient(), via a GET to /all/client
        createClient(@Valid @RequestBody Client client) via a POST to /client/create
	updateClient(@Valid @RequestBody Client client) via a PUT to /client/update
	deleteClient(@PathVariable int id) via a DELETE to /client/delete/{id} 

     EndClientController
        findOneEndClient(@PathVariable Integer id), via a GET to /one/endclient/{id}
        findAllEndClient(), via a GET to /all/endclient

	createEndClient(@Valid @RequestBody EndClient endclient) via a POST to /endclient/create
	updateEndClient(@Valid @RequestBody EndClient endclient) via a PUT to /endclient/update
	deleteEndClient(@PathVariable int id) via a DELETE to /endclient/delete/{id} 