package commandLineClient.service;


import commandLineClient.entity.Comment;
import commandLineClient.entity.Post;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BlogAPIResponsePrinter {


    private static String dateFormat = "dd.MM.yyyy";

    public static void print(Post post, Comment[] comments) {
        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
        StringBuilder sb = new StringBuilder();
        sb.append("Id: " + post.getId() + ClientService.newline);
        sb.append("Title: " + post.getTitle() + ClientService.newline);
        sb.append("Post: " + ClientService.newline +
                "    " + WordUtils.wrap(post.getContent(), 80) + ClientService.newline);
        sb.append("Comments:" + ClientService.newline);

        for (Comment c : comments) {
            sb.append("Comment: " + ClientService.newline +
                    StringUtils.repeat(ClientService.indention, c.getLevel()) + dateFormatter.format(c.getTime_created()) + ClientService.newline +
                    StringUtils.repeat(ClientService.indention, c.getLevel()) + c.getContent() + ClientService.newline);
        }
        System.out.println(sb.toString());
    }

    public static void print(Post[] posts) {
        StringBuilder sb = new StringBuilder();
        for (Post p: posts) {
            sb.append("Id: " + p.getId() + ClientService.newline);
            sb.append("Title: " + p.getTitle() + ClientService.newline);
            sb.append("----------------------------------------" + ClientService.newline);
        }
       /* int deleteFrom = sb.lastIndexOf(newline);
        sb.replace(sb.lastIndexOf(newline), sb.lastIndexOf() "");*/
        System.out.println(sb.toString());
    }
}
