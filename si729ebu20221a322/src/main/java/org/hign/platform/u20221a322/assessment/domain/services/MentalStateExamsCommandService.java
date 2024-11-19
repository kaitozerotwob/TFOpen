package org.hign.platform.u20221a322.assessment.domain.services;

import org.hign.platform.u20221a322.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u20221a322.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public  interface MentalStateExamsCommandService {

    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
