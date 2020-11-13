package ru.grigoreva.springclientweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.grigoreva.springclientweb.dao.ServerExchangeDAO;
import ru.grigoreva.springclientweb.models.Message;

@RestController
@RequestMapping("/server")
public class ServerController {

    private final ServerExchangeDAO serverExchangeDAO;

    @Autowired
    public ServerController( ServerExchangeDAO serverExchangeDAO) {
        this.serverExchangeDAO = serverExchangeDAO;

    }

    @PostMapping("/messages")
    public String receiveMessages(@RequestBody Message message){
        serverExchangeDAO.saveMessageFromServer(message) ;
  //  public String recieveServerName(){
        return null;

    }


}
