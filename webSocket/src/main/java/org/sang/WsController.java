package org.sang;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;

@Controller
public class WsController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) throws InterruptedException {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }

    @PostConstruct
    public void getKline() {
        new Thread(new RandomNum(simpMessagingTemplate)).start();
    }


    class RandomNum implements Runnable {

        private SimpMessagingTemplate simpMessagingTemplate;

        RandomNum(SimpMessagingTemplate simpMessagingTemplate) {
            this.simpMessagingTemplate = simpMessagingTemplate;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    sendRondeNum();
                    Thread.sleep(1000 * 2);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void sendRondeNum() throws InterruptedException {
            this.simpMessagingTemplate.convertAndSend("/topic/getKlineResponse", new ResponseMessage(getArray()));
        }

        public int[] getArray() {
            int arr[] = {getRandomNum(), getRandomNum(), getRandomNum(), getRandomNum(), getRandomNum(), getRandomNum()};
            return arr;
        }

        public int getRandomNum() {
            int max = 20;
            int min = 10;
            Random random = new Random();
            return (random.nextInt(max) % (max - min + 1) + min);
        }
    }


}
