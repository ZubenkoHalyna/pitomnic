package net.web;

import net.domain.News;
import net.service.NewsService;
import net.service.PhotoService;
import net.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String deleteNews(@PathVariable("newsId") Integer newsId) {

        newsService.remove(newsId);

        return "redirect:/news";
    }

    @RequestMapping("/delete/photo/{photoId}/{newsId}")
    public String deletePhotoInNews(@PathVariable("photoId") Integer photoId, @PathVariable("newsId") Integer newsId, Model model) {

        photoService.remove(photoId);

        return "redirect:/edit/news/"+newsId;
    }

    @RequestMapping("/photo/{photoId}/getPhoto")
    public String showPhoto(@PathVariable("photoId") int photoId, Model model) {
        model.addAttribute("id", photoId);

        return "redirect:/add/photo";
    }

    @RequestMapping("/news")
    public String showNews(Map<String, Object> map) {
        map.put("newsList", newsService.getAll());
        return "news";
    }

    @RequestMapping(value = "/add/news", method = RequestMethod.GET)
    public String addNews(Map<String, Object> map) {
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
    public String addNews(@ModelAttribute("news") News news,
                             BindingResult result) {

        news.setPostDate(new Date());
        newsService.add(news);

        return "redirect:/news";
    }

    @RequestMapping(value = "/update/news", method = RequestMethod.POST)
    public String updateNews(@ModelAttribute("news") News news,
                             BindingResult result) {

        newsService.update(news);
        return "redirect:/news/";
    }
}
