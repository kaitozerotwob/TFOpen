package org.hign.platform.u20221a322.personnel.application.internal.queryservices;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;
import org.hign.platform.u20221a322.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.u20221a322.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hign.platform.u20221a322.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService{

    private final ExaminerRepository examinersRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinersRepository = examinerRepository;
    }

    /**
     * <p>
     *     Query an examiner by the national provider identifier
     * </p>
     * @author Alex Avila Asto (u20221a322)
     */
    @Override
    public Optional<Examiner> handle(GetExaminerByNationalIdentifierId query) {
        return examinersRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(query.nationalIdentifierId()));
    }
}
