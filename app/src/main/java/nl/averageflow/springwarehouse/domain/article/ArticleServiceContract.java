package nl.averageflow.springwarehouse.domain.article;

import nl.averageflow.springwarehouse.domain.article.model.Article;
import nl.averageflow.springwarehouse.domain.article.dto.AddArticlesRequestItem;
import nl.averageflow.springwarehouse.domain.article.dto.EditArticleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ArticleServiceContract {
    Page<Article> getArticles(final Pageable pageable);

    Optional<Article> getArticleByUid(final UUID uid);

    void addArticles(final Iterable<AddArticlesRequestItem> rawItems);

    Article editArticle(final UUID uid, final EditArticleRequest request);

    void deleteArticleByUid(final UUID uid);
}
