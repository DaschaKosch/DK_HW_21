package tests.examples;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo; // ИМПОРТ ДЛЯ equalTo

public class AuthTest {

    @Test
    public void testAuthClasspath() throws Exception {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        // ИСПРАВЛЕНО: правильный синтаксис Hamcrest
        assertThat(config.username(), equalTo("secret-user"));
        assertThat(config.password(), equalTo("secret-pass"));
    }

    @Test
    public void testAuthWithSecretFile() {
        String content = "username=secret-user\npassword=secret-pass";
        Path secret = Paths.get("/tmp/secret.properties");

        try {
            // ИСПРАВЛЕНО: используем writeString вместо write
            Files.writeString(secret, content);

            // Создаем конфиг и проверяем
            AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
            assertThat(config.username(), equalTo("secret-user"));
            assertThat(config.password(), equalTo("secret-pass"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // ИСПРАВЛЕНО: удаляем файл в finally
            try {
                Files.deleteIfExists(secret);
            } catch (IOException e) {
                System.err.println("Не удалось удалить файл: " + e.getMessage());
            }
        }
    }
}

