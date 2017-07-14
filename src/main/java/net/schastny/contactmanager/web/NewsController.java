package net.schastny.contactmanager.web;

import net.schastny.contactmanager.domain.News;
import net.schastny.contactmanager.domain.Photo;
import net.schastny.contactmanager.service.NewsService;
import net.schastny.contactmanager.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/delete/news/{newsId}")
    public String deleteContact(@PathVariable("newsId") Integer newsId) {

        newsService.remove(newsId);

        return "redirect:/news";
    }

    @RequestMapping("/delete/photo/{photoId}/{newsId}")
    public String deletePhoto(@PathVariable("photoId") Integer photoId, @PathVariable("newsId") Integer newsId, Model model) {

        photoService.remove(photoId);

        return "redirect:/edit/news/"+newsId;
    }

    @RequestMapping("/photo/{photoId}/getPhoto")
    public String showUser(@PathVariable("photoId") int photoId, Model model) {
        model.addAttribute("id", photoId);

        return "redirect:/add/photo";
    }

    @RequestMapping("/news")
    public String deleteContact(Map<String, Object> map) {

        map.put("newsList", newsService.getAll());

        return "news";
    }

    @RequestMapping(value = "/add/news", method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {

        map.put("news", new News());
        map.put("photolist", new ArrayList<Photo>());

        return "addnews";
    }

    @RequestMapping(value = "/info/news/{newsId}", method = RequestMethod.GET)
    public String infoNews(Map<String, Object> map, @PathVariable("newsId") Integer newsId) {

        map.put("news", newsService.getById(newsId));
        map.put("photoIdList", photoService.getByNewsId(newsId));

        return "newsInfo";
    }

    @RequestMapping(value = "/edit/news/{newsId}", method = RequestMethod.GET)
    public String editNews(Map<String, Object> map, @PathVariable("newsId") Integer newsId) {

        map.put("news", newsService.getById(newsId));
        map.put("photoIdList", photoService.getByNewsId(newsId));

        return "editNews";
    }

    @RequestMapping(value = "/add/news", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("news") News news,
                             BindingResult result) {

        news.setPostDate(new Date());
        newsService.add(news);

        return "redirect:/news";
    }

    @RequestMapping(value = "/update/news", method = RequestMethod.POST)
    public String updateContact(@ModelAttribute("news") News news,
                             BindingResult result) {

        newsService.update(news);
        return "redirect:/news/";
    }
}
