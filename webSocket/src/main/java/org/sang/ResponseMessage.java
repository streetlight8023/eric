package org.sang;

public class ResponseMessage {
    private String responseMessage;

    private int[] responseArrayMessage;

    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public ResponseMessage(int[] responseArrayMessage) {
        this.responseArrayMessage = responseArrayMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int[] getResponseArrayMessage() {
        return responseArrayMessage;
    }

    public void setResponseArrayMessage(int[] responseArrayMessage) {
        this.responseArrayMessage = responseArrayMessage;
    }
}
