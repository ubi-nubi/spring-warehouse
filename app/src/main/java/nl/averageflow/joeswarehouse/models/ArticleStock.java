package nl.averageflow.joeswarehouse.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "article_stocks")
@Entity
public final class ArticleStock {
    @Id
    @SequenceGenerator(name = "article_stocks_sequence_generator", sequenceName = "article_stocks_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_stocks_sequence_generator")
    @NonNull
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "article_id")
    private Long articleId;

    @NonNull
    @Column(name = "stock", nullable = false)
    private Long stock;

    @NonNull
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @NonNull
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    protected ArticleStock() {
    }

    public ArticleStock(Long articleId, Long stock, Timestamp createdAt) {
        this.articleId = articleId;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public Long getStock() {
        return this.stock;
    }

    public Long getArticleId() {
        return this.articleId;
    }

}
