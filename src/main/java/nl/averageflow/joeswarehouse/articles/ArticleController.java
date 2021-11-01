package nl.averageflow.joeswarehouse.articles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/articles")
    public ArticleResponse getArticles() {
        return this.articleService.getArticles();
    }

    @GetMapping("/api/articles/{id}")
    public Optional<Article> getArticle(@PathVariable Long id) {
        return this.articleService.getArticleByID(id);
    }

}
