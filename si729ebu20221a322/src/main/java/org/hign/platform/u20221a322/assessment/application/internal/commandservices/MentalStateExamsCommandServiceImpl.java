package org.hign.platform.u20221a322.assessment.application.internal.commandservices;

import org.hign.platform.u20221a322.assessment.application.internal.outboundservices.acl.ExternalPersonnelService;
import org.hign.platform.u20221a322.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u20221a322.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u20221a322.assessment.domain.services.MentalStateExamsCommandService;
import org.hign.platform.u20221a322.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentalStateExamsCommandServiceImpl implements MentalStateExamsCommandService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalPersonnelService externalPersonnelService;

    public MentalStateExamsCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalPersonnelService externalPersonnelService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalPersonnelService = externalPersonnelService;
    }

    /**
     * <p>
     * This method is responsible for handling the creation of a mental state exam
     * Using context facade to check if the examiner exists before creating the exam {@link ExternalPersonnelService#existsExaminerByNationalIdentifierId(String)}
     * Constrains:
     * - The examiner must exist
     * - The examiner must have a valid national identifier
     * - The exam date must be before the current date
     * - The orientation score must be an integer between 0 and 10
     * - The registration score must be an integer between 0 and 3
     * - The attention and calculation score must be an integer between 0 and 5
     * - The recall score must be an integer between 0 and 3
     * - The language score must be an integer between 0 and 9
     * - The patient ID cannot be null
     * </p>
     * @return Optional<MentalStateExam>
     * @author Alex Avila Asto (u20221a322)
     */
    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        if (!externalPersonnelService.existsExaminerByNationalIdentifierId(command.examinerNationalProviderIdentifier())) {
            throw new RuntimeException("We cannot find the examiner with the provided national identifier");
        }
        var mentalStateExam = new MentalStateExam(command);
        return Optional.of(mentalStateExamRepository.save(mentalStateExam));
    }
}
