package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public List<Message> getAllMessagesByAccountId(int account_id) {
        return messageDAO.getAllMessagesByAccountId(account_id);
    }

    public Message getMessageById(int message_id) {
        return messageDAO.getMessageById(message_id);
    }

    public Message addMessage(Message message) {
        if (message == null){
            return null;
        }

        Message persistedMessage = messageDAO.addMessage(message);

        return persistedMessage;
    }

    public Message updateMessage(int message_id, Message message) {
        Message updatedMessage = messageDAO.getMessageById(message_id);

        if(updatedMessage == null){
            return null;
        } else{
            updatedMessage.setMessage_text(message.getMessage_text());
            return updatedMessage;
        }
    }

    public boolean deleteMessage(int message_id) {
        return messageDAO.deleteMessage(message_id);
    }

}