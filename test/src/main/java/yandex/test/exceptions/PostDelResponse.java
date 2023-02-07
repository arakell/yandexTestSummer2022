package yandex.test.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDelResponse {

    private int code;
    private String message;

    public PostDelResponse() {
    }

    public PostDelResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }



}
