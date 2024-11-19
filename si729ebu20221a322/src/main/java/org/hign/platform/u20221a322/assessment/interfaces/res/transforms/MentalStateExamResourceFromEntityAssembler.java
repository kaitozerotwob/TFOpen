package org.hign.platform.u20221a322.assessment.interfaces.res.transforms;

import org.hign.platform.u20221a322.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u20221a322.assessment.interfaces.res.resources.MentalStateExamResource;

public class MentalStateExamResourceFromEntityAssembler {

    /**
     * <p>
     *     Converts a {@link MentalStateExam} entity to a {@link MentalStateExamResource}.
     *     This method is used to convert the entity to a resource that can be returned in the response.
     *     The resource is a representation of the entity that is returned to the client.
     * </p>
     * @param entity The {@link MentalStateExam} entity to convert to a resource.
     * @return The {@link MentalStateExamResource} representation of the entity.
     * @see MentalStateExam
     * @author Alex Avila Asto (u20221a322)
     */
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier().nationalProviderIdentifier(),
                entity.getInformation().examDate(),
                entity.getInformation().orientationScore(),
                entity.getInformation().registrationScore(),
                entity.getInformation().attentionAndCalculationScore(),
                entity.getInformation().recallScore(),
                entity.getInformation().languageScore()
        );
    }
}
