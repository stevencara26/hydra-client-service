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
        
     EndClientController
        findOneEndClient(@PathVariable Integer id), via a GET to /one/endclient/{id}
        findAllEndClient(), via a GET to /all/endclient

