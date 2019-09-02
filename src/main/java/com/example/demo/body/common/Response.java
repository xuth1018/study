package com.example.demo.body.common;

public  class Response {
    private String message;
    private String status;
    private Object content;

    public Response() {
    }

    public Response(String message, String status, Object content) {
        this.message = message;
        this.status = status;
        this.content = content;
    }

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getContent() {
        return content;
    }
    public void setContent(Object content) {
        this.content = content;
    }

    public static Response Ok(String status,String message,Object content){
        return new Response(status,message,content);
    }

    public static Response Ok(String status,String message){
        return new Response(status,message);
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
