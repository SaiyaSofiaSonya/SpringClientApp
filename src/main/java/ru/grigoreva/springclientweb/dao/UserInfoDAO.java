package ru.grigoreva.springclientweb.dao;

import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.grigoreva.springclientweb.models.Message;
import ru.grigoreva.springclientweb.models.Request;
import ru.grigoreva.springclientweb.models.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component //Для создания bean  и внедрения его в Controller
public class UserInfoDAO { //Вынесена логика с работой базой данных(сервером?) Переименовать класс
    private User userToJson;



    public void saveJsonAndSendToServer(User user) {


        //Сделать тут Ioc
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        Message message = new Message("Привет всем!",  dateFormat.format(date));
        Request request = new Request(user, message);



// Set the Content-Type header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application","json"));
        HttpEntity<Request> requestEntity = new HttpEntity<Request>(request, requestHeaders);

// Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

// Add the GSON and String message converters
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());


// Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8888/AppServer2_war_exploded/api", HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();



    }




}
