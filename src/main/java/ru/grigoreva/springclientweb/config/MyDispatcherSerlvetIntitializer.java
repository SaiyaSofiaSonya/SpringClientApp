package ru.grigoreva.springclientweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Используется для конфигурации вместо web.xml ( При запуске Tomcat считывает web.xml и использует считанную конфигурацию)
public class MyDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /* содержит общие ресурсы, такие как DataSource, службы, репозитории
      (не используется, но необходимо реализовать абстрактный метод)*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
/*содержит  преобразователь представления, сопоставления обработчиков, контроллеры*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }
  /*  В этой типичной настройке корневой контекст загружается с помощью
  ContextLoaderListener и контекст сервлета с помощью DispatcherServlet.

    В старые времена можно было написать web.xml, который содержал бы
    servlet-listener для ContextLoaderListener и элемент servlet для DispatcherServlet.

    */

    @Override//Конфигурация загружается из класса Config
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }  // указывает путь для запросов пользователя (на /)

}
