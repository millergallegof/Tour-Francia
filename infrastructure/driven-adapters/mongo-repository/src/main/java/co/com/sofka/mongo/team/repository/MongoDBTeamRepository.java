package co.com.sofka.mongo.team.repository;

import co.com.sofka.mongo.team.document.TeamDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBTeamRepository extends ReactiveMongoRepository<TeamDocument, String>, ReactiveQueryByExampleExecutor<TeamDocument> {
}
