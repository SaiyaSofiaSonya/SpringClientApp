package ru.grigoreva.springclientweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.grigoreva.springclientweb.dao.UserInfoDAO;
import ru.grigoreva.springclientweb.models.User;

import java.util.Properties;


@Controller //анологичен @Component, @ComponentScan используется для создания Bean
@RequestMapping("/userinfo") //Все методы в контроллере имели префикс userinfo
public class UserInfoController {

        private final UserInfoDAO userInfoDAO;
        private final ApplicationContext applicationContext;

        @Autowired //Внедрение userinfodao в контроллер
        public UserInfoController(UserInfoDAO userInfoDAO, ApplicationContext applicationContext) {
            this.userInfoDAO = userInfoDAO;
            this.applicationContext = applicationContext;
        }
         @Resource(name="credentialsServer")
         @Qualifier("applicationContext")
         private Properties host;
         private Properties login;
         private Properties password;


        @GetMapping("/new")  //Возвращает страницу new.html  пользователю при переходе /userinfo/new, метод get
        public String newUserInfo(@ModelAttribute("user") User user) { //В контроллер внедряется модель данных User
            return "userinfo/new";
        }

        @PostMapping()
        public String addUserInfo(@ModelAttribute("user") User user) { //В контроллер внедряется модель данных User
                //@RequestParam("name") String name, @RequestParam("surname") String surname,
              //                            Model model){ //В контроллер внедряется модель данных User,
                                                        // указываются поля для представления

      // ModelAttribute("userinfo") User user) { //В контроллер внедряется модель данных User
    //        User user = new User(name, surname);
     //       user.setName(name);
      //      user.setSurname(surname);

            System.out.println("Object recieved: " + user.getSurname());
            userInfoDAO.saveJsonAndSendToServer(user);
            System.out.println("Object was executed in message: " + user.getSurname());
            return "userinfo/success";
        }

        @GetMapping("/success") //Возвращает страницу success.html пользователю при переходе /userinfo/success, метод get
        public String redirect(@ModelAttribute("user") User user) { //В контроллер внедряется модель данных User
            return "userinfo/success";
        }


}
