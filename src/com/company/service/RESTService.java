package com.company.service;

import com.company.entity.AuthToken;
import com.company.entity.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


public class RESTService {

    static final String RESTServiceAddress = "http://localhost:8080/rest";

    //login and pass as follows: login:pass
    static final String RESTServicePassword = "Basic " ;

    private static String getCredentials() {
        return "Basic " + AuthToken.getEncoded();
    }

    public static Post getPostById(int id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = RESTServiceAddress + "/rest/posts/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getCredentials());
        HttpEntity<String> request = new HttpEntity<String>(headers);
        Post post = null;
        try {
            post = restTemplate.exchange(url, HttpMethod.GET, request, Post.class).getBody();
        }
        catch(RestClientException e) {
        }
        return post;
    }

    public static Post[] getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = RESTServiceAddress + "/rest/posts/";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getCredentials());
        HttpEntity<String> request = new HttpEntity<String>(headers);
        Post[] posts = restTemplate.exchange(url, HttpMethod.GET, request, Post[].class).getBody();
        return posts;
    }

    public static void createPost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getCredentials());
        HttpEntity request = new HttpEntity(post, headers);
        String url = RESTServiceAddress + "/rest/posts/";
        restTemplate.exchange(url, HttpMethod.POST, request, Post.class).getBody();
    }

    public static Post deletePost(int id) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getCredentials());
        HttpEntity request = new HttpEntity(headers);
        String url = RESTServiceAddress + "/rest/posts/" + id;
        return (Post) restTemplate.exchange(url, HttpMethod.DELETE, request, Post.class).getBody();
    }

    public static void updatePost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", getCredentials());
        HttpEntity request = new HttpEntity(post, headers);
        String url = RESTServiceAddress + "/rest/posts/" + post.getId();
        restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);
    }


}
