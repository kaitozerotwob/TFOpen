package org.hign.platform.u20221a322.personnel.domain.services;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

public interface ExaminerCommandService {

    Optional<Examiner> handle(CreateExaminerCommand command);
}
