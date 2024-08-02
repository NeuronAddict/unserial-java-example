import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private record Message(String message, String author) {}

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Message message = new Message("hello!", "Miss Marple");
        System.out.println(message);

        String serialized = objectMapper.writeValueAsString(message);
        System.out.println(serialized);

        Message deserialized = objectMapper.readValue(serialized, Message.class);
        System.out.println(deserialized);

        assert deserialized.equals(message);
    }
}
