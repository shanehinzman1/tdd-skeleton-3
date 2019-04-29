import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleMicroTest {

    @Test
    public void examplesWork() {
        Example example = new Example();

        assertThat(example.message()).isEqualTo("Hello");
    }
}
