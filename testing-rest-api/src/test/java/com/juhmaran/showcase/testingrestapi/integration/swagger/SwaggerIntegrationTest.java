package com.juhmaran.showcase.testingrestapi.integration.swagger;

import com.juhmaran.showcase.testingrestapi.config.ConfigTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest {

    @Test
    @DisplayName("JUnit test for Should Display Swagger UI Page")
    void testShouldDisplaySwaggerUiPage() {
        var content = given()
                .basePath(ConfigTest.SWAGGER_BASE_PATH)
                .port(ConfigTest.SERVER_PORT)
                .when().get()
                .then().statusCode(200)
                .extract().body().asString();
        assertTrue(content.contains("Swagger UI"));
    }
}
