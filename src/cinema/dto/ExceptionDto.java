package cinema.dto;

public class ExceptionDto {

    private String error;

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public ExceptionDto(String error) {
        this.error = error;
    }
}
