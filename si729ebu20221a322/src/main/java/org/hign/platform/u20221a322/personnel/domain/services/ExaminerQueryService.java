package org.hign.platform.u20221a322.personnel.domain.services;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;

import java.util.Optional;

public interface ExaminerQueryService {

    Optional<Examiner> handle(GetExaminerByNationalIdentifierId query);
}
