package com.company.service;

import com.company.entity.Post;
import org.apache.commons.lang.WordUtils;

public class BlogAPIResponsePrinter {

    private static String newline = "\n";

    public static void print(Post post) {
            StringBuilder sb = new StringBuilder();
            sb.append("Id: " + post.getId() + newline);
            sb.append("Title: " + post.getTitle() + newline);
            sb.append("Post: " + WordUtils.wrap(post.getContent(), 80));
            System.out.println(sb.toString());
    }

    public static void print(Post[] posts) {
        StringBuilder sb = new StringBuilder();
        for (Post p: posts) {
            sb.append("Id: " + p.getId() + newline);
            sb.append("Title: " + p.getTitle() + newline);
            sb.append("----------------------------------------" + newline);
        }
       /* int deleteFrom = sb.lastIndexOf(newline);
        sb.replace(sb.lastIndexOf(newline), sb.lastIndexOf() "");*/
        System.out.println(sb.toString());
    }
}
