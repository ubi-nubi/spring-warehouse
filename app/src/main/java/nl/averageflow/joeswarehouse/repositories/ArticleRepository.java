package nl.averageflow.joeswarehouse.repositories;

import nl.averageflow.joeswarehouse.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ArticleRepository extends CrudRepository<Article, UUID> {
    @NonNull
    Optional<Article> findByItemId(@NonNull long itemId);

    @NonNull
    Optional<Article> findByUid(@NonNull UUID uid);

    @NonNull
    Set<Article> findAll();

    @Transactional
    void deleteByUid(@NonNull UUID uid);
}