package net.web;

import net.domain.News;
import net.service.NewsService;
import net.service.PhotoService;
import net.domain.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/upload")
@MultipartConfig
public class PhotoController extends HttpServlet {
    @Autowired
    PhotoService photoService;
    @Autowired
    NewsService newsService;

    public void init(ServletConfig config) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    @RequestMapping(value = "/add/photo/", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        //MySQL
        /*Blob blob = photoService.getById(id).getPhoto();

        byte byteArray[] = new byte[0];
        try {
            byteArray = blob.getBytes(1, (int)blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("image/jpg");
        OutputStream os = response.getOutputStream();
        os.write(byteArray);
        os.flush();
        os.close();
        */

        response.setContentType("image/jpg");
        OutputStream os = response.getOutputStream();
        os.write(photoService.getById(id).getPhoto());
        os.flush();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        process(request, id);
        response.sendRedirect("/edit/news/"+id);
    }

    void process(HttpServletRequest request, int id) throws IOException {
        request.setCharacterEncoding("Utf-8");
        Photo photo = new Photo();

        //MySQL
        /*try {
            InputStream st = request.getPart("photo").getInputStream();
            Blob blob = photoService.createBlob(st);
            photo.setPhoto(blob);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        photo.setExtention("png");
        List<News> list = new ArrayList<>();
        list.add(newsService.getById(id));
        photo.setNews(list);
        photoService.add(photo);
        */

        try {
            InputStream st = request.getPart("photo").getInputStream();

            byte byteArray[] = new byte[st.available()];
            st.read(byteArray);
            photo.setPhoto(byteArray);
        } catch (ServletException e) {
            e.printStackTrace();
        }

        photo.setExtention("png");
        List<News> list = new ArrayList<>();
        list.add(newsService.getById(id));
        photo.setNews(list);
        photoService.add(photo);
    }

}
