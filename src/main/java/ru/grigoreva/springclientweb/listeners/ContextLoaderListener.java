package ru.grigoreva.springclientweb.listeners;


import org.springframework.stereotype.Component;


@Component
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener{

   // Выполняется при запуске приложения
    public ContextLoaderListener()
    {
        System.out.println( "Ready to send message..." );
    }
}


