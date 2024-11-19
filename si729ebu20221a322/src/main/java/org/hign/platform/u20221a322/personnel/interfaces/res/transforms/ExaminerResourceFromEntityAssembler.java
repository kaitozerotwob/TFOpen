package org.hign.platform.u20221a322.personnel.interfaces.res.transforms;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.personnel.interfaces.res.resources.ExaminerResource;

public class ExaminerResourceFromEntityAssembler {

    /**
     * <p>
     *     Converts an entity to a resource.
     *     Part of usage of CQRS pattern.
     * </p>
     * @param entity as {Examiner}
     * @return resource as {ExaminerResource}
     * @author Alex Avila Asto (u20221a322)
     */
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getInformation().firstName(),
                entity.getInformation().lastName(),
                entity.getNationalProviderIdentifier().nationalProviderIdentifier()
        );
    }
}
