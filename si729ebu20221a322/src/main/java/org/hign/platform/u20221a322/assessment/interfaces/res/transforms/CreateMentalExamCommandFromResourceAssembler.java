package org.hign.platform.u20221a322.assessment.interfaces.res.transforms;

import org.hign.platform.u20221a322.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u20221a322.assessment.interfaces.res.resources.CreateMentalExamResource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMentalExamCommandFromResourceAssembler {

    /**
     * <p>
     *     Converts a CreateMentalExamResource to a CreateMentalStateExamCommand
     *     <br>
     *     Constraints:
     *     <ul>
     *         <li>examDate must be in the format yyyy-MM-dd</li>
     *         <li>MentalState validation is done in the {@link CreateMentalStateExamCommand} constructor</li>
     *     </ul>
     * </p>
     * @param resource as {@link CreateMentalExamResource}
     * @return a {@link CreateMentalStateExamCommand}
     * @throws RuntimeException if the exam date is not in the format yyyy-MM-dd
     * @see CreateMentalStateExamCommand
     * @see CreateMentalExamResource
     * @see SimpleDateFormat
     * @author Alex Avila Asto (u20221a322)
     */
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalExamResource resource) {
        Date examDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            examDate = formatter.parse(resource.examDate());
        } catch (Exception e) {
            System.out.println("cannot parse date" + resource.examDate()    );
            throw new RuntimeException("Provide a valid date format, e.g. yyyy-MM-dd");
        }
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                examDate,
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
