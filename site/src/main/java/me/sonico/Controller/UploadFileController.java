//package me.sonico.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by yanfa_4 on 2016-11-07.
// */
//@Controller
//@RequestMapping(value = "/upload")
//public class UploadFileController {
//    @Autowired
//    private HttpServletRequest request;
//    //    produces = MediaType.TEXT_PLAIN_VALUE,
//
//    @RequestMapping(value = "fileUpload", method = RequestMethod.POST, headers = "content-type=multipart/*")
//    public String fileUpload(@RequestParam("file") MultipartFile file[], HttpServletResponse response) {
//        // 判断文件是否为空
//        for (int i = 0; i < file.length; i++) {
//            if (!file[i].isEmpty()) {
//                String filePath = request.getSession().getServletContext().getRealPath("/") + File.separator + "upload" + File.separator + file[i].getOriginalFilename();//感觉是不是对文件名裁剪空格后保存比较好？
//                System.out.println(filePath);
//                try {
//                    File fileBase = new File(filePath);
//                    if (!fileBase.exists())
//                        fileBase.createNewFile();
//                    //转存文件
//                    file[i].transferTo(fileBase);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        // 重定向
//        return "redirect:/admin/index.jsp";
//    }
//
//    @RequestMapping("/down")
//    public void writeTo(HttpServletResponse respons) {
//        String filePath = request.getSession().getServletContext().getRealPath("/") + File.separator + "upload" + File.separator + "JavaWeb.md";//感觉是不是对文件名裁剪空格后保存比较好？
//       System.out.println(filePath);
//        OutputStream os = null;
//        InputStream is = null;
//        try {
//            File fileBase = new File(filePath);
//            if (fileBase.exists()) {
//                is = new FileInputStream(fileBase);
//                respons.setCharacterEncoding("UTF-8");
//                os = respons.getOutputStream();
//                byte[] b = new byte[1024];
//                while (is.read(b) != -1) {
//                    os.write(b);
//                }
//            }
//            //转存文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (os != null) {
//                    os.flush();
//                    os.close();
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
