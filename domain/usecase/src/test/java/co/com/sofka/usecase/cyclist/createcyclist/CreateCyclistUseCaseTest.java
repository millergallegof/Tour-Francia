package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

//se extiende de mockitoextension.class
@ExtendWith(MockitoExtension.class)
class CreateCyclistUseCaseTest {

//    se inyecta el mock del caso de uso que se va a probar
    @InjectMocks
    CreateCyclistUseCase createCyclistUseCase;

//    se mockea el repositorio
    @Mock
    CyclistRepository cyclistRepository;

//    se hace le metodo del test unitario
    @Test
    public void createCyclist() {

//        ---------------------------------------------------------------
//        ARRANGE
//        ---------------------------------------------------------------
//        se definen los requisitos que tiene el tes
//        se inicializan los elementos a validar
//        en este caso se simula la creacion de un ciclista
        Cyclist cyclist = new Cyclist("1", "Miller", 124, null, "colombia");

//        ---------------------------------------------------------------
//        ACT
//        ---------------------------------------------------------------
//        se ejecuta el test
//        1. cuando se guarde un elemento de tipo ciclista
//        2. luego retorneme un mono ciclista
        when(cyclistRepository.save(Mockito.any(Cyclist.class))).thenReturn(Mono.just(cyclist));

//        ---------------------------------------------------------------
//        ASSERT
//        ---------------------------------------------------------------
//        en este punto se validan las igualdades de lo que retorna la simulacion anterior

        StepVerifier.create(createCyclistUseCase.createCyclist(cyclist))
//                .expectNextMatches(cyclist1 -> cyclist1.getNameCyclist().equals("Miller"))
                .expectNext(cyclist)
                .expectComplete()
                .verify();

    }


}