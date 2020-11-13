package ru.grigoreva.springclientweb.dao;
import org.springframework.stereotype.Component;
import ru.grigoreva.springclientweb.models.Message;


@Component //Для создания bean  и внедрения его в Controller
public class ServerExchangeDAO {   // не испоьлзуется
    private ServerExchangeDAO serverExchangeDAO;

    public void saveMessageFromServer(Message message) {
    }
}