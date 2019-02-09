package br.com.caelum.fj36.rest.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.concurrent.atomic.AtomicLong;

@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
    private static final AtomicLong counter = new AtomicLong();

    private Long id;
    private String name;

    @Deprecated
    private Author() { }

    public Author(String name) {
        this.id = counter.incrementAndGet();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
