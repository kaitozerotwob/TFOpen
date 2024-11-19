package org.hign.platform.u20221a322.personnel.application.internal.commandservices;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u20221a322.personnel.domain.model.exception.ExaminerWithNationalProviderIdentifierAlreadyExitsException;
import org.hign.platform.u20221a322.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u20221a322.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hign.platform.u20221a322.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * <p>
     *     Handle the creation of an examiner using the command {@link CreateExaminerCommand}
     *     <br>
     *     Constraints:
     *     <ul>
     *         <li>There must not be an examiner with the same national provider identifier {@link NationalProviderIdentifier}</li>
     *         <li>The national provider identifier must be unique</li>
     *     </ul>
     * </p>
     * @return an optional examiner if it was created, empty otherwise
     * @author Alex Avila Asto (u20221a322)
     */
    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (examinerRepository.existsByNationalProviderIdentifier(new NationalProviderIdentifier(command.nationalProviderIdentifier()))) {
            throw new ExaminerWithNationalProviderIdentifierAlreadyExitsException();
        }
        var examiner = new Examiner(command);
        return Optional.of(examinerRepository.save(examiner));
    }
}
