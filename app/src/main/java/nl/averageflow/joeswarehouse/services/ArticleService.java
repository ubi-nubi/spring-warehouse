package nl.averageflow.joeswarehouse.services;

import nl.averageflow.joeswarehouse.models.Article;
import nl.averageflow.joeswarehouse.repositories.ArticleRepository;
import nl.averageflow.joeswarehouse.repositories.ArticleStocksRepository;
import nl.averageflow.joeswarehouse.requests.AddArticlesRequestItem;
import nl.averageflow.joeswarehouse.responses.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleStocksRepository articleStocksRepository;

    public ArticleResponse getArticles() {
        return new ArticleResponse(this.articleRepository.findAll());
    }

    public Optional<Article> getArticleByID(Long id) {
        return this.articleRepository.findById(id);
    }

    public List<Article> convertAddArticleRequestToMappedList(List<AddArticlesRequestItem> rawItems) {
        return rawItems.stream().map(this::articleRequestItemConverter).collect(Collectors.toList());
    }

    private Article articleRequestItemConverter(AddArticlesRequestItem rawItem) {
        Article article = new Article(rawItem);
        this.articleStocksRepository.save(article.getStock());
        return article;
    }

    public void addArticles(List<AddArticlesRequestItem> rawItems) {
        this.articleRepository.saveAll(this.convertAddArticleRequestToMappedList(rawItems));
    }

    public void deleteArticleByID(Long id) {
        this.articleRepository.deleteById(id);
    }
}
