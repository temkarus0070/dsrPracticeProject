package org.temkarus0070.dsrpracticeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.temkarus0070.dsrpracticeproject.entities.ProgrammingLanguage;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguagesView;
import org.temkarus0070.dsrpracticeproject.repositories.ProgrammingLanguagesRepository;

import java.util.List;

@Service
public class ProgrammingLanguagesService {
    @Autowired
    private ProgrammingLanguagesRepository programmingLanguagesRepository;

    public List<ProgrammingLanguagesView> getSimpleList() {
        return programmingLanguagesRepository.findAllBy();
    }

    public ProgrammingLanguagesView get(String name) {
        return programmingLanguagesRepository.findProgrammingLanguagesByNameLikeIgnoreCase(name);
    }

    public void create(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesRepository.save(programmingLanguage);
    }
}
