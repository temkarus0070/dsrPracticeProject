package org.temkarus0070.dsrpracticeproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;


/*
TODO
 */
@Getter
@Setter
public class ProgrammingLanguage {
    @Id
    private String name;
}
