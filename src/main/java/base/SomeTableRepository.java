package base;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomeTableRepository extends ReactiveCrudRepository<SomeTable, Long> {
}
