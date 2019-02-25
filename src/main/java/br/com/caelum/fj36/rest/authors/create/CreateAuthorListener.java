package br.com.caelum.fj36.rest.authors.create;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorListener {

    @EventListener
    public void createdAuthor(CreatedAuthor event) {

        System.out.println(event);
        Thread thread = Thread.currentThread();

        System.out.println("\n\n\n\n");
        System.out.println(String.format("[LISTENER] Thread '%s' with id '%s'", thread.getName(), thread.getId()));
        System.out.println("\n\n\n\n");
    }
}
