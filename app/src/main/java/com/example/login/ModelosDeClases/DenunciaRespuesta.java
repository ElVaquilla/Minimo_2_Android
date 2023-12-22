package com.example.login.ModelosDeClases;

public class DenunciaRespuesta {
    Boolean success;
    String message;

    public DenunciaRespuesta(){
        this.success=false;
        this.message=null;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
