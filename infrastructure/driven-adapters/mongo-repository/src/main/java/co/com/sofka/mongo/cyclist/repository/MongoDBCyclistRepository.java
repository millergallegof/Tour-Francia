package co.com.sofka.mongo.cyclist.repository;

import co.com.sofka.mongo.cyclist.document.CyclistDocument;
import co.com.sofka.mongo.team.document.TeamDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBCyclistRepository extends ReactiveMongoRepository<CyclistDocument, String>, ReactiveQueryByExampleExecutor<CyclistDocument> {
}
