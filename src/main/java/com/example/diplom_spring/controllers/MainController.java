package com.example.diplom_spring.controllers;

import com.example.diplom_spring.models.Link;
import com.example.diplom_spring.repo.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private LinkRepository linkRepository;

    @GetMapping("/")
    public String index(Model model) {
//        вывод всех ссылок
        Iterable<Link> links = linkRepository.findAll();
        model.addAttribute("links", links);
        return "index";
    }
    //    получаем данные из формы
    @PostMapping("/")
    public String getLinks(
            @RequestParam String fullLink,
            @RequestParam String shortLink,
            Model model)
    {
//        сохраняем информацию, введеную пользователем
        model.addAttribute("fullLink", fullLink);
        model.addAttribute("shortLink", shortLink);
//        проверка на пустое поле
        if(fullLink.isEmpty() || shortLink.isEmpty()) {
            model.addAttribute("message", "Оба поля не должны быть пустыми!");
        }
//        проверка на одинаковую ссылку
        else if(linkRepository.existsByShortLink(shortLink)) {
            model.addAttribute("message", "Такое сокращение уже существует, введите другое!");
        } else {
            Link link = new Link(fullLink, shortLink);
            linkRepository.save(link);
            model.addAttribute("message", "Готово!");
//            очищаем поля при успешном созранении
            model.addAttribute("fullLink", "");
            model.addAttribute("shortLink", "");
        }
            model.addAttribute("links", linkRepository.findAll());
            return "index";
    }
}
