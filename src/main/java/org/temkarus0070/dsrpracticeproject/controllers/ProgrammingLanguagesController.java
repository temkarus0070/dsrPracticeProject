package org.temkarus0070.dsrpracticeproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.temkarus0070.dsrpracticeproject.entities.ProgrammingLanguage;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguagesView;
import org.temkarus0070.dsrpracticeproject.services.ProgrammingLanguagesService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController()
@RequestMapping("/programming-languages")
public class ProgrammingLanguagesController {
    @Autowired
    private ProgrammingLanguagesService programmingLanguagesService;

    @GetMapping
    public ResponseEntity<List<ProgrammingLanguagesView>> getAll() {
        return ResponseEntity.ok(programmingLanguagesService.getSimpleList());
    }

    @GetMapping("/programming-language")
    public ResponseEntity<ProgrammingLanguagesView> get(@RequestParam String language) {
        ProgrammingLanguagesView programmingLanguagesView = programmingLanguagesService.get(language);
        if (programmingLanguagesView != null) {
            return ResponseEntity.ok(programmingLanguagesView);
        } else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProgrammingLanguage programmingLanguage, HttpServletRequest request) throws URISyntaxException {
        programmingLanguagesService.create(programmingLanguage);
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();
        return ResponseEntity.created(new URI(String.format("%s/programming-languages/programming-language?name=%s", baseUrl, programmingLanguage.getName()))).build();
    }
}
