package ru.grigoreva.springclientweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration  //Указывает, что класс объявляет метод @Bean и может обрабатываться контейнером Spring для генерации определений компонентов и запросов на обслуживание для этих компонентов во время выполнения
@ComponentScan("ru.grigoreva.springclientweb") //сканирует все компоненты и контроллеры в пакете, в т.ч. во вложенных папках. Создает bean из них
@EnableWebMvc  //  аналогичем mvc: anotation-driven, устанавливает context Spring, чтобы разрешить отправку Controller (@RequestMapping, @Controller)
public class Config implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired //Внедряется applicationContext
    public Config(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean // используется для настройки шаблонизатора Thymeleaf
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");  //конфигурируем место, где лежат представления
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean// используется для настройки шаблонизатора Thymeleaf
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }



    @Override // используется для настройки  шаблонизатора Thymeleaf
    public void configureViewResolvers(ViewResolverRegistry registry){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }







}
