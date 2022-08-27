package co.com.sofka.mongo.cyclist.repository;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.mongo.cyclist.document.CyclistDocument;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.team.document.TeamDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoCyclistRepositoryAdapter extends AdapterOperations<Cyclist, CyclistDocument, String, MongoDBCyclistRepository>
implements CyclistRepository
{

    public MongoCyclistRepositoryAdapter(MongoDBCyclistRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Cyclist.class));
    }
}
