package com.NextSpring.NextSpring.Service;

import com.NextSpring.NextSpring.Post;
import com.NextSpring.NextSpring.Repository.PostDataRepository;
import com.NextSpring.NextSpring.Repository.PostRepository;
import com.NextSpring.NextSpring.entity.PostData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostDataService {

    private final PostDataRepository postDataRepository;

    public PostDataService(PostDataRepository postDataRepository,
                           PostRepository postRepository) {
        this.postDataRepository = postDataRepository;
    }

    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }

    public List<PostData> saveAll(Post[] posts){

        List<PostData> postDataList = new ArrayList<>();
        for (Post post: posts){
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setUserId(post.getUserId());
            postData.setTitle(post.getTitle());
            postData.setBody(post.getBody());
            postDataList.add(postData);
        }
//        tepadagi for bilan bir xil vazifani bajaradi pastdagi List

//        List<PostData> postDataList = posts
//                .stream()
//                .map(post -> {
//                    PostData postData = new PostData();
//                    postData.setPostId(post.getId());
//                    postData.setUserId(post.getUserId());
//                    postData.setTitle(post.getTitle());
//                    postData.setBody(post.getBody());
//                    return postData;
//                }).collect(Collectors.toList());
        return postDataRepository.saveAll(postDataList);
    }

    @Transactional(readOnly = true)
    public Page<PostData> findAll(Pageable pageable){
        return postDataRepository.findAll(pageable);
    }
}

