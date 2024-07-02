package qrcodeapi.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
    private String error;

    public String getError(){
        return error;
    }

    public void setError(String error){
        this.error = error;
    }
}
