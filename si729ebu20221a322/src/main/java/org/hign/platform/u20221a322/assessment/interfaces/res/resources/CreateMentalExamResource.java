package org.hign.platform.u20221a322.assessment.interfaces.res.resources;

public record CreateMentalExamResource(
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        int orientationScore,
        int registrationScore,
        int attentionAndCalculationScore,
        int recallScore,
        int languageScore
) {
}
