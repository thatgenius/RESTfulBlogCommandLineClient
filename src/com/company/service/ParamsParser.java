package com.company.service;

import com.company.entity.Post;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsParser {

    public static boolean parse(String[] params) {
        int argsCount = params.length;
        switch(argsCount){
            case 1 : return false;
            case 2 : return parseTwoArgs(params);
            default: return multipleArgs(params);
        }
    }

    private static boolean parseTwoArgs(String[] params) {
        switch(params[0].toLowerCase()) {
            case "get" : return parseGet(params);
            case "update" : break;
            case "create" : break;
            case "delete" : return deletePostByIdSecured(params);
        }
        return false;
    }

    private static boolean parseGet(String[] params) {
        switch (params[1].toLowerCase()) {
            case "all" : return getPosts();
            default: return getPostByIdSecured(params);
        }
    }

    private static boolean getPostByIdSecured(String[] params) {
        try {
            int arg2 = Integer.valueOf(params[1]);
            return getPostById(arg2);
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static boolean getPostById(int id) {
        Post post = RESTService.getPostById(id);
        if (post == null) System.out.println("Post with id " + id + " does not exist");
        else BlogAPIResponsePrinter.print(post);
        return true;
    }

    private static boolean getPosts() {
        Post[] posts = RESTService.getPosts();
        if (posts == null) System.out.println("No posts have been posted yet");
        else BlogAPIResponsePrinter.print(posts);
        return true;
    }

    private static boolean deletePostByIdSecured(String[] params) {
        try {
            int arg2 = Integer.valueOf(params[1]);
            return deletePostById(arg2);
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    private static boolean deletePostById(int id) {
        Post post = RESTService.deletePost(id);
        if (post == null) System.out.println("Post with id " + id + " does not exist");
        else System.out.println("Post with id " + id + " has been deleted successfully");
        return true;
    }

    private static boolean multipleArgs(String[] params) {
        if (params[0].toLowerCase().equalsIgnoreCase("create")) {
            return parseCreate(params);
        }
        return false;
    }

    private static boolean parseCreate(String[] params) {



        if (params[1].toLowerCase().startsWith("title") && params[2].toLowerCase().startsWith("content")) {
            // take substring simply from first quote until the last one
            /*Post post = new Post();
            String title;


            Pattern pattern = Pattern.compile("'(.*?)'");
            Matcher matcher = pattern.matcher(params[1]);
            if (matcher.find())
            {
                post.setTitle(matcher.group(1));
                System.out.println(matcher.group(1));
            }
            pattern.matcher(params[2]);
            if (matcher.find())
            {
                post.setContent(matcher.group(1));
                System.out.println(matcher.group(1));
            }*/

        }

        return false;
    }

    public static String[] getParams(String str) {
        String[] strs = str.split(" ");
        int i = 0;
        for (String s : strs) {
            if (!s.isEmpty()) strs[i++] = s;
        }
        return Arrays.copyOf(strs, i);
    }



    /*private static boolean parseCreate(String[] params) {



        return false;
    }

    private static boolean createPost(String[] ) {

        return false;
    }*/













        // create

        // update

        // delete


}

