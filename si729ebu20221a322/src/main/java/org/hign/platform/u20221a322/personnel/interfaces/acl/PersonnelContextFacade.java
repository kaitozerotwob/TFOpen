package org.hign.platform.u20221a322.personnel.interfaces.acl;

import org.hign.platform.u20221a322.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;
import org.hign.platform.u20221a322.personnel.domain.services.ExaminerQueryService;
import org.springframework.stereotype.Service;

@Service
public class PersonnelContextFacade {

    private final ExaminerQueryService examinerQueryService;

    public PersonnelContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    /**
     * <p>
     *     Check if an examiner with the given national identifier id exists.
     *     We created a context facade to avoid corruption of the domain model.
     *     This is a good practice to avoid corruption of the domain model (ACL).
     * </p>
     * @author Alex Avila Asto (u20221a322)
     */
    public boolean existsExaminerByNationalIdentifierId(String nationalIdentifierId) {
        var query = new GetExaminerByNationalIdentifierId(nationalIdentifierId);
        return examinerQueryService.handle(query).isPresent();
    }
}
