package org.hign.platform.u20221a322.personnel.domain.model.exception;

/**
 * Exception thrown when an examiner with a given National Provider Identifier already exists
 */
public class ExaminerWithNationalProviderIdentifierAlreadyExitsException extends RuntimeException {
    public ExaminerWithNationalProviderIdentifierAlreadyExitsException() {
        super("Examiner with National Provider Identifier already exists");
    }
}
