package br.com.caelum.fj36.rest.books.updateBasicInfo;

import br.com.caelum.fj36.rest.books.BookController;
import br.com.caelum.fj36.rest.books.BookInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.noContent;

@BookController
class UpdateBasicInfoController {

    private final UpdateBasicInfoService service;

    UpdateBasicInfoController(UpdateBasicInfoService service) {
        this.service = service;
    }

    @PutMapping("{id}")
    ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid BookInfo basicInfo) {
        service.updateBy(id, basicInfo);

        return noContent().build();
    }
}