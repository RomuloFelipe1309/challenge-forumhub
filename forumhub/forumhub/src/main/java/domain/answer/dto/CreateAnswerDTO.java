package domain.answer.dto;

public record CreateAnswerDTO(
        String message,
        Boolean solution,
        Boolean erased
) {
    public static final Object topic = ;

    public String message() {
        return message();
    }
}
