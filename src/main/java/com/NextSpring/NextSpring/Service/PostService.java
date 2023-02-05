package com.NextSpring.NextSpring.Service;


import com.NextSpring.NextSpring.Post;
import com.NextSpring.NextSpring.Repository.PostRepository;
import com.NextSpring.NextSpring.entity.PostData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    private final RestTemplate restTemplate;


    @Value("${api.jsonplaceholder}")
    private String api;
    private final PostRepository postRepository;
    private final PostDataService postDataService;

    public PostService(RestTemplate restTemplate,
                       PostRepository postRepository, PostDataService postDataService) {
        this.restTemplate = restTemplate;
        this.postRepository = postRepository;
        this.postDataService = postDataService;
    }

    public Post save(Post post){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        Post result = restTemplate.postForObject(this.api + "/posts", entity, Post.class);
        return result;
    }

    public Post update(Long id, Post post){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);
        Post result = restTemplate.exchange(api + "/posts/" + id + "/comments", HttpMethod.PUT, entity, Post.class).getBody();
        return result;
    }

    public Object findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Post[]> entity = new HttpEntity<>(headers);
        Post[] result = restTemplate.exchange(api + "/posts/", HttpMethod.GET, entity, Post[].class).getBody();
        postDataService.saveAll(result);
        return result;
    }

    public List<Post> findAllByQueryParam(Long postid){
        HttpEntity<List<Post>> entity = new HttpEntity<>(getHeaders());
        String urlTemolite = UriComponentsBuilder.fromHttpUrl(api + "/comments")
                .queryParam("postId", "{postId}")
                .encode()
                .toUriString();

        Map<String, Object> params = new HashMap<>();
        params.put("postId", postid);
        List<Post> result = restTemplate.exchange(urlTemolite,
                HttpMethod.GET,
                entity,
                List.class,
                params).getBody();
        return result;
    }


    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }


    public Page<PostData> findAll(Pageable pageable){
        return postDataService.findAll(pageable);
    }

}








