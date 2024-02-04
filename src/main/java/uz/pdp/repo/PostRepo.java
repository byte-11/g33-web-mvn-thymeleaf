package uz.pdp.repo;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.pdp.entity.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Getter
public class PostRepo {
    private List<Post> posts;

    @PostConstruct
    public void init(){
        posts = List.of(
                new Post("1", "Title1", "Context1", "Author1", new Date()),
                new Post("2", "Title2", "Context2", "Author2", new Date()),
                new Post("3", "Title3", "Context3", "Author3", new Date()),
                new Post("4", "Title4", "Context4", "Author4", new Date()),
                new Post("5", "Title5", "Context5", "Author5", new Date()),
                new Post("6", "Title6", "Context6", "Author6", new Date()),
                new Post("7", "Title7", "Context7", "Author7", new Date()),
                new Post("8", "Title8", "Context8", "Author8", new Date()),
                new Post("9", "Title9", "Context9", "Author9", new Date())
        );
    }

    public Post getById(String id){
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
