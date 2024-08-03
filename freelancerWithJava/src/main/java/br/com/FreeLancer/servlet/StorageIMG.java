package br.com.FreeLancer.servlet;

import br.com.FreeLancer.controller.userController;
import br.com.FreeLancer.model.User;
import com.google.protobuf.compiler.PluginProtos;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload2.jakarta.JakartaServletDiskFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet("/StorageIMG")
public class StorageIMG extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);

        FileItem imagem = null;


        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items = upload.parseRequest(req);

            for(FileItem item : items){
                imagem = item;
            }

            User user = (User) req.getSession().getAttribute("user");
            userController usc = new userController();
            usc.insertImg(imagem,user);

        }catch (Exception e){
            System.out.println("ERROR SERVLET STORAGE:" +e.getMessage());
        }

        resp.sendRedirect("homeCad.jsp");
    }
}
