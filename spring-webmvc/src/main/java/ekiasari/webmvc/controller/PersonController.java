package ekiasari.webmvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ekiasari.webmvc.model.CreatePersonRequest;
import jakarta.validation.Valid;

@Controller
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> createPerson(@ModelAttribute @Valid CreatePersonRequest req,
            BindingResult bindingResult) {

        List<ObjectError> errors = bindingResult.getAllErrors();
        if (!errors.isEmpty()) {

            errors.forEach(err -> {
                System.out.println(err.getDefaultMessage());
            });

            return new ResponseEntity<>("you send invalid data", HttpStatus.BAD_REQUEST);
        }

        System.out.println(req);

        String response = new StringBuilder().append("Success create person ")
                .append(req.getFirstName()).append(" ")
                .append(req.getMiddleName()).append(" ")
                .append(req.getLastName()).append(" ")
                .append("with email ").append(req.getEmail()).append(" ")
                .append("with phone ").append(req.getPhone()).append(" ")
                .append("with street ").append(req.getAddress().getStreet()).append(" ")
                .append("with city ").append(req.getAddress().getCity()).append(" ")
                .append("with country ").append(req.getAddress().getCountry()).append(" ")
                .append("with postalCode ").append(req.getAddress().getPostalCode()).toString();

        return ResponseEntity.ok(response);
    }
}
