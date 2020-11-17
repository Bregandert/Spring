package com.geekbrains.spring.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.security.ProtectionDomain;

//1. Создать сущность «товар» (id, название, стоимость) и соответствующую таблицу в БД. Заполнить таблицу тестовыми данными (20 записей).
//        2. Сделать страницу, в которую будут выведены эти записи.
//        3. С помощью GET-запроса указывать фильтрацию по:
//        a. только минимальной,
//        b. только максимальной,
//        c. или минимальной и максимальной цене (* - сделать две реализации, одну со спецификацией, другую с чистым репозиторием)
//
//        4. * Добавить постраничное отображение (по 5 записей на странице).
//        5. * Добавить сортировку по цене (ACS/DESC)

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}