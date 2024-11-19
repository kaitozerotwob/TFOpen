package org.hign.platform.u20221a322.assessment.interfaces.res;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u20221a322.assessment.domain.services.MentalStateExamsCommandService;
import org.hign.platform.u20221a322.assessment.interfaces.res.resources.CreateMentalExamResource;
import org.hign.platform.u20221a322.assessment.interfaces.res.resources.MentalStateExamResource;
import org.hign.platform.u20221a322.assessment.interfaces.res.transforms.CreateMentalExamCommandFromResourceAssembler;
import org.hign.platform.u20221a322.assessment.interfaces.res.transforms.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Mental State Exams Management Endpoints")
public class MentalStateExamsController {

    private final MentalStateExamsCommandService mentalStateExamsCommandService;

    public MentalStateExamsController(MentalStateExamsCommandService mentalStateExamsCommandService) {
        this.mentalStateExamsCommandService = mentalStateExamsCommandService;
    }

    /**
     * <p>
     *     Create a new mental state exam.
     *     <br>
     *     Provide a valid examiner National Provider Identifier following uuid v4 format, e.g. 123e4567-e89b-12d3-a456-426614174000
     *     And a valid date format, e.g. yyyy-MM-dd
     *     <br>
     * </p>
     * @param resource as {@link CreateMentalExamResource}
     * @return a {@link ResponseEntity<MentalStateExamResource>}
     * @see CreateMentalExamResource
     * @see MentalStateExamResource
     * @author Alex Avila Asto (u20221a322)
     */
    @Operation(summary = "Create a new mental state exam",
            description = "Provide a valid examiner National Provider Identifier following uuid v4 format, e.g. 123e4567-e89b-12d3-a456-426614174000\nAnd a valid date format, e.g. yyyy-MM-dd"
    )
    @PostMapping
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalExamResource resource) {
        var command = CreateMentalExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExamsCommandService.handle(command).orElseThrow(() -> new RuntimeException("An error occurred while creating mental state exam"));
        var mentalStateExamResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam);
        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);
    }
}
