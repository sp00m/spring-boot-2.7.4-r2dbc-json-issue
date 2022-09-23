package base;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

@Testcontainers
@SpringBootTest(classes = Application.class)
@Import(MysqlConfig.class)
public class SomeTableRepositoryTest {

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.7");

    @DynamicPropertySource
    static void registerDynamicProperties(DynamicPropertyRegistry registry) {
        String url = String.format(
                "r2dbc:mariadb://%s:%d/%s?tlsProtocol=TLSv1.2",
                mysql.getHost(),
                mysql.getFirstMappedPort(),
                mysql.getDatabaseName()
        );
        registry.add("spring.r2dbc.url", () -> url);
        registry.add("spring.r2dbc.username", mysql::getUsername);
        registry.add("spring.r2dbc.password", mysql::getPassword);
    }

    @Autowired
    private SomeTableRepository someTableRepository;

    @Test
    public void findById() {
        StepVerifier
                .create(someTableRepository.findById(1L))
                .expectNext(new SomeTable(1L, "{}"))
                .verifyComplete();
    }

}
