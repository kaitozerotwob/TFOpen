package org.hign.platform.u20221a322.assessment.interfaces.res.resources;

import java.util.Date;

public record MentalStateExamResource(
        Long id,
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        int orientationScore,
        int registrationScore,
        int attentionAndCalculationScore,
        int recallScore,
        int languageScore
) {
}
